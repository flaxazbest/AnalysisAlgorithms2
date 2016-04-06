package moodle.seed;

import moodle.NameText;
import moodle.QuestionText;
import moodle.QuestionType;
import moodle.TextAnswer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SeedShort {

    @XmlAttribute(name = "type")
    private QuestionType type;
    @XmlElement
    public NameText name;
    @XmlElement
    public QuestionText questiontext;
    @XmlElement
    public QuestionText generalfeedback;
    @XmlElement
    public double defaultgrade;
    @XmlElement
    private double penalty;
    @XmlElement
    private int hidden;
    @XmlElement
    private int usecase;
    @XmlElement
    public TextAnswer answer;

    public SeedShort() {
        name = new NameText();
        type = QuestionType.shortanswer;
        questiontext = new QuestionText();
        generalfeedback = new QuestionText();
        defaultgrade = 1.0;
        penalty = 1.0/3;
        hidden = 0;
        usecase = 1;
        answer = new TextAnswer();

            name.setText("New name");
            questiontext.setText("Text");
            generalfeedback.setText("Feedback");
    }

    public QuestionType getType() {
        return type;
    }

    public NameText getName() {
        return name;
    }

    public QuestionText getQuestiontext() {
        return questiontext;
    }

    public QuestionText getGeneralfeedback() {
        return generalfeedback;
    }

    public double getDefaultgrade() {
        return defaultgrade;
    }

    public double getPenalty() {
        return penalty;
    }

    public int getHidden() {
        return hidden;
    }

    public int getUsecase() {
        return usecase;
    }

    public TextAnswer getAnswer() {
        return answer;
    }
}
