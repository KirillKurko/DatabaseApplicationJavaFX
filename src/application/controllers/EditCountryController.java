package application.controllers;

import application.model.Country;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField capitalTextField;

    @FXML
    private TextField languageTextField;

    public void init(CountryController countryController) {
        this.countryController = countryController;
    }

    public void editCountry() {
        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextField.getText();
        String capital = capitalTextField.getText();
        String language = languageTextField.getText();
        Country country = new Country(id, name, capital, language);
        countryController.countryDAO.updateCountry(country);
        countryController.refreshTable();
        reset();
    }

    private void reset() {
        idTextField.setText("");
        nameTextField.setText("");
        capitalTextField.setText("");
        languageTextField.setText("");
        idTextField.requestFocus();
    }
}
