package application.controllers;

import application.model.Country;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField capitalTextField;

    @FXML
    private TextField languageTextField;

    public void init(CountryController countryController) {
        this.countryController = countryController;
    }

    public void addCountry() {
        String name = nameTextField.getText();
        String capital = capitalTextField.getText();
        String language = languageTextField.getText();
        Country country = new Country(name, capital, language);
        countryController.countryDAO.insertCountry(country);
        countryController.refreshTable();
        reset();
    }

    private void reset() {
        nameTextField.setText("");
        capitalTextField.setText("");
        languageTextField.setText("");
    }
}
