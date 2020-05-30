package View;

import Controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MainWindow {

    private Controller controller;
    private Table table;

    public MainWindow(Controller controller){
        this.controller=controller;
        VBox pane=new VBox();
        Menu addMenu=new Menu("Добавить");
        MenuItem addMenuItem=new MenuItem("Добавить");
        addMenu.getItems().add(addMenuItem);
        addMenuItem.setOnAction(e ->{
           AddWindow addWindow = new AddWindow(controller, this);
        });

        MenuItem openMenuItem=new MenuItem("Открыть");
        openMenuItem.setOnAction(e ->{
            Stage stage=new Stage();
            FileChooser fileChooser=new FileChooser();
            fileChooser.setTitle("Открыть файл");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML","*.xml"));
            File file=fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });
        Menu openMenu=new Menu("Открыть");
        openMenu.getItems().add(openMenuItem);

        MenuItem saveMenuItem=new MenuItem("Сохранить");
        saveMenuItem.setOnAction(e ->{
            Stage stage=new Stage();
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML","*.xml"));
            File file=fileChooser.showSaveDialog(stage);
            if(file == null){

            }
            controller.toFile(file);
        });
        Menu saveMenu=new Menu("Сохранить");
        saveMenu.getItems().add(saveMenuItem);

        Menu searchMenu=new Menu("Поиск");
        MenuItem searchNameAndGroupMenuItem=new MenuItem("Поиск по ФИО и номеру группы");
        searchNameAndGroupMenuItem.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,false,"group");
        });
        MenuItem searchNameAndWorkMenuItem=new MenuItem("Поиск по ФИО и виду общественной работы");
        searchNameAndWorkMenuItem.setOnAction(e -> {
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,false,"work");
        });
        MenuItem searchNameAndHoursMenuItem=new MenuItem("Поиск по ФИО и количеству часов общественной работы");
        searchNameAndHoursMenuItem.setOnAction(e-> {
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,false,"hours");
        });
        searchMenu.getItems().addAll(searchNameAndGroupMenuItem,searchNameAndWorkMenuItem,searchNameAndHoursMenuItem);

        Menu deleteMenu=new Menu("Удаление");
        MenuItem deleteNameAndGroupMenuItem=new MenuItem("Удаление по ФИО и номеру группы");
        deleteNameAndGroupMenuItem.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,true,"group");
        });
        MenuItem deleteNameAndWorkMenuItem=new MenuItem("Удаление по ФИО и виду общественной работы");
        deleteNameAndWorkMenuItem.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,true,"work");
        });
        MenuItem deleteNameAndHoursMenuItem=new MenuItem("Удаление по ФИО и количеству часов общественной работы");
        deleteNameAndHoursMenuItem.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,true,"hours");
        });
        deleteMenu.getItems().addAll(deleteNameAndGroupMenuItem,deleteNameAndWorkMenuItem,deleteNameAndHoursMenuItem);

        MenuBar menuBar=new MenuBar(addMenu,openMenu,saveMenu,searchMenu,deleteMenu);

        Button addToolButton=new Button("Добавить");
        addToolButton.setOnAction(e->{
            AddWindow addWindow=new AddWindow(this.controller,this);
        });

        Button searchNameAndGroupToolButton=new Button("Поиск по ФИО и группе");
        searchNameAndGroupToolButton.setOnAction(e -> {
            //SearchNameAndGroup searchNameAndGroup=new SearchNameAndGroup(this.controller);
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,false,"group");
        });

        Button searchNameAndWorkToolButton=new Button("Поиск по ФИО и общ.работе");
        searchNameAndWorkToolButton.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,false,"work");
        });

        Button searchNameAndHoursToolButton=new Button("Поиск по ФИО и часам");
        searchNameAndHoursToolButton.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,false,"hours");
        });

        Button deleteNameAndGroupToolButton=new Button("Удалить по ФИО и группе");
        deleteNameAndGroupToolButton.setOnAction(e -> {
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,true,"group");
        });

        Button deleteNameAndWorkToolButton=new Button("Удалить по ФИО и общ.работе");
        deleteNameAndWorkToolButton.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,true,"work");
        });

        Button deleteNameAndHoursToolButton=new Button("Удалить по ФИО и часам");
        deleteNameAndHoursToolButton.setOnAction(e->{
            SearchAndDeleteWindow searchAndDeleteWindow=new SearchAndDeleteWindow(this.controller,this,true,"hours");
        });

        ToolBar toolBar2=new ToolBar(
          addToolButton,
          searchNameAndGroupToolButton,
          searchNameAndWorkToolButton,
          searchNameAndHoursToolButton,
          deleteNameAndGroupToolButton,
          deleteNameAndWorkToolButton,
          deleteNameAndHoursToolButton
        );

        Button openButton=new Button("Открыть");
        openButton.setOnAction(e->{
            Stage stage=new Stage();
            FileChooser fileChooser=new FileChooser();
            fileChooser.setTitle("Открыть файл");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML","*.xml"));
            File file=fileChooser.showOpenDialog(stage);
            if(file == null){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ОШИБКА");
                alert.setContentText("Выберите файл");
                alert.showAndWait();
                return;
            }
            controller.setFile(file);
            controller.fromFile();
            update();
        });

        Button saveButton=new Button("Сохранить");
        saveButton.setOnAction(e ->{
            Stage stage=new Stage();
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML","*.xml"));
            File file=fileChooser.showSaveDialog(stage);
            if(file == null){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ОШИБКА");
                alert.setContentText("Выберите файл");
                alert.showAndWait();
                return;
            }
            controller.toFile(file);
        });

        ToolBar toolBar1=new ToolBar(
                openButton,
                saveButton
        );

        table=new Table();
        table.setList(controller.getStudents());
        table.setPage(table.getPageNum());

        pane.getChildren().add(menuBar);
        pane.getChildren().add(toolBar1);
        pane.getChildren().add(toolBar2);
        pane.getChildren().add(table.getPane());
        Scene scene=new Scene(pane);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void update(){
        table.clear();
        table.setList(controller.getStudents());
        table.setPage(table.getPageNum());
    }

    public void alertMessage(String text){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.showAndWait();
    }
}