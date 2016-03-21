package additional;

public class Numeric {

    public static String toNumeric(String src) {
        String[] ss = src.split(" ");
        String s = "";
        for (int i = 0; i < ss.length; i++) {
            s += "{1:NUMERICAL:=" + ss[i] + "}";
        }
        return s;
    }

}
