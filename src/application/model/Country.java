package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Country {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty capital;
    private StringProperty language;

    public Country(int id, String name, String capital, String language) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.capital = new SimpleStringProperty(capital);
        this.language = new SimpleStringProperty(language);
    }

    public Country(String name, String capital, String language) {
        this.name = new SimpleStringProperty(name);
        this.capital = new SimpleStringProperty(capital);
        this.language = new SimpleStringProperty(language);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getCapital() {
        return capital.get();
    }

    public String getLanguage() {
        return language.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public StringProperty getCapitalProperty() {
        return capital;
    }

    public StringProperty getLanguageProperty() {
        return language;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setCapital(String capital) {
        this.capital.set(capital);
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }
}
