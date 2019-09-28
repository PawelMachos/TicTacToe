package pl.com.sda.pawel.machos.programowanieII_Rafal.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTTTFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/viewBoard/tttBoard.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight()));
        primaryStage.show();
    }
}