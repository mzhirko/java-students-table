package View;

import Controller.Controller;
import Model.Name;
import Model.Semestr;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class Table{

    private VBox pane;
    private TableView<Student> table;
    private int recordsOnPage=10;
    private int pageNum=0;
    private Label pageNumLabel;
    private Label totalRecords;
    List<Student> list;

    public Table(){
        TableColumn<Student,String> nameColumn=new TableColumn<>("ФИО");
        nameColumn.setMinWidth(300);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student,String> groupColumn=new TableColumn<>("Группа");
        groupColumn.setMinWidth(100);
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("group"));

        TableColumn<Semestr,String> firstSemColumn=new TableColumn<>("Семестр 1");
        firstSemColumn.setMinWidth(100);
        firstSemColumn.setCellValueFactory(new PropertyValueFactory<>("firstSem"));

        TableColumn<Semestr,String> secondSemColumn=new TableColumn<>("Семестр 2");
        secondSemColumn.setMinWidth(100);
        secondSemColumn.setCellValueFactory(new PropertyValueFactory<>("secondSem"));

        TableColumn<Semestr,String> thirdSemColumn=new TableColumn<>("Семестр 3");
        thirdSemColumn.setMinWidth(100);
        thirdSemColumn.setCellValueFactory(new PropertyValueFactory<>("thirdSem"));

        TableColumn<Semestr,String> fourthSemColumn=new TableColumn<>("Семестр 4");
        fourthSemColumn.setMinWidth(100);
        fourthSemColumn.setCellValueFactory(new PropertyValueFactory<>("fourthSem"));

        TableColumn<Semestr,String> fifthSemColumn=new TableColumn<>("Семестр 5");
        fifthSemColumn.setMinWidth(100);
        fifthSemColumn.setCellValueFactory(new PropertyValueFactory<>("fifthSem"));

        TableColumn<Semestr,String> sixthSemColumn=new TableColumn<>("Семестр 6");
        sixthSemColumn.setMinWidth(100);
        sixthSemColumn.setCellValueFactory(new PropertyValueFactory<>("sixthSem"));

        TableColumn<Semestr,String> seventhSemColumn=new TableColumn<>("Семестр 7");
        seventhSemColumn.setMinWidth(100);
        seventhSemColumn.setCellValueFactory(new PropertyValueFactory<>("seventhSem"));

        TableColumn<Semestr,String> eighthSemColumn=new TableColumn<>("Семестр 8");
        eighthSemColumn.setMinWidth(100);
        eighthSemColumn.setCellValueFactory(new PropertyValueFactory<>("eighthSem"));

        TableColumn<Semestr,String> ninthSemColumn=new TableColumn<>("Семестр 9");
        ninthSemColumn.setMinWidth(100);
        ninthSemColumn.setCellValueFactory(new PropertyValueFactory<>("ninthSem"));

        TableColumn<Semestr,String> tenthSemColumn=new TableColumn<>("Семестр 10");
        tenthSemColumn.setMinWidth(100);
        tenthSemColumn.setCellValueFactory(new PropertyValueFactory<>("tenthSem"));

        table=new TableView<>();

        TableColumn semColumn=new TableColumn("Общественная работа");

        semColumn.getColumns().add(firstSemColumn);
        semColumn.getColumns().add(secondSemColumn);
        semColumn.getColumns().add(thirdSemColumn);
        semColumn.getColumns().add(fourthSemColumn);
        semColumn.getColumns().add(fifthSemColumn);
        semColumn.getColumns().add(sixthSemColumn);
        semColumn.getColumns().add(seventhSemColumn);
        semColumn.getColumns().add(eighthSemColumn);
        semColumn.getColumns().add(ninthSemColumn);
        semColumn.getColumns().add(tenthSemColumn);

        table.getColumns().addAll(nameColumn,groupColumn,semColumn);

        pane=new VBox(10);
        pane.getChildren().add(table);

        HBox hBox=new HBox(20);

        pageNumLabel=new Label();
        totalRecords=new Label();

        Button firstPageButton=new Button("FIRST PAGE");
        firstPageButton.setOnAction(e -> {
            pageNum=0;
            setPage(pageNum);
            pageNumLabel.setText("Текущая страница: "+(pageNum+1)+"/"+(((list.size()-1)/recordsOnPage)+1));
        });

        Button prevPageButton=new Button("PREV PAGE");
        prevPageButton.setOnAction(e ->{
            if(pageNum>0){
                pageNum--;
                setPage(pageNum);
                pageNumLabel.setText("Текущая страница: "+(pageNum+1)+"/"+(((list.size()-1)/recordsOnPage)+1));
            }
        });

        Button nextPageButton=new Button("NEXT PAGE");
        nextPageButton.setOnAction(e -> {
            if(pageNum<(list.size()-1)/recordsOnPage){
                pageNum++;
                setPage(pageNum);
                pageNumLabel.setText("Текущая страница: "+(pageNum+1)+"/"+(((list.size()-1)/recordsOnPage)+1));
            }
        });

        Button lastPageButton=new Button("LAST PAGE");
        lastPageButton.setOnAction(e->{
            pageNum=(list.size()-1)/recordsOnPage;
            setPage(pageNum);
            pageNumLabel.setText("Текущая страница: "+(pageNum+1)+"/"+(((list.size()-1)/recordsOnPage)+1));
        });

        Label recordsOnPageLabel=new Label("Записей на странице:"+recordsOnPage);

        TextField recordsOnPageField=new TextField();
        recordsOnPageField.setPromptText("Кол-во записей на странице");
        Button setRecordsOnPage=new Button("Применить");
        setRecordsOnPage.setOnAction(e->{
            int records=pageNum;
            try {
                records = Integer.parseInt(recordsOnPageField.getText());
            }catch(NumberFormatException ex){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка!");
                alert.setContentText("Введены некооректные данные");
                alert.showAndWait();
                recordsOnPageField.clear();
                return;
            }
            if(records<1){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка!");
                alert.setContentText("Введены некооректные данные");
                alert.showAndWait();
                recordsOnPageField.clear();
                return;
            }
            recordsOnPage=records;
            recordsOnPageLabel.setText("Записей на странице: "+recordsOnPage);
            pageNum=0;
            setPage(pageNum);
            pageNumLabel.setText("Текущая страница: "+(pageNum+1)+"/"+(((list.size()-1)/recordsOnPage)+1));
            recordsOnPageField.clear();
        });



        hBox.getChildren().addAll(
                firstPageButton,
                prevPageButton,
                nextPageButton,
                lastPageButton,
                pageNumLabel,
                totalRecords,
                recordsOnPageLabel,
                recordsOnPageField,
                setRecordsOnPage);

        pane.getChildren().add(hBox);
    }

    public void setList(List<Student> list){
        this.list=list;
        pageNumLabel.setText("Текущая страница: "+(pageNum+1)+"/"+(((list.size()-1)/recordsOnPage)+1));
        totalRecords.setText("Всего записей: "+list.size());
    }

    public void clear(){
        ObservableList<Student> list=FXCollections.observableArrayList();
        table.setItems(list);
    }

    public void addListOfRecords(List<Student> list){
        ObservableList<Student> observableList=FXCollections.observableArrayList(list);
        table.setItems(observableList);
    }

    public  void addNewRecord(Student student){
        table.getItems().add(student);
    }

    public VBox getPane(){
        return pane;
    }

    public void setPage(int pageNum){
        List<Student> page=new ArrayList<>();
        int numOfRecords=recordsOnPage;
        if((list.size()-pageNum*recordsOnPage)<recordsOnPage){
            numOfRecords=this.list.size()-pageNum*recordsOnPage;
        }
        for (int stud=pageNum*recordsOnPage;stud<pageNum*recordsOnPage+numOfRecords;stud++){
            page.add(this.list.get(stud));
        }
        clear();
        table.setItems(FXCollections.observableArrayList(page));
    }

    public int getPageNum(){
        return pageNum;
    }
}
