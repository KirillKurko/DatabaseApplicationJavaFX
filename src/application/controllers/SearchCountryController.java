package application.controllers;

public class SearchCountryController implements InitializableController {

    CountryController countryController;

    public void init(CountryController countryController) {
        this.countryController = countryController;
    }
}
