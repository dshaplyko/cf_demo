package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ConversionSteps {

    private AndroidDriver<MobileElement> driver;
    private String ean13;
    private String ean7;

    public ConversionSteps() {
        // Initialize the driver here or use dependency injection
        // Example: this.driver = DriverFactory.getDriver();
    }

    @Given("an EAN of 13 characters {string}")
    public void givenAnEanOf13Characters(String ean) {
        this.ean13 = ean;
    }

    @When("I submit this EAN to the application")
    public void whenISubmitThisEanToTheApplication() {
        // Locate the input field and submit button
        MobileElement inputField = driver.findElement(By.id("input_field_id")); // Replace with actual ID
        MobileElement submitButton = driver.findElement(By.id("submit_button_id")); // Replace with actual ID

        // Enter the EAN and submit
        inputField.sendKeys(ean13);
        submitButton.click();

        // Assuming the application displays the result in a specific element
        MobileElement resultElement = driver.findElement(By.id("result_element_id")); // Replace with actual ID
        ean7 = resultElement.getText();
    }

    @Then("the last 6 characters are removed to obtain {string}")
    public void thenTheLast6CharactersAreRemovedToObtain(String expectedEan7) {
        Assert.assertEquals(ean7, expectedEan7, "The EAN7 conversion is incorrect.");
    }
}
