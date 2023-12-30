package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Infrastructure {
    private static WebDriver driver;
    private Infrastructure(WebDriver driver){
        this.setDriver(driver);
    }
    public static Infrastructure initInfra(String driverPath,String webLink){
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(webLink);
        return new Infrastructure(driver);
    }
    public void closeDriver(){
        driver.close();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        Infrastructure.driver = driver;
    }
}
