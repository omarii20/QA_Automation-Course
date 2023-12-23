package org.example.logic.Components;

import org.example.logic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Footer extends BasePage {
    private final By logoLink = By.className("footer");
    private final By socialList = By.xpath("//footer[@class='footer']//ul[@class='social']/li");

    public Footer(WebDriver driver) {
        super(driver);
    }
    public void clickSocialWeb() {
        driver.findElement(logoLink).click();
    }
    public List<WebElement> getSocialLinks(){
        return driver.findElements(socialList);
    }
}
