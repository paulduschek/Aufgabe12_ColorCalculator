/**
 * @author Paul Duschek
 * @version 1.0, 21.1.2021
 */


package ControllerFXML;

import Model.Model;             //implemented Model and ColorCode because they are not in the same package
import Model.ColorCode;
import Model.ModularCounter;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //FXML Implementations
    @FXML
    Label HexValue = new Label();
    @FXML
    Button colorBox = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public static void show(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Aufgabe 12 - Duschek");
            stage.setScene(new Scene(root, 628, 230));
            stage.show();
        } catch (IOException ex) {
            System.err.println("Something wrong with sample.fxml!");
            ex.printStackTrace(System.err);
        }
    }

    public void relativeInputValue (Event e)
    {
        Button b = (Button) e.getSource();      //Typecast to Type Button
        if (b.getId().contains("Red")) {
            Model.changeColorViaRelativeValue(ColorCode.RED, b.getText());
        } else if (b.getId().contains("Green")) {
            Model.changeColorViaRelativeValue(ColorCode.GREEN, b.getText());
        } else{
            Model.changeColorViaRelativeValue(ColorCode.BLUE, b.getText());
        }

        String hex = Model.getHex();
        HexValue.setText(hex);

        colorBox.setStyle("-fx-background-color: " + hex + ";");
    }

    public void absoluteInputValue (KeyEvent e)
    {
        TextField Text = (TextField) e.getSource();     //Typecast to Type TextField

        if((e.getCode().getCode() >= 48 && e.getCode().getCode() <= 57) || e.getCode().getCode() >= 96 && e.getCode().getCode() <= 105)      //if Schleife welche bewirkt, dass bei der Eingabe nur Zahlen zugelassen werden
        {
            if (Text.getId().contains("Red")) {
                Model.changeColorViaAbsoluteValue(ColorCode.RED, Integer.parseInt(Text.getText()));
            } else if (Text.getId().contains("Green")) {
                Model.changeColorViaAbsoluteValue(ColorCode.GREEN, Integer.parseInt(Text.getText()));
            } else {
                Model.changeColorViaAbsoluteValue(ColorCode.BLUE, Integer.parseInt(Text.getText()));
            }
        }
        else {
            System.out.println("Type in a valid number!");
            Text.clear();
        }

        String hex = Model.getHex();
        HexValue.setText(hex);

        colorBox.setStyle("-fx-background-color: " + hex + ";");
    }
}
