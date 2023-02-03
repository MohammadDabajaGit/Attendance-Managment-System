package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import sample.Model.Datasource;

import java.io.IOException;


public class LoginController {

    @FXML
    TextField user;
    @FXML
    PasswordField pass;

    public void login(ActionEvent login ) {
        if(Datasource.getInstance().queryAdmin(user.getText(),pass.getText())) {
            try {
                Stage window = (Stage) ((Node)login.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                window.setTitle("Attendance Management System");
                window.setScene(new Scene(root));
                window.setMaximized(true);
                window.show();
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            user.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            pass.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        }
    }
}
