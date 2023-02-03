package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import sample.Model.Datasource;
import javafx.scene.control.TextField;

public class CourseRegistrationController {
    int sid;
    String cid;
    @FXML
    TextField studentInsertField;
    @FXML
    TextField courseInsertField;

    String updateCourseRegistration() {
        return Datasource.getInstance().updateCourseRegistration(studentInsertField.getText(),courseInsertField.getText(),studentInsertField.getPromptText(),courseInsertField.getPromptText());
    }

    String insertCourseRegistration() {
        return Datasource.getInstance().insertCourseRegistration(studentInsertField.getText(),courseInsertField.getText());
    }
}