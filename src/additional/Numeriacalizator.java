package additional;

public class Numeriacalizator<Key extends Comparable<Key>> {

    public String toNumeric(Key[] arr) {
        String s = "";
        for (int i = 1 ;i < arr.length; i++) {
            s += "{1:NUMERICAL:=" + arr[i].toString() + "}";
        }
        return s;
    }

}
