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

    public CountryDAO countryDAO = new CountryDAO();

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
        populateTable(countries);
    }

    public void populateTable(ObservableList<Country> countries) {
        tableView.setItems(countries);
    }

    public void showAddCountryWindow() {
        createCustomWindow("/resources/fxml/addCountryLayout.fxml","Add country", 270, 270);
    }

    public void showRemoveCountryWindow() {
        createCustomWindow("/resources/fxml/deleteCountryLayout.fxml", "Delete country", 270, 300);
    }

    public void showEditCountryWindow() {
        createCustomWindow("/resources/fxml/editCountryLayout.fxml", "Edit country", 270, 330);
    }

    public void showSearchCountryWindow() {
        createCustomWindow("/resources/fxml/searchCountryLayout.fxml", "Search country", 520, 310);
    }

    private void createCustomWindow(String layoutURL, String title, int width, int height) {
       try {
           Stage stage = new Stage();
           FXMLLoader loader = new FXMLLoader(getClass().getResource(layoutURL));
           Parent node = loader.load();
           InitializableController controller = loader.getController();
           controller.init(this);
           Scene scene = new Scene(node);

           stage.setScene(scene);
           stage.setTitle(title);
           stage.setWidth(width);
           stage.setHeight(height);

           stage.show();
       }
       catch (IOException exception) {
           exception.printStackTrace();
       }
    }
}
