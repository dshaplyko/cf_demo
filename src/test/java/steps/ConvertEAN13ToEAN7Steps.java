package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ConvertEAN13ToEAN7Steps {

    private String ean13;
    private String ean7;
    private String errorMessage;

    @Given("the user has a valid EAN13 barcode {string}")
    public void the_user_has_a_valid_EAN13_barcode(String barcode) {
        this.ean13 = barcode;
    }

    @Given("the user has an invalid EAN13 barcode {string}")
    public void the_user_has_an_invalid_EAN13_barcode(String barcode) {
        this.ean13 = barcode;
    }

    @Given("the user has an EAN13 barcode {string}")
    public void the_user_has_an_EAN13_barcode(String barcode) {
        this.ean13 = barcode;
    }

    @When("the user converts the EAN13 barcode to EAN7")
    public void the_user_converts_the_EAN13_barcode_to_EAN7() {
        try {
            this.ean7 = convertEAN13ToEAN7(this.ean13);
            this.errorMessage = null;
        } catch (IllegalArgumentException e) {
            this.errorMessage = e.getMessage();
            this.ean7 = null;
        }
    }

    @When("the user attempts to convert the EAN13 barcode to EAN7")
    public void the_user_attempts_to_convert_the_EAN13_barcode_to_EAN7() {
        try {
            this.ean7 = convertEAN13ToEAN7(this.ean13);
            this.errorMessage = null;
        } catch (IllegalArgumentException e) {
            this.errorMessage = e.getMessage();
            this.ean7 = null;
        }
    }

    @Then("the system should return the EAN7 barcode {string}")
    public void the_system_should_return_the_EAN7_barcode(String expectedEAN7) {
        Assert.assertEquals(expectedEAN7, this.ean7);
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, this.errorMessage);
    }

    private String convertEAN13ToEAN7(String ean13) {
        if (ean13.length() != 13 || !ean13.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid EAN13 barcode");
        }
        // Simplified conversion logic for demonstration purposes
        return ean13.substring(0, 7);
    }
}
