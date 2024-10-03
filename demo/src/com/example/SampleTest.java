package com.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private AndroidDriver<MobileElement> driver;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "/path/to/your/app.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public void sampleTest() {
        MobileElement el = driver.findElementByAccessibilityId("Accessibility ID of an element");
        el.click();
        // Add more interactions
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        SampleTest test = new SampleTest();
        try {
            test.setUp();
            test.sampleTest();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}