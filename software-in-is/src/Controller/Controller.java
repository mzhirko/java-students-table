package Controller;

import Model.Student;
import Model.StudentDatabase;
import View.MainWindow;

import java.io.File;
import java.util.List;

public class Controller {
    private Student student;
    private MainWindow mainWindow;
    private StudentDatabase studentDatabase;

    public Controller(){
        studentDatabase=new StudentDatabase(this);
        mainWindow=new MainWindow(this);
    }

    public void addStudent(Student student) {
        studentDatabase.add(student);
    }

    public List<Student> getStudents(){
        return studentDatabase.getStudents();
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setFile(File file){
        studentDatabase.setFile(file);
    }

    public File getFile(){
        return studentDatabase.getFile();
    }

    public void toFile(File file){
        studentDatabase.toFile(file);
    }

    public void fromFile(){
        studentDatabase.fromFile();
        mainWindow.update();
    }

    public void alertMessage(String text){
        mainWindow.alertMessage(text);
    }
}

