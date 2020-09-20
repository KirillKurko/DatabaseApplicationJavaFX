package application.controllers;

import application.model.Country;
import application.model.CountryDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCountryController {

    CountryDAO countryDAO = new CountryDAO();

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField capitalTextField;

    @FXML
    private TextField languageTextField;

    public void addCountry() {
        String name = nameTextField.getText();
        String capital = capitalTextField.getText();
        String language = languageTextField.getText();
        Country country = new Country(name, capital, language);
        countryDAO.insertCountry(country);
        reset();
    }

    private void reset() {
        nameTextField.setText("");
        capitalTextField.setText("");
        languageTextField.setText("");
    }
}
