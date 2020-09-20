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

    @FXML
    CountryDAO countryDAO = new CountryDAO();

    @FXML
    public TableColumn<Country, Integer> countryIdColumn;

    @FXML
    public TableColumn<Country, String> countryNameColumn;

    @FXML
    public TableColumn<Country, String> countryCapitalColumn;

    @FXML
    public TableColumn<Country, String> countryLanguageColumn;

    @FXML
    public TableView<Country> tableView;

    @FXML
    private void initialize() {
        countryIdColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        countryNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        countryCapitalColumn.setCellValueFactory(cellData -> cellData.getValue().getCapitalProperty());
        countryLanguageColumn.setCellValueFactory(cellData -> cellData.getValue().getLanguageProperty());
        refreshTable();
    }

    public void refreshTable() {
        ObservableList<Country> countries = FXCollections.observableArrayList(countryDAO.selectAllCountries());
        tableView.setItems(countries);
    }

    public void showAddCountryWindow() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/addCountryLayout.fxml"));
            Parent node = loader.load();
            AddCountryController addCountryController = (AddCountryController) loader.getController();
            addCountryController.init(this);
            Scene scene = new Scene(node);

            stage.setScene(scene);
            stage.setTitle("Add country");
            stage.setWidth(270);
            stage.setHeight(270);
            stage.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void showRemoveCountryWindow() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/deleteCountryLayout.fxml"));
            Parent node = loader.load();
            DeleteCountryController deleteCountryController = (DeleteCountryController) loader.getController();
            deleteCountryController.init(this);
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
