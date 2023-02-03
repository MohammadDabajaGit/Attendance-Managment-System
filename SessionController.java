package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import sample.Model.Datasource;
import javafx.scene.control.TextField;
import java.sql.Timestamp;
import java.time.LocalDate;

public class SessionController {

    int sid;
    @FXML
    TextField nameInsertField;
    @FXML
    TextField courseInsertField;
    @FXML
    TextField teacherInsertField;
    @FXML
    TextField roomInsertField;
    @FXML
    TextArea descriptionInsertField;
    @FXML
    DatePicker timeInsertField;

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void initialize() {
        timeInsertField.setValue(LocalDate.now());
    }

    String updateSession() {
        return Datasource.getInstance().updateSession(sid,nameInsertField.getText(),teacherInsertField.getText(),courseInsertField.getText(),roomInsertField.getText(),Timestamp.valueOf(timeInsertField.getValue().atStartOfDay()),descriptionInsertField.getText());
    }

    String insertSession() {
        return Datasource.getInstance().insertSession(nameInsertField.getText(),courseInsertField.getText(),teacherInsertField.getText(),roomInsertField.getText(),Timestamp.valueOf(timeInsertField.getValue().atStartOfDay()),descriptionInsertField.getText());
    }
}