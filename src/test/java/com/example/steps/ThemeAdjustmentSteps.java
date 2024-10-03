package com.example.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;

public class ThemeAdjustmentSteps {

    private AppiumDriver<MobileElement> driver;

    @Given("the system is set to light mode")
    public void the_system_is_set_to_light_mode() {
        // Code to set the system to light mode
        setSystemTheme("light");
    }

    @Given("the system is set to dark mode")
    public void the_system_is_set_to_dark_mode() {
        // Code to set the system to dark mode
        setSystemTheme("dark");
    }

    @When("the user launches the app")
    public void the_user_launches_the_app() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/path/to/your/app.apk");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Then("the app should display the light theme")
    public void the_app_should_display_the_light_theme() {
        // Code to verify the app is displaying the light theme
        verifyAppTheme("light");
    }

    @Then("the app should display the dark theme")
    public void the_app_should_display_the_dark_theme() {
        // Code to verify the app is displaying the dark theme
        verifyAppTheme("dark");
    }

    @Given("the user has the app open")
    public void the_user_has_the_app_open() throws MalformedURLException {
        the_user_launches_the_app();
    }

    @When("the system changes to dark mode")
    public void the_system_changes_to_dark_mode() {
        setSystemTheme("dark");
    }

    @Then("the app should dynamically change to the dark theme")
    public void the_app_should_dynamically_change_to_the_dark_theme() {
        // Code to verify the app dynamically changes to the dark theme
        verifyAppTheme("dark");
    }

    private void setSystemTheme(String theme) {
        // Code to change the system theme
        // This will depend on the specific implementation and capabilities of the test environment
        try {
            String command = theme.equals("dark") ? "settings put secure ui_night_mode 2" : "settings put secure ui_night_mode 1";
            Runtime.getRuntime().exec(new String[] { "adb", "shell", command });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void verifyAppTheme(String expectedTheme) {
        // Code to verify the app theme
        // This will depend on the specific implementation and capabilities of the app
        MobileElement themeElement = driver.findElementById("theme_element_id"); // Replace with actual element ID
        String actualTheme = themeElement.getAttribute("theme"); // Replace with actual attribute
        assertEquals(expectedTheme, actualTheme);
    }
}
