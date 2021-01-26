/**
 * @author Paul Duschek
 * @version 1.0, 21.1.2021
 */


package ControllerFXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public static void show(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            Controller control = fxmlLoader.getController();
            //control.setStage(stage);

            stage.setTitle("Aufgabe 11 - Duschek");
            stage.setScene(new Scene(root, 466, 230));
            stage.show();
        } catch (IOException ex) {
            System.err.println("Something wrong with sample.fxml!");
            ex.printStackTrace(System.err);
        }
    }
}
