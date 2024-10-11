package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ThemeAdjustmentSteps {

    private AppiumDriver<MobileElement> driver;

    public ThemeAdjustmentSteps() {
        // Initialize the Appium driver here
        // Example: driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Given("the system theme is set to Light mode")
    public void setSystemThemeToLightMode() {
        // Code to set the system theme to Light mode
    }

    @Given("the system theme is set to Dark mode")
    public void setSystemThemeToDarkMode() {
        // Code to set the system theme to Dark mode
    }

    @Given("the application is open")
    public void openApplication() {
        // Code to open the application
        driver.launchApp();
    }

    @When("I open the application")
    public void openApplicationWhen() {
        // Code to open the application
        driver.launchApp();
    }

    @When("I change the system theme to Light mode")
    public void changeSystemThemeToLightMode() {
        // Code to change the system theme to Light mode
    }

    @When("I change the system theme to Dark mode")
    public void changeSystemThemeToDarkMode() {
        // Code to change the system theme to Dark mode
    }

    @Then("the application should display in Light mode")
    public void verifyApplicationInLightMode() {
        // Code to verify the application is in Light mode
        MobileElement element = driver.findElement(By.id("theme_indicator"));
        Assert.assertEquals(element.getText(), "Light mode");
    }

    @Then("the application should display in Dark mode")
    public void verifyApplicationInDarkMode() {
        // Code to verify the application is in Dark mode
        MobileElement element = driver.findElement(By.id("theme_indicator"));
        Assert.assertEquals(element.getText(), "Dark mode");
    }

    @Then("the application should immediately display in Light mode")
    public void verifyApplicationImmediatelyInLightMode() {
        // Code to verify the application immediately displays in Light mode
        MobileElement element = driver.findElement(By.id("theme_indicator"));
        Assert.assertEquals(element.getText(), "Light mode");
    }

    @Then("the application should immediately display in Dark mode")
    public void verifyApplicationImmediatelyInDarkMode() {
        // Code to verify the application immediately displays in Dark mode
        MobileElement element = driver.findElement(By.id("theme_indicator"));
        Assert.assertEquals(element.getText(), "Dark mode");
    }
}
