package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Datasource;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.setTitle("Attendance Management System");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaximized(true);
            primaryStage.show();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        super.init();
        Datasource.getInstance().open();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
