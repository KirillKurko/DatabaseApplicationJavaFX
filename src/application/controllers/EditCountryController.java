package application.controllers;

import application.model.Country;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class EditCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private JFXTextField idTextField;

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField capitalTextField;

    @FXML
    private JFXTextField languageTextField;

    public void init(CountryController countryController) {
        this.countryController = countryController;
        countryController.validator.setNumberValidator(idTextField);
        countryController.validator.setRequiredFieldValidator(idTextField);
        countryController.validator.setRequiredFieldValidator(nameTextField);
        countryController.validator.setRequiredFieldValidator(capitalTextField);
        countryController.validator.setRequiredFieldValidator(languageTextField);
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
