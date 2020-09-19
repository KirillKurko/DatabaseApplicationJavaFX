package application.model;

public class Country {

    private int id;
    private String name;
    private String capital;
    private String language;

    public Country(int id, String name, String capital, String language) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.language = language;
    }

    public Country(String name, String capital, String language) {
        this.name = name;
        this.capital = capital;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
