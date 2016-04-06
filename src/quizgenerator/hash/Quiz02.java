package quizgenerator.hash;

import additional.SAClizator;
import algorithms.hash.LinearProbing;
import moodle.qiuz.Question;
import moodle.seed.Seed;

import java.util.Formatter;


public class Quiz02 {

    private static int NUM = 31;
    private static int MAX = 10;

    public static void main(String[] args) {
        Question q = new Question();
        LinearProbing lp = new LinearProbing();

        for (int i = 0; i < NUM; i++) {
            Seed seed = new Seed();

            Formatter fmt = new Formatter();
            fmt.format("seed = 0901%02d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Напишіть елементи масиву, що утвориться після вставлення 10 символів у лінійне-сканування хеш таблиці.<br />key  hash<br />---  ----<br />";
            for (int j = 0; j < MAX; j++) {
                s += lp.getFull(j) + "<br />";
            }
            s += "Розмірність масиву - 10 елеменів і не змінюється протягом виконання алгоритму.<br />";

            String f = "<pre>Вигляд масиву після кожного кроку вставлення:<br />";
            for (int j = 0; j < MAX; j++) {
                lp.insert(j);
                f += lp.getValue(j) + ":  " + lp.toString() + "<br />";
            }
            seed.generalfeedback.setText(f);

            s += SAClizator.toSAC(lp.toString()) + "</pre>";
            seed.questiontext.setText(s);

            q.question.add(seed);
            lp.refresh();
        }
        q.write("Hash_02");
    }
}
