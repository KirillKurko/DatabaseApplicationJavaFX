package application.controllers;

import application.model.Country;
import application.model.CountryDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class CountryController {

    CountryDAO countryDAO = new CountryDAO();

    @FXML
    private TableColumn<Country, Integer> countryIdColumn;

    @FXML
    private TableColumn<Country, String> countryNameColumn;

    @FXML
    private TableColumn<Country, String> countryCapitalColumn;

    @FXML
    private TableColumn<Country, String> countryLanguageColumn;

    @FXML
    private TableView<Country> tableView;

    @FXML
    private void initialize() {
        countryIdColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        countryNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        countryCapitalColumn.setCellValueFactory(cellData -> cellData.getValue().getCapitalProperty());
        countryLanguageColumn.setCellValueFactory(cellData -> cellData.getValue().getLanguageProperty());
        ObservableList<Country> countries = FXCollections.observableArrayList(countryDAO.selectAllCountries());
        populateTable(countries);
    }

    private void populateTable(ObservableList<Country> countries) {
        tableView.setItems(countries);
    }
    
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
            Parent node = FXMLLoader.load(getClass().getResource("/resources/fxml/deleteCountryLayout.fxml"));
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

    public void search() {
    }
}
