package quizgenerator.dsd.ariphmeticfunctions;

import java.util.LinkedList;
import java.util.List;

public class ANumber {

    private int n;
    private List<Canonic> decomosition;

    public ANumber(int n) {
        this.n = n;
        decomosition = new LinkedList<>();
        int p = 2;
        int t = n;
        while (t > 1) {
            int k = 0;
            while ( t % p == 0 ) {
                t /= p;
                k++;
            }
            if (k != 0) {
                decomosition.add(new Canonic(p, k));
            }
            p++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(n).append(" = ");
        for(int i=0; i<decomosition.size()-1; i++) {
            builder.append(decomosition.get(i).getP()).append("^").append(decomosition.get(i).getP()).append("*");
            builder.append(decomosition.get(decomosition.size() - 1).getP()).append("^")
                    .append(decomosition.get(decomosition.size() - 1).getP()).append("*");
        }
        return builder.toString();
    }

    public int tau() {
        int t = 1;
        for (Canonic c: decomosition)
            t *=  (c.getK()+1);
        return t;
    }

    int sigma() {
        int s = 1;
        for (Canonic c: decomosition)
            s *= ( (Math.pow(c.getP(), c.getK()+1)-1) / (c.getP()-1) );
        return s;
    }

    int phi() {
        int f = n;
        for (Canonic c: decomosition)
            f = f * (c.getP()-1) / c.getP() ;
        return f;
    }

    public int getN() {
        return n;
    }
}
