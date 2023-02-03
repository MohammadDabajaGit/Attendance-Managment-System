package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Model.Datasource;

public class TeachersCourseController {
    @FXML
    TextField teacherInsertField;
    @FXML
    TextField courseInsertField;

    String updateTeacherCourse() {
        return Datasource.getInstance().updateTeachersCourse(teacherInsertField.getPromptText(),courseInsertField.getPromptText(),teacherInsertField.getText(),courseInsertField.getText());
    }

    String insertTeacherCourse() {
        return Datasource.getInstance().insertTeachersCourse(teacherInsertField.getText(),courseInsertField.getText());
    }
}
