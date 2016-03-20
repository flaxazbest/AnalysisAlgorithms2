package moodle;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@XmlRootElement(name = "quiz")
public class Question {

    public List<Seed> question;

    public Question() {
        question = new LinkedList<>();
    }
/*
    public List<Seed> getQuestions() {
        return question;
    }
*/
    public void setQuestions(List<Seed> seeds) {
        this.question = seeds;
    }

    public void write() {
        try {
            JAXBContext context = JAXBContext.newInstance(Question.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File( "dictionary.xml" );
            marshaller.marshal(this, file);
            //marshaller.marshal(createCategory(), System.out);
        } catch (JAXBException exception) {
            Logger.getLogger(Question.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    public static void main(String[] args) {
        Question q = new Question();
        q.question.add(new Seed());
        q.question.add(new Seed());
        q.question.add(new Seed());
        q.write();
    }

}
