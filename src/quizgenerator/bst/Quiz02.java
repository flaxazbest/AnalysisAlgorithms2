package quizgenerator.bst;

import additional.InputArray;
import additional.Numeric;
import algorithms.bst.BST;
import moodle.qiuz.Question;
import moodle.seed.Seed;

import java.util.Formatter;

public class Quiz02 {
    private static int NUM = 31;
    private static int GEN = 10;

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        InputArray ia = new InputArray(GEN);
        Question q = new Question();

        for (int i = 0; i < NUM; i++) {
            Seed seed = new Seed();

            Formatter fmt = new Formatter();
            fmt.format("seed = 0801%01d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Напишіть рівневий порядок БДП яке утвориться після послідовного додавання наступних ключів у порожнє БДП:<br />    ";

            for (int j = 0; j < GEN; j++)
                //s += ia.get(j+GEN) + " ";
                s += ia.get(j) + " ";
            s += "<br /><br />";
            bst.clear();

            String f = "<br /><br />Рівневий порядок БДП після кожного додавання: ";
            for (int k = 0; k < GEN; k++) {
                bst.put(ia.get(k), ia.get(k));
                f += "<br />" + ia.get(k) + ":  " + bst.getlevelOrder();
            }
            String tmp = bst.getlevelOrder();
            s += Numeric.toNumeric(tmp) + "</pre>"; // тут помилка!!!!!!!
            f += "</pre>";
            f = "<pre>Правильна відповідь: " + bst.getlevelOrder() + f;

            seed.questiontext.setText(s);
            seed.generalfeedback.setText(f);
            q.question.add(seed);

            ia.shuffle();
        }

        q.write("BST_01");
    }
}
