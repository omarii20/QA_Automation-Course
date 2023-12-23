package org.example.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Main extends BasePage{
    private final By inventoryList = By.className("inventory_list");
    public Main(WebDriver driver){
        super(driver);
    }
    public boolean areItemsLoaded() {
        WebElement inventoryListElement = driver.findElement(inventoryList);
        List<WebElement> items = inventoryListElement.findElements(By.className("inventory_item"));
        return !items.isEmpty();
    }
}
