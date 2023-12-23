package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage  extends BasePage{

    private final String menuSideBtn = "//form/button";
    private final WebElement buttonSideMenu;

    public HomePage (WebDriver driver){
        super(driver);
        this.buttonSideMenu= this.driver.findElement(By.xpath(menuSideBtn));
    }
}
