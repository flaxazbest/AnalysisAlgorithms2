package moodle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "text"})
public class TextAnswer {

    @XmlAttribute(name = "fraction")
    private int fraction;
    @XmlAttribute(name = "format")
    private TextFormat textFormat;

    private String text;

    public TextAnswer() {
        this.fraction = 100;
        this.textFormat = TextFormat.moodle_auto_format;
        text = "text from constructor";
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement
    public String getText() {
        return text;
    }
}
