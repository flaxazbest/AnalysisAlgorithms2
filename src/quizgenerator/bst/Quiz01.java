package quizgenerator.bst;

/*

    Збалансоване дерев пошуку
    додавання 10 елементів у порожнє дерево

*/

import additional.InputArray;
import additional.Numeric;
import moodle.Question;
import moodle.Seed;
import bst.BST;

import java.util.Formatter;
import java.util.Random;

public class Quiz01 {

    private static int NUM = 31;
    private static int GEN = 12;
    private static int DEL = 3;

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        InputArray ia = new InputArray(GEN);
        Question q = new Question();
        Integer[] delList = new Integer[DEL];
        Random rnd = new Random();

        for (int i = 0; i < NUM; i++) {
            Seed seed = new Seed();

            Formatter fmt = new Formatter();
            fmt.format("seed = 0802%02d", i+1);
            seed.name.setText(fmt.toString());

            String s = "<pre>Початковий рівневий порядок БДП:<br />    ";
            bst.clear();
            for (int j = 0; j < GEN; j++)
                bst.put(ia.get(j), ia.get(j));
            s += bst.getlevelOrder() + " <br />Який буде рівневий порядок БДП після " + DEL +  " видалень Хібaрта наступних ключів?<br />   ";
            for (int j = 0; j < DEL; j++) {
                delList[j] = ia.get( rnd.nextInt(GEN/DEL) + j*(GEN/DEL) );
                s += " " + delList[j];
            }
            s += "<br /><br />";

            String f = "<br />Рівневий порядок БДП після кожного видалення:";
            for (int j = 0; j < DEL; j++) {
                bst.delete(delList[j]);
                f += "<br />" + delList[j] + ":  " + bst.getlevelOrder();
            }

            s += Numeric.toNumeric(bst.getlevelOrder()) + "</pre>";
            f += "</pre>";
            f = "<pre>Правильна відповідь: " + bst.getlevelOrder() + f;

            seed.questiontext.setText(s);
            seed.generalfeedback.setText(f);
            q.question.add(seed);

            ia.shuffle();
        }

        q.write("BST_02");
    }
}