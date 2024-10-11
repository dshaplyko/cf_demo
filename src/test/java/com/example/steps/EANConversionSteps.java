package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class EANConversionSteps {

    private String ean;
    private String result;

    @Given("I am a user with a 12-character EAN {string}")
    public void i_am_a_user_with_a_12_character_EAN(String ean) {
        this.ean = ean;
    }

    @Given("I am a user with a 13-character EAN {string}")
    public void i_am_a_user_with_a_13_character_EAN(String ean) {
        this.ean = ean;
    }

    @When("I submit the EAN")
    public void i_submit_the_EAN() {
        if (ean.length() == 12 && (ean.startsWith("02") || ean.startsWith("21"))) {
            result = "0" + ean;
            result = result.substring(0, 7);
        } else if (ean.length() == 12) {
            result = ean;
        } else if (ean.length() == 13) {
            result = ean;
        }
    }

    @Then("a {string} is added at the beginning to format it as EAN13")
    public void a_is_added_at_the_beginning_to_format_it_as_EAN13(String prefix) {
        Assert.assertTrue(result.startsWith(prefix));
    }

    @Then("the last 6 characters are removed to get an EAN7 {string}")
    public void the_last_6_characters_are_removed_to_get_an_EAN7(String ean7) {
        Assert.assertEquals(result, ean7);
    }

    @Then("the EAN is not modified")
    public void the_EAN_is_not_modified() {
        Assert.assertEquals(result, ean);
    }

    @Then("a {string} is added at the beginning to format it as EAN13, resulting in {string}")
    public void a_is_added_at_the_beginning_to_format_it_as_EAN13_resulting_in(String prefix, String expectedResult) {
        Assert.assertEquals(result, expectedResult);
    }
}
