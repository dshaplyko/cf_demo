package com.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefinitions {

    private String ean13;
    private String ean7;

    @Given("an EAN of 13 characters {string}")
    public void givenAnEANOf13Characters(String ean) {
        this.ean13 = ean;
    }

    @When("I submit this EAN to the application")
    public void whenISubmitThisEANToTheApplication() {
        // Simulate the submission to the application and conversion
        this.ean7 = ean13.substring(0, 7);
    }

    @Then("the last 6 characters are removed to obtain {string}")
    public void thenTheLast6CharactersAreRemovedToObtain(String expectedEan7) {
        assertEquals(expectedEan7, this.ean7);
    }

    private AndroidDriver<MobileElement> driver;

    @Given("the app is launched")
    public void the_app_is_launched() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "/path/to/your/app.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @When("I click on the element")
    public void i_click_on_the_element() {
        MobileElement el = driver.findElementByAccessibilityId("Accessibility ID of an element");
        el.click();
    }

    @Then("I should see the result")
    public void i_should_see_the_result() {
        // Add assertions here
        driver.quit();
    }
}