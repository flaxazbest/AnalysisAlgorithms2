package quizgenerator.priorityqueue;

import additional.InputArray;
import additional.Numeriacalizator;
import moodle.qiuz.Question;
import moodle.seed.Seed;
import algorithms.priorityqueue.MaxPQ;

import java.util.Formatter;

public class Quiz02 {
    private static int NUM = 31;
    private static int GEN = 10;
    private static int DEL = 3;

    public static void main(String[] args) {
        MaxPQ<Integer> mpq = new MaxPQ<>(GEN);
        InputArray ia = new InputArray(GEN);
        Question q = new Question();

        for (int i = 0; i < NUM; i++) {
            Seed seed = new Seed();

            Formatter fmt = new Formatter();
            fmt.format("seed = 0702%02d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Напишіть значення елементів масиву з " + (GEN-DEL) + " значень, який утвориться після " +
                    DEL + " вилучень з черги з максимальним пріоритетом з масива " + GEN + " елементів<br /><br />    ";
            mpq.clear();
            for (int j = 0; j < GEN; j++)
                mpq.insert(ia.get(j));
            s += mpq.toString() + "<br /><br /><br />";

            String f = "<br />Значення елементів масиву після кожного вилучення:<br />              " +
                    mpq.toString() + "<br />";
            for (int j = 0; j < DEL; j++) {
                f += mpq.delMax() + " deleted :  ";
                f += mpq.toString() + "<br />";
            }
            f += "</pre>";
            f = "<pre>Правильна відповідь: " + mpq.toString() + f;
            seed.generalfeedback.setText(f);

            Numeriacalizator<Integer> numeriacalizator = new Numeriacalizator<>();
            s += numeriacalizator.toNumeric(mpq.getPq());
            seed.questiontext.setText(s);

            q.question.add(seed);

            ia.shuffle();
        }

        q.write("PriorityQueue_02");
    }
}
