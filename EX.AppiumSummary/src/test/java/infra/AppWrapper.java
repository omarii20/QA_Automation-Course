package infra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppWrapper {
    private AndroidDriver<MobileElement> driver;
    public AppWrapper(){
        init();
    }
    public AndroidDriver<MobileElement> getDriver(){
        return driver;
    }
    public void closeDriver(){
        driver.close();
    }
    public void init(){
        PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", propertiesWrapper.getProperties("platformName"));
        caps.setCapability("deviceName", propertiesWrapper.getProperties("deviceName"));
        caps.setCapability("platformVersion", propertiesWrapper.getProperties("platformVersion"));
        caps.setCapability("automationName", propertiesWrapper.getProperties("automationName"));
        caps.setCapability("appPackage", propertiesWrapper.getProperties("appPackage"));
        caps.setCapability("appActivity", propertiesWrapper.getProperties("appActivity"));

        try {
            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver<>(url, caps);
            System.out.println("Driver initialized successfully.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
