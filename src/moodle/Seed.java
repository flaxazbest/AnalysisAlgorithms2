package moodle;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Random;

@XmlType(propOrder = { "name", "questiontext", "generalfeedback", "penalty", "hidden" })
public class Seed {

    @XmlAttribute(name = "type")
    private QuestionType type;
    @XmlElement
    public NameText name;
    @XmlElement
    public QuestionText questiontext;
    @XmlElement
    public QuestionText generalfeedback;
    @XmlElement
    private double penalty;
    @XmlElement
    private int hidden;

    public Seed() {
        name = new NameText();
//           name.setText("New name");
        type = QuestionType.cloze;
        questiontext = new QuestionText();
//           questiontext.setText("Text");
        generalfeedback = new QuestionText();
//            generalfeedback.setText("Feedback");
        penalty = 1.0/3;
        hidden = 0;
    }

    public String getName() {
        return name.getText();
    }

    //@XmlJavaTypeAdapter(value = AdapterCDATA.class)
    public String getQuestiontext() {
        return questiontext.getText();
    }

    //@XmlJavaTypeAdapter(value = AdapterCDATA.class)
    public String getGeneralfeedback() {
        return generalfeedback.getText();
    }

    public double getPenalty() {
        return penalty;
    }

    public int getHidden() {
        return hidden;
    }
/*
    public void setName(String name) {
        this.name.setText(name);
    }
*/
    /*

    public void setQuestiontext(String questiontext) {
        this.questiontext.setText(questiontext);
    }
    /*
    public void setGeneralfeedback(String generalfeedback) {
        this.generalfeedback.setText(generalfeedback);
    }
    //*/
}