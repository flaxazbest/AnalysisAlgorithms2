package quizgenerator.bst;

import additional.InputArray;
import additional.Numeric;
import bst.BST;
import moodle.Question;
import moodle.Seed;

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
            fmt.format("seed = 0801%02d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Напишіть рівневий порядок БДП яке утвориться після послідовного додавання наступних ключів у порожнє БДП:<br />    ";

            for (int j = 0; j < GEN; j++)
                s += ia.get(j+GEN) + " ";
            s += "<br /><br />";
            bst.clear();

            String f = "<br /><br />Рівневий порядок БДП після кожного додавання: ";
            for (int j = 0; j < GEN; j++) {
                bst.put(ia.get(j), ia.get(j));
                f += "<br />" + ia.get(j) + ":  " + bst.getlevelOrder();
            }
            s += Numeric.toNumeric(bst.getlevelOrder()) + "</pre>";
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
