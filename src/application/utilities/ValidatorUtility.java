package application.utilities;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

public class ValidatorUtility {

    private RequiredFieldValidator requiredFieldValidator;
    private NumberValidator numberValidator;

    public ValidatorUtility() {
        requiredFieldValidator = new RequiredFieldValidator();
        requiredFieldValidator.setMessage("Enter Value");
        numberValidator = new NumberValidator();
        numberValidator.setMessage("Enter Number");
    }

    public void setRequiredFieldValidator(JFXTextField jfxTextField) {
        jfxTextField.getValidators().add(requiredFieldValidator);
        jfxTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                jfxTextField.validate();
            }
        });
    }

    public void setNumberValidator(JFXTextField jfxTextField) {
        jfxTextField.getValidators().add(numberValidator);
        jfxTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                jfxTextField.validate();
            }
        });
    }
}
