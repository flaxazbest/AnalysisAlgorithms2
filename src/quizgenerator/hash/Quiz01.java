package quizgenerator.hash;

import algorithms.hash.SeparateChaining;
import moodle.qiuz.Question;
import moodle.qiuz.QuizTextAnswer;
import moodle.seed.Seed;
import moodle.seed.SeedShort;

import java.util.Formatter;

public class Quiz01 {

    private static int NUM = 41;
    private static int GEN = 12;
    private static int INS = 3;

    public Quiz01() {

    }

    public static void main(String[] args) {
        QuizTextAnswer q = new QuizTextAnswer();
        for (int i = 0; i < NUM; i++) {
            SeparateChaining sc = new SeparateChaining(INS, GEN);
            SeedShort seed = new SeedShort();

            Formatter fmt = new Formatter();
            fmt.format("seed = 0902%02d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Вставте наступну послідовність " + GEN + " символів в порожній розділений ланцюг хеш-таблиці з " +
                    INS + " ланцюгів:<br />key  hash<br />---  ----<br />";
            for (int j = 0; j < GEN; j++) {
                s += " " + sc.hash.getValue(j) + "    " + sc.hash.getKey(j) + "<br />";
            }
            s += "Розглянемо пошук неіснуючого елемента " + sc.hash.getValue(GEN) +
                    ", значення хеш-функції якого дорівнює " + sc.hash.getKey(GEN) + ". Які символи, та у якій послідовності, порівнюються з " +
                    sc.hash.getValue(GEN) + "?<br />(символи вводити великими латинськими літерами через пробіл)</pre>";
            seed.questiontext.setText(s);

            seed.answer.setText(sc.toString(sc.hash.getKey(GEN), false));

            s = "<pre>Розділений ланцюг хеш-таблиці буде мати наступний вигляд<br />";
            for (int j = 0;  j < INS; j++) {
                s += j + ":  " + sc.toString(j, true) + "<br />";
            }
            seed.generalfeedback.setText(s);

            q.question.add(seed);

        }
        q.write("HashTable_01");
    }
}
