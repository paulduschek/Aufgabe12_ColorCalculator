/**
 * @author Paul Duschek
 * @version 1.0, 21.1.2021
 */


import ControllerFXML.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
