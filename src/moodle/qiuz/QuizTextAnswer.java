package moodle.qiuz;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import moodle.seed.SeedShort;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@XmlRootElement(name = "quiz")
public class QuizTextAnswer {

    public List<SeedShort> question;

    public QuizTextAnswer() {
        question = new LinkedList<>();
    }

    public void setQuestion(List<SeedShort> question) {
        this.question = question;
    }

    public void write(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(QuizTextAnswer.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
                public void escape(char[] ac, int i, int j, boolean flag,
                                   Writer writer) throws IOException {
                    writer.write( ac, i, j ); }
            });

            File file = new File( fileName + ".xml" );
            marshaller.marshal(this, file);
            //marshaller.marshal(createCategory(), System.out);
        } catch (JAXBException exception) {
            Logger.getLogger(Question.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    public static void main(String[] args) {
        QuizTextAnswer qz = new QuizTextAnswer();
        qz.question.add(new SeedShort());
        qz.question.add(new SeedShort());
        qz.write("test_short");
    }

}
