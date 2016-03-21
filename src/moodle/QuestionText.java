package moodle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = { "text"})
public class QuestionText {

    @XmlAttribute(name = "format")
    private TextFormat textFormat;

    private String text;

    public QuestionText() {
        textFormat = TextFormat.html;
    }

    @XmlJavaTypeAdapter(value = AdapterCDATA.class)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
