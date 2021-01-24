package View;

import Controller.Controller;
import Model.Name;
import Model.Student;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SearchAndDeleteWindow {
    private Controller controller;
    private MainWindow mainWindow;
    private boolean deleteFlag;
    String paramName;

    public SearchAndDeleteWindow(Controller controller, MainWindow mainWindow, boolean deleteFlag,String paramName) {
        this.controller=controller;
        this.mainWindow=mainWindow;
        this.deleteFlag=deleteFlag;
        this.paramName=paramName;

        VBox pane = new VBox(10);
        pane.setPadding(new Insets(10));

        Label lastNameLabel = new Label("Фамилия");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Фамилия");

        Label firstNameLabel = new Label("Имя");
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Имя");

        Label fatherNameLabel = new Label("Отчество");
        TextField fatherNameField = new TextField();
        fatherNameField.setPromptText("Отчество");

        Label varParamLabel = new Label();
        TextField varParamField = new TextField();

        if (paramName.equals("group")) {
            varParamLabel.setText("Номер группы");
            varParamField.setPromptText("Номер группы");
        }
        else if(paramName.equals("work")){
            varParamLabel.setText("Вид работы");
            varParamField.setPromptText("Вид работы");
        }
        else if(paramName.equals("hours")){
            varParamLabel.setText("Кол-во часов");
            varParamField.setPromptText("Кол-во часов");
        }
        else{
            return;
        }
        Button button=new Button("Удалить");
        Table table=new Table();
        pane.getChildren().addAll(
                lastNameLabel,
                lastNameField,
                firstNameLabel,
                firstNameField,
                fatherNameLabel,
                fatherNameField,
                varParamLabel,
                varParamField,
                button
        );
        if(deleteFlag==false){
            button.setText("Искать");
            pane.getChildren().add(table.getPane());
        }
        button.setOnAction(e->{
                List<Student> list=search(lastNameField.getText()+" "+firstNameField.getText()+" "+fatherNameField.getText(),varParamField.getText());
                if(list==null){
                   return;
                }
                Alert alert;
                if(list.size()==0){
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Таких студентов нет");
                    alert.showAndWait();
                    return;
                }

            if(deleteFlag==false){
                table.setList(list);
                table.setPage(table.getPageNum());
            }
            else{
                controller.getStudents().removeAll(list);
                mainWindow.update();
            }
            alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Таких студентов "+list.size());
            alert.showAndWait();
        });
        Scene scene=new Scene(pane);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    public List<Student> search(String name, String varParam){
        List<Student> result=new ArrayList<>();
        List<Student> students=controller.getStudents();
        int min=0;
        int max=0;
        String hours[];
        if(paramName.equals("hours")){
            hours=varParam.split("-");
            try {

                if (hours.length > 2 || Integer.parseInt(hours[0]) < 0 || Integer.parseInt(hours[1]) < Integer.parseInt(hours[0])) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Некорректный ввод");
                    alert.showAndWait();
                    return null;
                }
                min = Integer.parseInt(hours[0]);
                max = Integer.parseInt(hours[1]);
            }catch(NumberFormatException ex){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Некорректный ввод");
                alert.showAndWait();
                return null;
            }
        }
        for (int numOfStudent=0;numOfStudent<students.size();numOfStudent++){
            if(paramName.equals("group")){
                if(name.equals(students.get(numOfStudent).getName()) && varParam.equals(students.get(numOfStudent).getGroup())){
                    result.add(students.get(numOfStudent));
                }
            }
            else if(paramName.equals("work")){
                if(name.equals(students.get(numOfStudent).getName()) && students.get(numOfStudent).isInWork(varParam)){
                    result.add(students.get(numOfStudent));
                }
            }
            else if(paramName.equals("hours")){
                if(name.equals(students.get(numOfStudent).getName())&& students.get(numOfStudent).getTotalHours()>=min && students.get(numOfStudent).getTotalHours()<=max){
                    result.add(students.get(numOfStudent));
                }
            }
        }
        return result;
    }

    public void delete(List<Student> list){
        controller.getStudents().removeAll(list);
    }
}