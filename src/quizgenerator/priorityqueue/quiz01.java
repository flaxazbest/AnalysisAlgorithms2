package quizgenerator.priorityqueue;

/*

    Бінарне дерево з максимальним пріоритетом з 10 елементів,
    додати 3 і вивести результат

 */

import additional.InputArray;
import additional.Numeriacalizator;
import moodle.qiuz.Question;
import moodle.seed.Seed;
import algorithms.priorityqueue.MaxPQ;

import java.util.Formatter;

public class Quiz01 {

    private static int NUM = 5;
    private static int GEN = 10;
    private static int INS = 3;

    public static void main(String[] args) {
        MaxPQ<Integer> mpq = new MaxPQ<>(GEN + INS);
        InputArray ia = new InputArray(GEN + INS);
        Question q = new Question();

        for (int i = 0; i < NUM; i++) {
            Seed seed = new Seed();

            Formatter fmt = new Formatter();
            fmt.format("seed = 0701%02d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Напишіть послідовність " + (GEN+INS) + " значень у масиві після послідовної вставки наступних трьох елементів<br />    ";
            for (int j = 0; j < INS; j++)
                s += ia.get(j+GEN) + " ";
            s += "<br />в уже існуюче максимум-орієнтоване бінарне дерево з " + GEN + " елементів:<br />    ";
            mpq.clear();
            for (int j = 0; j < GEN; j++)
                mpq.insert(ia.get(j));
            s += mpq.toString() + "<br /><br /><br />";

            String f = "<br /><br />Послідовності після вставки кожного елемента:<br /><br />    " +
                    mpq.toString() + "<br />";
            int j = GEN;
            f += ia.get(j) + ": ";
            mpq.insert(ia.get(j++));
            f += mpq.toString();
            for (; j < INS+GEN; j++) {
                mpq.insert(ia.get(j));
                f += "<br />" + ia.get(j) + ": " + mpq.toString();
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

        q.write("PriorityQueue_01");
    }
}
