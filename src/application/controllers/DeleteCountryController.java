package application.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class DeleteCountryController implements InitializableController {

    private CountryController countryController;

    @FXML
    private JFXTextField idTextField;

    @FXML
    private JFXButton deleteButton;

    public void init(CountryController countryController) {
        this.countryController = countryController;
        countryController.validator.setRequiredFieldValidator(idTextField);
        countryController.validator.setNumberValidator(idTextField);
    }

    public void deleteCountry() {
        int id = getID();
        countryController.countryDAO.deleteCountry(id);
        countryController.refreshTable();
        reset();
    }

    private int getID() {
        String text = idTextField.getText();
        return Integer.parseInt(text);
    }

    private void reset() {
        idTextField.setText("");
        idTextField.requestFocus();
    }
}
