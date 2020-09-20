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
        reset();
    }

    private void reset() {
        idTextField.setText("");
        nameTextField.setText("");
        capitalTextField.setText("");
        languageTextField.setText("");
    }
}
