package algorithms.hash;

import additional.SAClizator;

import java.util.Random;

public class LinearProbing {
    private static char[] values = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S',
            'D', 'F', 'G', 'H','J', 'K', 'L', 'Z','X', 'C', 'V', 'B','N', 'M'  };
    private static int[] keys;

    private int[] hash;
    private int SIZE;
    public static int MAX = 10;
    private Random rnd;

    private char[] line;

    public void refresh() {
        for (int i = 0; i < MAX; i++) {
            line[i] = '-';
            int r = rnd.nextInt(MAX);
            int tmp = keys[i];
            keys[i] = keys[r];
            keys[r] = tmp;
        }
        for (int i = 0; i < SIZE; i++) {
            int r = rnd.nextInt(SIZE);
            char tmp = values[i];
            values[i] = values[r];
            values[r] = tmp;
            hash[i] = keys[rnd.nextInt(MAX/2 + 1)];
        }
    }

    public String getFull(int no) {
        String s = " " + getValue(no) + "    " + getHash(no);
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < MAX-1; i++) {
            s += line[i] + " ";
        }
        s += line[MAX-1];
        return s;
    }

    public void insert(int no) {
        int x = getHash(no);
        while (line[x] != '-') {
            x++;
            if (x >= MAX) x = 0;
        }
        line[x] = getValue(no);
    }

    public int getHash(int no) {
        return hash[no];
    }

    public char getValue(int no) {
        return values[no];
    }

    public LinearProbing() {
        rnd = new Random();
        SIZE = values.length;
        line = new char[MAX];
        hash = new int[SIZE];
        keys = new int[MAX];
        for (int i= 0; i < MAX; i++) keys[i] = i;
        refresh();
    }

    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing();

        for (int i = 0; i < lp.MAX; i++) {
            System.out.println(lp.getFull(i));
        }
        System.out.println("");

        for (int i = 0; i < lp.MAX; i++) {
            lp.insert(i);
            System.out.print(lp.getValue(i) + ":  ");
            System.out.println(lp);
        }

        System.out.println(SAClizator.toSAC(lp.toString()));

        lp.refresh();
        for (int i = 0; i < lp.MAX; i++) {
            System.out.println(lp.getFull(i));
        }
        System.out.println("");

        for (int i = 0; i < lp.MAX; i++) {
            lp.insert(i);
            System.out.print(lp.getValue(i) + ":  ");
            System.out.println(lp);
        }

        System.out.println(SAClizator.toSAC(lp.toString()));
    }

}
