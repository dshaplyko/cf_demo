package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ThemeSettingsSteps {

    private AndroidDriver<MobileElement> driver;

    public ThemeSettingsSteps() {
        // Initialize the driver here or use dependency injection
        this.driver = DriverFactory.getDriver();
    }

    @Given("the device is set to Light mode")
    public void setDeviceToLightMode() {
        // Code to set the device to Light mode
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "settings put secure ui_night_mode 1"));
    }

    @Given("the device is set to Dark mode")
    public void setDeviceToDarkMode() {
        // Code to set the device to Dark mode
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "settings put secure ui_night_mode 2"));
    }

    @When("the app is launched")
    public void launchApp() {
        // Code to launch the app
        driver.launchApp();
    }

    @Then("the app should display the Light theme")
    public void verifyLightTheme() {
        // Code to verify the app displays the Light theme
        MobileElement themeElement = driver.findElement(By.id("theme_element_id")); // Replace with actual element ID
        String theme = themeElement.getAttribute("theme"); // Replace with actual attribute
        Assert.assertEquals(theme, "light", "The app is not displaying the Light theme");
    }

    @Then("the app should display the Dark theme")
    public void verifyDarkTheme() {
        // Code to verify the app displays the Dark theme
        MobileElement themeElement = driver.findElement(By.id("theme_element_id")); // Replace with actual element ID
        String theme = themeElement.getAttribute("theme"); // Replace with actual attribute
        Assert.assertEquals(theme, "dark", "The app is not displaying the Dark theme");
    }
}
