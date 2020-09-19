package application.controllers;

import application.model.CountyDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.sql.SQLException;


public class CountryController {

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;

    @FXML
    private TableView tableView;

    public void add() throws SQLException, ClassNotFoundException {
        //CountyDAO.addCountry();
    }

    public void edit() {
    }

    public void delete() {
    }

    public void search() {
    }
}
