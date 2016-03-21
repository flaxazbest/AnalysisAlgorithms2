package priorityqueue;

import additional.InputArray;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    public void clear() {
        N = 0;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Empty";
        else {
            String s = ((Key)pq[1]).toString();
            for (int i = 2; i <= N; i++)
                s += " " + ((Key)pq[i]).toString();
            return s;
        }
    }

    public Key[] getPq() {
        Key[] res = (Key[]) new Comparable[N+1];
        for (int i = 0; i <= N; i++)
            res[i] = pq[i];
        return res;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> mpq = new MaxPQ<>(13);
        InputArray ia = new InputArray(13);
        System.out.println(ia);
        ia.shuffle();
        System.out.println(ia);

        for (int i = 0; i < 10; i++) {
            mpq.insert(ia.get(i));
        }

        System.out.println();
        System.out.println(mpq);
        for (int i = 10; i < 13; i++) {
            mpq.insert(ia.get(i));
            System.out.println(mpq);
        }
    }

}
