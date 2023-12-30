package infra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class SetUp {
    private AppiumDriver<MobileElement> driver;
    public SetUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.android.settings");
        caps.setCapability("appActivity", "com.android.settings.Settings");

        try {
            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver<>(url, caps);
            System.out.println("Driver initialized successfully.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public  AppiumDriver<MobileElement> getDriver(){
        return driver;
    }
    public void quitDriver() {
        if (  driver != null) {
            driver.quit();
        }
    }
}
