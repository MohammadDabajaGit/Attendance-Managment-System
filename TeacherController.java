package sample;

        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import sample.Model.Datasource;

public class TeacherController {
    @FXML
    TextField idInsertField;
    @FXML
    TextField passInsertField;
    @FXML
    TextField nameInsertField;

    void updateTeacher() {
        Datasource.getInstance().updateTeacher(idInsertField.getText(),nameInsertField.getText(),passInsertField.getText());
    }

    String insertTeacher() {
        return Datasource.getInstance().insertTeacher(nameInsertField.getText(),passInsertField.getText());
    }
}
