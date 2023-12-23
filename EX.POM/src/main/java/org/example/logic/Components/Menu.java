package org.example.logic.Components;

import org.example.logic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menu extends BasePage {
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By menuElement = By.className("bm-menu-wrap");

    public Menu (WebDriver driver) {
        super(driver);
    }
    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }
    public boolean isMenuVisible() {
        WebElement menu = driver.findElement(menuElement);
        String ariaHiddenValue = menu.getAttribute("aria-hidden");
        return !"true".equals(ariaHiddenValue);
    }
}
