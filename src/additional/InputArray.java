package additional;

import java.util.Random;

public class InputArray {

    private Integer[] a;

    public InputArray(int size) {
        a = new Integer[size];
        Random rnd = new Random();
        Integer[] t = new Integer[90];
        for (int i = 0; i < 90; i++)
            t[i] = i + 10;
        for (int i = 0; i < 90; i++) {
            int n = rnd.nextInt(90);
            int x = t[i];
            t[i] = t[n];
            t[n] = x;
        }
        for (int i = 0; i < size; i++)
            a[i] = t[i];
    }

    public Integer get(int n) {
        return a[n];
    }

    @Override
    public String toString() {
        String s = "";
        if (a.length == 0) s += "Empty";
        else {
            s += a[0];
            for (int i = 1; i < a.length; i++) {
                s += " " + a[i];
            }
        }
        return s;
    }
}
