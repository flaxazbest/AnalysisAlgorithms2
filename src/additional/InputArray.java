package additional;

import java.util.Random;

public class InputArray {

    private Integer[] a;
    private final Random rnd = new Random();
    private int size;

    public InputArray(int size) {
        this.size = size;
        a = new Integer[90];
        for (int i = 0; i < 90; i++)
            a[i] = i + 10;
        shuffle();
    }

    public Integer get(int n) {
        return a[n];
    }

    public void shuffle() {
        for (int i = 0; i < 90; i++) {
            int n = rnd.nextInt(90);
            int x = a[i];
            a[i] = a[n];
            a[n] = x;
        }
    }

    public Integer[] getArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++)
            arr[i] = a[i];
        return arr;
    }

    @Override
    public String toString() {
        String s = "";
        if (a.length == 0) s += "Empty";
        else {
            s += a[0];
            for (int i = 1; i < size; i++) {
                s += " " + a[i];
            }
        }
        return s;
    }
}
