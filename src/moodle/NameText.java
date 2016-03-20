package moodle;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "text" } )
public class NameText {

    private String text;

    public NameText() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
