package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EANConversionSteps {
    private AndroidDriver<MobileElement> driver;

    public EANConversionSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("the app is launched")
    public void theAppIsLaunched() {
        // Assuming the driver is already initialized and the app is launched in the Hooks class
        Assert.assertNotNull(driver);
    }

    @When("I scan an EAN13 barcode")
    public void iScanAnEAN13Barcode() {
        // Locate the scan button and click it
        MobileElement scanButton = driver.findElement(By.id("com.example.app:id/scan_button"));
        scanButton.click();

        // Simulate scanning an EAN13 barcode
        MobileElement barcodeInput = driver.findElement(By.id("com.example.app:id/barcode_input"));
        barcodeInput.sendKeys("1234567890123");

        // Submit the barcode
        MobileElement submitButton = driver.findElement(By.id("com.example.app:id/submit_button"));
        submitButton.click();
    }

    @Then("I should see the EAN7 conversion result")
    public void iShouldSeeTheEAN7ConversionResult() {
        // Verify the EAN7 conversion result
        MobileElement result = driver.findElement(By.id("com.example.app:id/result"));
        String resultText = result.getText();
        Assert.assertEquals(resultText, "1234567");
    }
}
