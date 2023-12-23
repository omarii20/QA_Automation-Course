package org.example.logic.Components;

import org.example.logic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    private final By logoLink = By.className("app_logo");

    public Header(WebDriver driver) {
        super(driver);
    }
    public void getAppName() {
        driver.findElement(logoLink).getText();
    }
}
