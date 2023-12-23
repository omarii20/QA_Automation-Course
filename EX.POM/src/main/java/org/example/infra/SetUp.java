package org.example.infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    private static WebDriver driver;
    public static void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
