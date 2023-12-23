package org.IntroToSeleniume.infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverUtils {
    public static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        return new ChromeDriver();
    }
}
