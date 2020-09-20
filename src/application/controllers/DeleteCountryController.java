package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteCountryController {

    private CountryController countryController;

    @FXML
    private TextField idTextField;

    @FXML
    private Button deleteButton;

    public void init(CountryController countryController) {
        this.countryController = countryController;
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
    }
}
