package com.example.steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BarcodeScanSteps {

    private AndroidDriver<MobileElement> driver;

    @Given("the user has installed the Android application")
    public void the_user_has_installed_the_Android_application() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/path/to/your/app.apk");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Given("the user has opened the application")
    public void the_user_has_opened_the_application() {
        // Assuming the app is opened after installation
    }

    @Given("the user is on the barcode scan page")
    public void the_user_is_on_the_barcode_scan_page() {
        // Navigate to the barcode scan page
        driver.findElement(By.id("com.example:id/scanPageButton")).click();
    }

    @When("the user scans a valid EAN13 {string}")
    public void the_user_scans_a_valid_EAN13(String ean13) {
        // Simulate scanning a barcode
        driver.findElement(By.id("com.example:id/barcodeInput")).sendKeys(ean13);
        driver.findElement(By.id("com.example:id/scanButton")).click();
    }

    @When("the user scans an invalid EAN13 {string}")
    public void the_user_scans_an_invalid_EAN13(String ean13) {
        // Simulate scanning a barcode
        driver.findElement(By.id("com.example:id/barcodeInput")).sendKeys(ean13);
        driver.findElement(By.id("com.example:id/scanButton")).click();
    }

    @When("the user scans a barcode {string}")
    public void the_user_scans_a_barcode(String barcode) {
        // Simulate scanning a barcode
        driver.findElement(By.id("com.example:id/barcodeInput")).sendKeys(barcode);
        driver.findElement(By.id("com.example:id/scanButton")).click();
    }

    @When("the user scans an empty barcode")
    public void the_user_scans_an_empty_barcode() {
        // Simulate scanning an empty barcode
        driver.findElement(By.id("com.example:id/scanButton")).click();
    }

    @When("the user scans a non-numeric barcode {string}")
    public void the_user_scans_a_non_numeric_barcode(String barcode) {
        // Simulate scanning a non-numeric barcode
        driver.findElement(By.id("com.example:id/barcodeInput")).sendKeys(barcode);
        driver.findElement(By.id("com.example:id/scanButton")).click();
    }

    @Then("the application should interpret it as an EAN7 {string}")
    public void the_application_should_interpret_it_as_an_EAN7(String ean7) {
        // Verify the EAN7 interpretation
        String displayedEAN7 = driver.findElement(By.id("com.example:id/ean7Output")).getText();
        Assert.assertEquals(ean7, displayedEAN7);
    }

    @Then("the user should see the EAN7 displayed on the screen")
    public void the_user_should_see_the_EAN7_displayed_on_the_screen() {
        // This step is covered in the previous step
    }

    @Then("the application should display an error message {string}")
    public void the_application_should_display_an_error_message(String errorMessage) {
        // Verify the error message
        String displayedError = driver.findElement(By.id("com.example:id/errorMessage")).getText();
        Assert.assertEquals(errorMessage, displayedError);
    }
}
