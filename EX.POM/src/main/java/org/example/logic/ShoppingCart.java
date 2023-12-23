package org.example.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart extends BasePage {
    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private final By inventoryItem = By.className("inventory_item");
    public ShoppingCart(WebDriver driver) {
       super(driver);
    }
    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
    public boolean isProductAddedToCart() {
        clickAddToCartButton();
        WebElement inventoryItemElement = driver.findElement(inventoryItem);
        try {
            WebElement shoppingCartBadge = inventoryItemElement.findElement(By.cssSelector(".shopping_cart_badge"));
            return shoppingCartBadge.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
