package application.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent rootNode = FXMLLoader.load(getClass().getResource("/resources/fxml/mainWindowLayout.fxml"));
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Traveller handbook");
        primaryStage.setWidth(620);
        primaryStage.setHeight(705);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
