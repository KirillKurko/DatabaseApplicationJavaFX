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

    public void init(CountryController countryController) {
        this.countryController = countryController;
    }

    public void searchAllCountries() {
        configureSearchComponents("All", false);
    }

    public void searchByID() {
        configureSearchComponents("ID", true);
    }

    public void searchByName() {
        configureSearchComponents("Name", true);
    }

    public void searchByCapital() {
        configureSearchComponents("Capital", true);
    }

    public void searchByLanguage() {
        configureSearchComponents("Language", true);
    }

    private void configureSearchComponents(String labelText, boolean visibility) {
        searchFieldLabel.setVisible(visibility);
        searchFieldTextField.setVisible(visibility);
        searchFieldLabel.setText(labelText);
        searchFieldTextField.setText("");
    }

    public void search() {
        ObservableList<Country> countries = null;
        if (searchAllButton.isSelected()) {
            countries = FXCollections.observableArrayList(countryController.countryDAO.selectAllCountries());
        }
        else if (searchByIdButton.isSelected()) {
            int id = Integer.parseInt(searchFieldTextField.getText());
            countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByID(id));

        }
        else if (searchByNameButton.isSelected()) {
            String name = searchFieldTextField.getText();
            countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByName(name));

        }
        else if (searchByCapitalButton.isSelected()) {
            String capital = searchFieldTextField.getText();
            countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByCapital(capital));
        }
        else if (searchByLanguageButton.isSelected()) {
            String language = searchFieldTextField.getText();
            countries = FXCollections.observableArrayList(countryController.countryDAO.selectCountryByLanguage(language));
        }
        countryController.populateTable(countries);
        searchFieldTextField.setText("");
    }
}
