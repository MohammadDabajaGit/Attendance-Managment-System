package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.Model.Datasource;
import sample.Model.Session;

import java.io.IOException;
import java.util.Optional;

public class DoctorController {

    @FXML
    ListView mainList;

    @FXML
    BorderPane mainPane;

    @FXML
    BorderPane roomDataView;
    @FXML
    BorderPane sessionDataView;


    //session
    @FXML
    TableView sessionTableView;
    @FXML
    TextField sessionNameSearchField;
    @FXML
    TextField sessionCourseIdSearchField;
    @FXML
    TextField sessionCourseNameSearchField;
    @FXML
    TextField sessionTeacherIdSearchField;
    @FXML
    TextField sessionTeacherNameSearchField;
    @FXML
    TextField sessionRoomNameSearchField;
    @FXML
    TextField sessionDescriptionSearchField;
    @FXML
    private ObservableList<Session> sessions;

    @FXML
    void handleSessionField() {
        System.out.println(sessionNameSearchField.getText() + " " + sessionCourseIdSearchField.getText() + " " + sessionCourseNameSearchField.getText() + " " + sessionDescriptionSearchField);
        sessions.setAll(Datasource.getInstance().querySession(sessionNameSearchField.getText(),sessionCourseIdSearchField.getText(),sessionCourseNameSearchField.getText(),sessionTeacherIdSearchField.getText(),sessionTeacherNameSearchField.getText(),sessionRoomNameSearchField.getText(),sessionDescriptionSearchField.getText()));
    }

    @FXML
    public void showSessionInsertDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Session");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sessionDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't open dialog: " + e.getMessage());
        }
        ButtonType Insert = new ButtonType("Insert");
        dialog.getDialogPane().getButtonTypes().add(Insert);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == Insert) {
            SessionController controller = fxmlLoader.getController();
            String error = controller.insertSession();
            Alert alert = new Alert(Alert.AlertType.ERROR,error);
            if(!error.equals("")) {
                alert.showAndWait();
                System.out.println("error");
            }
            sessions.setAll(Datasource.getInstance().querySession("","","","","","",""));
            System.out.println("insert");

        }
        else {
            System.out.println("cancel");
        }
    }

    @FXML
    public void handleClickMainList() {
        String item = (String)mainList.getSelectionModel().getSelectedItem();
        sessionDataView.setVisible(true);
        roomDataView.setVisible(false);
        switch (item) {
            case "session": {
                System.out.println("session");
                sessionDataView.setVisible(true);
                break;
            }
            case "rooms": {
                System.out.println("rooms");
                roomDataView.setVisible(true);
                break;
            }
        }
    }
}
