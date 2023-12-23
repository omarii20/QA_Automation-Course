package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {

    WebDriver driver;
    public SetUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.driver = new ChromeDriver();
    }
    public WebDriver getDriver(){
        return this.driver;
    }
}
