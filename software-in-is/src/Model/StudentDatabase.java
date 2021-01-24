package Model;

import Controller.Controller;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;


public class StudentDatabase {
    private Controller controller;
    private List<Student> students=new ArrayList<>();
    private File file;

    public StudentDatabase(Controller controller){
        this.controller=controller;
    }

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students){
        this.students=students;
    }

    public void setFile(File file){
        this.file=file;
    }

    public File getFile(){
        return file;
    }

    public void toFile(File file){
        Writer writer=new Writer();
        writer.write(file,this);
    }

    public void fromFile(){
        SAXParserFactory factory=SAXParserFactory.newInstance();
        factory.setValidating(true);
        Handler handler=new Handler();
        handler.setBase(this);
        try{
            SAXParser parser=factory.newSAXParser();
            parser.parse(file,handler);
            controller.getMainWindow().update();
        }catch (SAXException | ParserConfigurationException  | IOException ex){
            String exText=ex.getMessage();
            controller.alertMessage(exText);
        }
    }


    public Controller getController() {
        return controller;
    }
}