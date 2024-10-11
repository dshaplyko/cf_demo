package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class ThemeChangeSteps {
    private IOSDriver<MobileElement> driver;

    @Given("the app is launched")
    public void theAppIsLaunched() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "14.4");
        caps.setCapability("deviceName", "iPhone Simulator");
        caps.setCapability("app", "/path/to/your/app.app");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @When("the device theme is set to dark mode")
    public void theDeviceThemeIsSetToDarkMode() {
        driver.executeScript("mobile: deviceSettings", ImmutableMap.of("theme", "dark"));
    }

    @When("the device theme is set to light mode")
    public void theDeviceThemeIsSetToLightMode() {
        driver.executeScript("mobile: deviceSettings", ImmutableMap.of("theme", "light"));
    }

    @Then("the app theme should change to dark mode")
    public void theAppThemeShouldChangeToDarkMode() {
        MobileElement themeElement = driver.findElementByAccessibilityId("themeElement");
        String theme = themeElement.getAttribute("value");
        Assert.assertEquals(theme, "dark");
    }

    @Then("the app theme should change to light mode")
    public void theAppThemeShouldChangeToLightMode() {
        MobileElement themeElement = driver.findElementByAccessibilityId("themeElement");
        String theme = themeElement.getAttribute("value");
        Assert.assertEquals(theme, "light");
    }
}
