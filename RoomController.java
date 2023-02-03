package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import sample.Model.Datasource;

public class RoomController {
    int rid;
    @FXML
    TextField nameInsertField;
    @FXML
    Spinner<Integer> capacityInsertField;

    public void setRid(int rid) {
        this.rid = rid;
    }

    void updateRoom() {
        Datasource.getInstance().updateRoom(rid,nameInsertField.getText(),Integer.parseInt(capacityInsertField.getEditor().getText()));
    }

    String insertRoom() {
        return Datasource.getInstance().insertRoom(nameInsertField.getText(),Integer.parseInt(capacityInsertField.getEditor().getText()));
    }
}
