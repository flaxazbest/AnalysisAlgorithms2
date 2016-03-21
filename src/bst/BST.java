package bst;

import java.util.LinkedList;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x.right, key);
        return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val ,1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if  (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void clear() {
        root = null;
    }

    public String getPreorder() {
        return getPreorder(root);
    }

    private String getPreorder(Node x) {
        if (x == null) return "";
        String s = x.val + " ";
        s += getPreorder(x.left);
        s += getPreorder(x.right);
        return s;
    }

    public String getlevelOrder() {
        String s = "";
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node x = queue.pop();
            s += x.val + " ";
            if (x.left != null) queue.add(x.left);
            if (x.right != null) queue.add(x.right);
        }
        return s;
    }

    public static void main(String[] args) {

        /*
        Integer[] arr = {47, 48, 54, 30, 32, 94, 20, 17, 59, 76};

        BST<Integer, Integer> bst = new BST<>();
        for (int i = 0; i < 10; i++) {
            bst.put(arr[i], arr[i]);
            System.out.println(bst.getlevelOrder());
        }
        //*/

        Integer[] arr = {22, 20, 77, 35, 83, 33, 45, 89, 71, 96, 49, 69};

        BST<Integer, Integer> bst = new BST<>();
        for (int i = 0; i < 12; i++) {
            bst.put(arr[i], arr[i]);
        }
        System.out.println(bst.getlevelOrder());
            bst.delete(69); System.out.print("69: ");
            System.out.println(bst.getlevelOrder());
            bst.delete(71); System.out.print("71: ");
            System.out.println(bst.getlevelOrder());
            bst.delete(77); System.out.print("77: ");
            System.out.println(bst.getlevelOrder());
    }
}
