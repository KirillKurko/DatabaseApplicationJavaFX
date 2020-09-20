package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class CountryController {

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;

    @FXML
    private TableView tableView;

    public void showAddCountryWindow() {
        try {
            Stage stage = new Stage();
            Parent node = FXMLLoader.load(getClass().getResource("/resources/fxml/addCountryLayout.fxml"));
            Scene scene = new Scene(node);

            stage.setScene(scene);
            stage.setTitle("Add country");
            stage.setWidth(300);
            stage.setHeight(300);

            stage.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void showRemoveCountryWindow() {
        try {
            Stage stage = new Stage();
            Parent node = FXMLLoader.load(getClass().getResource("/resources/fxml/removeCountryLayout.fxml"));
            Scene scene = new Scene(node);

            stage.setScene(scene);
            stage.setTitle("Delete country");
            stage.setWidth(270);
            stage.setHeight(300);

            stage.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void edit() {
    }

    public void delete() {
    }

    public void search() {
    }
}
