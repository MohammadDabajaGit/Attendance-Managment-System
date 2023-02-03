package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import sample.Model.Datasource;
import javafx.scene.control.TextField;

public class CourseController {
    @FXML
    TextField idInsertField;
    @FXML
    TextField nameInsertField;
    @FXML
    TextArea descriptionInsertField;

    void updateCourse() {
        Datasource.getInstance().updateCourse(idInsertField.getText(),nameInsertField.getText(),descriptionInsertField.getText());
    }

    String insertCourse() {
        return Datasource.getInstance().insertCourse(idInsertField.getText(),nameInsertField.getText(),descriptionInsertField.getText());
    }
}