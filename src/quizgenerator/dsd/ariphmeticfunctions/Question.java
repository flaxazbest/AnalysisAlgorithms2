package quizgenerator.dsd.ariphmeticfunctions;

public class Question {

    private ANumber n;

    public Question(ANumber n) {
        this.n = n;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("<question type=\"cloze\">\n");
        builder.append("<name>\n");
        builder.append("\t<text>число ").append(n.getN()).append("</text>\n");
        builder.append("</name>\n");
        builder.append("<questiontext format=\"html\">\n");
        builder.append("\t<text><![CDATA[<p>Обчислити для заданого числа ").append(n.getN()).append(" значення функцій</p>\n");
        builder.append("\t<p>τ(").append(n.getN()).append(") {1:NUMERICAL:=").append(n.tau()).append("}</p>\n");
        builder.append("\t<p>σ(").append(n.getN()).append(") {1:NUMERICAL:=").append(n.sigma()).append("}</p>\n");
        builder.append("\t<p>φ(").append(n.getN()).append(") {1:NUMERICAL:=").append(n.phi()).append("}</p>]]></text>\n");
        builder.append("</questiontext>\n");
        builder.append("<generalfeedback format=\"html\">\n");
        builder.append("<text></text>\n");
        builder.append("</generalfeedback>\n");
        builder.append("<penalty>0.3333333</penalty>\n");
        builder.append("<hidden>0</hidden>\n");
        builder.append("</question>\n");

        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Question(new ANumber(110)));

    }

}
