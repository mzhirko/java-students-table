package View;

import Model.Name;
import Model.PublicWork;
import Model.Semestr;
import Model.Student;
import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddWindow {
    private Controller controller;
    private MainWindow mainWindow;

    public AddWindow(Controller controller, MainWindow mainWindow){
        this.controller=controller;
        this.mainWindow=mainWindow;
        List<Semestr> works=new ArrayList<>();
        int numOfSem=10;
        for (int i=0;i<numOfSem;i++){
            works.add(new Semestr());
        }

        GridPane pane=new GridPane();
        pane.setPadding(new Insets(15));
        pane.setVgap(15);
        pane.setHgap(15);

        pane.add(new Label("Фамилия"),0,0);
        pane.add(new Label("Имя"),0,1);
        pane.add(new Label("Отчество"),0,2);
        pane.add(new Label("Номер группы"),0,3);
        pane.add(new Label("Семестр 1"),0,5);
        pane.add(new Label("Семестр 2"),0,6);
        pane.add(new Label("Семестр 3"),0,7);
        pane.add(new Label("Семестр 4"),0,8);
        pane.add(new Label("Семестр 5"),0,9);
        pane.add(new Label("Семестр 6"),0,10);
        pane.add(new Label("Семестр 7"),0,11);
        pane.add(new Label("Семестр 8"),0,12);
        pane.add(new Label("Семестр 9"),0,13);
        pane.add(new Label("Семестр 10"),0,14);

        TextField lastNameField=new TextField();
        lastNameField.setPromptText("Фамилия");
        pane.add(lastNameField,1,0);

        TextField firstNameField=new TextField();
        firstNameField.setPromptText("Имя");
        pane.add(firstNameField,1,1);

        TextField fatherNameField=new TextField();
        fatherNameField.setPromptText("Отчество");
        pane.add(fatherNameField,1,2);

        TextField groupField=new TextField();
        groupField.setPromptText("Номер группы");
        pane.add(groupField,1,3);

        TextField firstSemWorkField=new TextField();
        firstSemWorkField.setPromptText("Работа");
        pane.add(firstSemWorkField,1,5);

        TextField secondSemWorkField=new TextField();
        secondSemWorkField.setPromptText("Работа");
        pane.add(secondSemWorkField,1,6);

        TextField thirdSemWorkField=new TextField();
        thirdSemWorkField.setPromptText("Работа");
        pane.add(thirdSemWorkField,1,7);

        TextField fourthSemWorkField=new TextField();
        fourthSemWorkField.setPromptText("Работа");
        pane.add(fourthSemWorkField,1,8);

        TextField fifthSemWorkField=new TextField();
        fifthSemWorkField.setPromptText("Работа");
        pane.add(fifthSemWorkField,1,9);

        TextField sixthSemWorkField=new TextField();
        sixthSemWorkField.setPromptText("Работа");
        pane.add(sixthSemWorkField,1,10);

        TextField seventhSemWorkField=new TextField();
        seventhSemWorkField.setPromptText("Работа");
        pane.add(seventhSemWorkField,1,11);

        TextField eighthSemWorkField=new TextField();
        eighthSemWorkField.setPromptText("Работа");
        pane.add(eighthSemWorkField,1,12);

        TextField ninthSemWorkField=new TextField();
        ninthSemWorkField.setPromptText("Работа");
        pane.add(ninthSemWorkField,1,13);

        TextField tenthSemWorkField=new TextField();
        tenthSemWorkField.setPromptText("Работа");
        pane.add(tenthSemWorkField,1,14);

        TextField firstSemHoursField=new TextField();
        firstSemHoursField.setPromptText("Кол-во часов");
        pane.add(firstSemHoursField,2,5);

        TextField secondSemHoursField=new TextField();
        secondSemHoursField.setPromptText("Кол-во часов");
        pane.add(secondSemHoursField,2,6);

        TextField thirdSemHoursField=new TextField();
        thirdSemHoursField.setPromptText("Кол-во часов");
        pane.add(thirdSemHoursField,2,7);

        TextField fourthSemHoursField=new TextField();
        fourthSemHoursField.setPromptText("Кол-во часов");
        pane.add(fourthSemHoursField,2,8);

        TextField fifthSemHoursField=new TextField();
        fifthSemHoursField.setPromptText("Кол-во часов");
        pane.add(fifthSemHoursField,2,9);

        TextField sixthSemHoursField=new TextField();
        sixthSemHoursField.setPromptText("Кол-во часов");
        pane.add(sixthSemHoursField,2,10);

        TextField seventhSemHoursField=new TextField();
        seventhSemHoursField.setPromptText("Кол-во часов");
        pane.add(seventhSemHoursField,2,11);

        TextField eighthSemHoursField=new TextField();
        eighthSemHoursField.setPromptText("Кол-во часов");
        pane.add(eighthSemHoursField,2,12);

        TextField ninthSemHoursField=new TextField();
        ninthSemHoursField.setPromptText("Кол-во часов");
        pane.add(ninthSemHoursField,2,13);

        TextField tenthSemHoursField=new TextField();
        tenthSemHoursField.setPromptText("Кол-во часов");
        pane.add(tenthSemHoursField,2,14);

        Button addFirstSemButton=new Button(" Добавить в 1 семестр");
        addFirstSemButton.setOnAction(e -> {
            works.get(0).addToList(new PublicWork(firstSemWorkField.getText(),Integer.parseInt(firstSemHoursField.getText())));
            firstSemWorkField.clear();
            firstSemHoursField.clear();
        });
        pane.add(addFirstSemButton,3,5);

        Button addSecondSemButton=new Button(" Добавить в 2 семестр ");
        addSecondSemButton.setOnAction(e ->{
            works.get(1).addToList(new PublicWork(secondSemWorkField.getText(),Integer.parseInt(secondSemHoursField.getText())));
            secondSemWorkField.clear();
            secondSemHoursField.clear();
        });
        pane.add(addSecondSemButton,3,6);

        Button addThirdSemButton=new Button(" Добавить в 3 семестр ");
        addThirdSemButton.setOnAction(e -> {
            if(thirdSemWorkField.getText()!=""||thirdSemHoursField.getText()!=""){
                works.get(2).addToList(new PublicWork(thirdSemWorkField.getText(),Integer.parseInt(thirdSemHoursField.getText())));
                thirdSemWorkField.clear();
                thirdSemHoursField.clear();
            }
        });
        pane.add(addThirdSemButton,3,7);

        Button addFourthSemButton=new Button(" Добавить в 4 семестр ");
        addFourthSemButton.setOnAction(e ->{
            if(fourthSemWorkField.getText()!=""||fourthSemHoursField.getText()!="") {
                works.get(3).addToList(new PublicWork(fourthSemWorkField.getText(), Integer.parseInt(fourthSemHoursField.getText())));
                fourthSemWorkField.clear();
                fourthSemHoursField.clear();
            }
        });
        pane.add(addFourthSemButton,3,8);

        Button addFifthSemButton=new Button(" Добавить в 5 семестр ");
        addFifthSemButton.setOnAction(e -> {
            if(fifthSemWorkField.getText()!=""||fifthSemHoursField.getText()!="") {
                works.get(4).addToList(new PublicWork(fifthSemWorkField.getText(), Integer.parseInt(fifthSemHoursField.getText())));
                fifthSemWorkField.clear();
                fifthSemHoursField.clear();
            }
        });
        pane.add(addFifthSemButton,3,9);

        Button addSixthSemButton=new Button(" Добавить в 6 семестр ");
        addSixthSemButton.setOnAction(e -> {
            if(sixthSemWorkField.getText()!=""||sixthSemHoursField.getText()!="") {
                works.get(5).addToList(new PublicWork(sixthSemWorkField.getText(), Integer.parseInt(sixthSemHoursField.getText())));
                sixthSemWorkField.clear();
                sixthSemHoursField.clear();
            }
        });
        pane.add(addSixthSemButton,3,10);

        Button addSeventhSemButton=new Button(" Добавить в 7 семестр ");
        addSeventhSemButton.setOnAction(e -> {
            if(seventhSemWorkField.getText()!=""||seventhSemHoursField.getText()!="") {
                works.get(6).addToList(new PublicWork(seventhSemWorkField.getText(), Integer.parseInt(seventhSemHoursField.getText())));
                seventhSemWorkField.clear();
                seventhSemHoursField.clear();
            }
        });
        pane.add(addSeventhSemButton,3,11);

        Button addEighthSemButton=new Button(" Добавить в 8 семестр ");
        addEighthSemButton.setOnAction(e -> {
            if(eighthSemWorkField.getText()!=""||eighthSemHoursField.getText()!="") {
                works.get(7).addToList(new PublicWork(eighthSemWorkField.getText(), Integer.parseInt(eighthSemHoursField.getText())));
                eighthSemWorkField.clear();
                eighthSemHoursField.clear();
            }
        });
        pane.add(addEighthSemButton,3,12);

        Button addNinthSemButton=new Button(" Добавить в 9 семестр ");
        addNinthSemButton.setOnAction(e -> {
            if(ninthSemWorkField.getText()!=""||ninthSemHoursField.getText()!="") {
                works.get(8).addToList(new PublicWork(ninthSemWorkField.getText(), Integer.parseInt(ninthSemHoursField.getText())));
                ninthSemWorkField.clear();
                ninthSemHoursField.clear();
            }
        });
        pane.add(addNinthSemButton,3,13);

        Button addTenthSemButton=new Button("Добавить в 10 семестр");
        addTenthSemButton.setOnAction(e -> {
            if(tenthSemWorkField.getText()!=""||tenthSemHoursField.getText()!="") {
                works.get(9).addToList(new PublicWork(tenthSemWorkField.getText(), Integer.parseInt(tenthSemHoursField.getText())));
                tenthSemWorkField.clear();
                tenthSemHoursField.clear();
            }
        });
        pane.add(addTenthSemButton,3,14);

        Button addButton=new Button("Добавить студента");
        addButton.setOnAction(e ->{
            Student student=new Student();
            student.setName(new Name(lastNameField.getText(),firstNameField.getText(),fatherNameField.getText()));
            student.setGroup(groupField.getText());
            student.setFirstSem(works.get(0));
            student.setSecondSem(works.get(1));
            student.setThirdSem(works.get(2));
            student.setFourthSem(works.get(3));
            student.setFifthSem(works.get(4));
            student.setSixthSem(works.get(5));
            student.setSeventhSem(works.get(6));
            student.setEighthSem(works.get(7));
            student.setNinthSem(works.get(8));
            student.setTenthSem(works.get(9));

            controller.addStudent(student);

            lastNameField.clear();
            firstNameField.clear();
            fatherNameField.clear();
            groupField.clear();

            mainWindow.update();
        });
        pane.add(addButton,3,15);

        Scene scene=new Scene(pane);

        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Добавить нового студента");

        stage.show();
    }
}