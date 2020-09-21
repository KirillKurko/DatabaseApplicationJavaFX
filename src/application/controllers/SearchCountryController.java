package application.controllers;

import application.model.Country;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private JFXRadioButton searchAllButton;

    @FXML
    private JFXRadioButton searchByIdButton;

    @FXML
    private JFXRadioButton searchByNameButton;

    @FXML
    private JFXRadioButton searchByCapitalButton;

    @FXML
    private JFXRadioButton searchByLanguageButton;

    @FXML
    private JFXTextField searchFieldTextField;

    @FXML
    private ToggleGroup toggleGroup;

    public void init(CountryController countryController) {
        this.countryController = countryController;
        countryController.validator.setRequiredFieldValidator(searchFieldTextField);
    }

    public void searchAllCountries() {
        searchFieldTextField.setVisible(false);
    }

    public void searchByID() {
        searchFieldTextField.setVisible(true);
    }

    public void searchByName() {
        searchFieldTextField.setVisible(true);
    }

    public void searchByCapital() {
        searchFieldTextField.setVisible(true);
    }

    public void searchByLanguage() {
        searchFieldTextField.setVisible(true);
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
    }
}
