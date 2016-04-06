package additional;

public class SAClizator {

    public static String toSAC(String src) {
        String[] ss = src.split(" ");
        String s = "";
        for (int i = 0; i < ss.length; i++) {
            s += "{1:SAC:=" + ss[i] + "}";
        }
        return s;
    }

}
