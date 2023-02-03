package sample;

import javafx.fxml.FXML;
import sample.Model.Datasource;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML
    TextField idInsertField;
    @FXML
    TextField nameInsertField;
    @FXML
    TextField passInsertField;

    void updateStudent() {
        Datasource.getInstance().updateStudent(idInsertField.getText(),nameInsertField.getText(),passInsertField.getText());
    }

    String insertStudent() {
        return Datasource.getInstance().insertStudent(nameInsertField.getText(),passInsertField.getText());
    }
}
