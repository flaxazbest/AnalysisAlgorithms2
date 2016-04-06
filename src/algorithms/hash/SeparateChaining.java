package algorithms.hash;

import additional.Hash;

public class SeparateChaining {

    private int M, N;
    private Node[] st;
    public Hash hash;
    //



    //

    public SeparateChaining(int m, int n) {
        M = m;
        N = n;
        st = new Node[M];
        hash = new Hash(M);
        for (int i = 0; i < n; i++) {
            put(hash.getValue(i), i);
            //System.out.println(hash.getValue(i) + " " + hash.getKey(i));
        }
    }

    private class Node {
        private int key;
        private char val;
        private Node next;

        public Node(int key, char val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public char getVal() {
            return val;
        }
    }

    public void put(char val, int key) {
        int i = hash.getKey(key);
        st[i] = new Node(key, hash.getValue(key), st[i]);
    }

    public String toString(int n, boolean withArrow) {
        String s = "";
        Node x = st[n];
        while (x != null) {
            s += x.getVal();
            x = x.next;
            if (x != null ) {
                if (withArrow) s += " <- ";
                else s += " ";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        SeparateChaining sc = new SeparateChaining(3, 12);
        //sc.put();
        System.out.println("0: " + sc.toString(0, true));
        System.out.println("1: " + sc.toString(1, true));
        System.out.println("2: " + sc.toString(2, true));
    }

}
