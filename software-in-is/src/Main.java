import Model.StudentDatabase;
import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    public void start(Stage primaryStage){
       Controller controller=new Controller();
        StudentDatabase studentDatabase=new StudentDatabase(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}