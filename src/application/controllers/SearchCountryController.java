package application.controllers;

import application.model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private RadioButton searchAllButton;

    @FXML
    private RadioButton searchByIdButton;

    @FXML
    private RadioButton searchByNameButton;

    @FXML
    private RadioButton searchByCapitalButton;

    @FXML
    private RadioButton searchByLanguageButton;

    @FXML
    private Label searchFieldLabel;

    @FXML
    private TextField searchFieldTextField;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private void initialize() {
        toggleGroup = new ToggleGroup();
        searchAllButton.setToggleGroup(toggleGroup);
        searchByIdButton.setToggleGroup(toggleGroup);
        searchByNameButton.setToggleGroup(toggleGroup);
        searchByCapitalButton.setToggleGroup(toggleGroup);
        searchByLanguageButton.setToggleGroup(toggleGroup);
        searchAllButton.requestFocus();
    }

    public void init(CountryController countryController) {
        this.countryController = countryController;
    }

    public void searchAllCountries() {
        searchFieldLabel.setVisible(false);
        searchFieldTextField.setVisible(false);
    }

    public void searchByID() {
        searchFieldLabel.setText("ID");
        searchFieldTextField.setText("");
        searchFieldLabel.setVisible(true);
        searchFieldTextField.setVisible(true);
    }

    public void searchByName() {
        searchFieldLabel.setText("Name");
        searchFieldTextField.setText("");
        searchFieldLabel.setVisible(true);
        searchFieldTextField.setVisible(true);
    }

    public void searchByCapital() {
        searchFieldLabel.setText("Capital");
        searchFieldTextField.setText("");
        searchFieldLabel.setVisible(true);
        searchFieldTextField.setVisible(true);
    }

    public void searchByLanguage() {
        searchFieldLabel.setText("Language");
        searchFieldTextField.setText("");
        searchFieldLabel.setVisible(true);
        searchFieldTextField.setVisible(true);
    }

    public void search() {
        if (searchAllButton.isSelected()) {
            countryController.refreshTable();
        }
        else if (searchByIdButton.isSelected()) {
            int id = Integer.parseInt(searchFieldTextField.getText());
            ObservableList<Country> countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByID(id));
            countryController.populateTable(countries);
        }
        else if (searchByNameButton.isSelected()) {
            String name = searchFieldTextField.getText();
            ObservableList<Country> countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByName(name));
            countryController.populateTable(countries);
        }
        else if (searchByCapitalButton.isSelected()) {
            String capital = searchFieldTextField.getText();
            ObservableList<Country> countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByCapital(capital));
            countryController.populateTable(countries);
        }
        else if (searchByLanguageButton.isSelected()) {
            String language = searchFieldTextField.getText();
            ObservableList<Country> countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByLanguage(language));
            countryController.populateTable(countries);
        }
        searchFieldTextField.setText("");
    }
}
