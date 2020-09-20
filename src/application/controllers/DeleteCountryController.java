package application.controllers;

import application.model.CountryDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteCountryController {

    CountryDAO countryDAO = new CountryDAO();

    @FXML
    private TextField idTextField;

    @FXML
    private Button deleteButton;

    public void deleteCountry() {
        int id = getID();
        countryDAO.deleteCountry(id);
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
