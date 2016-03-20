package moodle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Random;

@XmlType(propOrder = { "name", "questiontext", "generalfeedback", "penalty", "hidden" })
public class Seed {

    @XmlAttribute(name = "type")
    private QuestionType type;
    private TextFormat textFormat;
    @XmlElement
    private NameText name;
    @XmlElement
    private QuestionText questiontext;
    @XmlElement
    private QuestionText generalfeedback;
    @XmlElement
    private double penalty;
    @XmlElement
    private int hidden;
    private static Random rnd = new Random();

    public Seed() {
        String s = "Seed " + rnd.nextInt(10000);
        name = new NameText();
            name.setText(s);
        type = QuestionType.cloze;
        textFormat = TextFormat.html;
        questiontext = new QuestionText();
            questiontext.setText("Name {1:NUMERICAL:=77}{1:NUMERICAL:=52}");
        generalfeedback = new QuestionText();
            generalfeedback.setText("General feedback");
        penalty = 1.0/3;
        hidden = 0;
    }

    public String getName() {
        return name.getText();
    }

    public String getQuestiontext() {
        return questiontext.getText();
    }

    public String getGeneralfeedback() {
        return generalfeedback.getText();
    }

    public double getPenalty() {
        return penalty;
    }

    public int getHidden() {
        return hidden;
    }
}