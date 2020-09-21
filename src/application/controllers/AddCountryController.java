package application.controllers;

import application.model.Country;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class AddCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField capitalTextField;

    @FXML
    private JFXTextField languageTextField;

    public void init(CountryController countryController) {
        this.countryController = countryController;
        countryController.validator.setRequiredFieldValidator(nameTextField);
        countryController.validator.setRequiredFieldValidator(capitalTextField);
        countryController.validator.setRequiredFieldValidator(languageTextField);
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
        nameTextField.requestFocus();
    }
}
