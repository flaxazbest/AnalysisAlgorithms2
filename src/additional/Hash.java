package additional;

import java.util.Random;

public class Hash {

    private static char[] values = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S',
            'D', 'F', 'G', 'H','J', 'K', 'L', 'Z','X', 'C', 'V', 'B','N', 'M'  };

    private int SIZE;
    private int[] keys = new int[values.length];

    private void shuffle() {
        Random rnd = new Random();
        for (int i = 0; i < values.length; i++) {
            int r = rnd.nextInt(values.length);
            char tmp = values[i];
            values[i] = values[r];
            values[r] = tmp;
            keys[i] = rnd.nextInt(SIZE);
        }
    }

    public void genereteNext() {
        shuffle();
    }

    public Hash(int SIZE) {
        this.SIZE = SIZE;
        shuffle();
    }

    public int getKey(int n) {
        return keys[n];
    }

    public char getValue(int n) {
        return values[n];
    }

    public static void main(String[] args) {
        Hash h = new Hash(3);
        for (int i = 0; i < 10; i++) {
            System.out.println(h.getValue(i) + ": " + h.getKey(i));
        }
        System.out.println("======");
        h.genereteNext();
        for (int i = 0; i < 10; i++) {
            System.out.println(h.getValue(i) + ": " + h.getKey(i));
        }
    }

}
