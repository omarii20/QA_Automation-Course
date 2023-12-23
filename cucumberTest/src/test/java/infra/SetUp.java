package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    WebDriver driver;

    public SetUp (String URL){
        System.setProperty("webdriver.chrome.driver", "/home/omarii301/Desktop/QA-Automation/Cucumber/cucumberTest/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.get(URL);
    }
    public WebDriver getDriver(){
        return this.driver;
    }
}
