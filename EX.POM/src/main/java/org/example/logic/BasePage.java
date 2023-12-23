package org.example.logic;

import org.example.infra.SetUp;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        initializeWebDriver();
    }
    private void initializeWebDriver() {
        SetUp.initializeWebDriver();
        driver = SetUp.getDriver();
    }
    public void close(){
        SetUp.closeDriver();
    }
}
