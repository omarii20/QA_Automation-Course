package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebDriverPage extends BasePage {
    private final WebDriver driver;
    private WebElement webDriverLink;
    private final WebElement webElementsLink;

    public WebDriverPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.webDriverLink = driver.findElement(By.xpath("//li/a[@id='m-documentationwebdriver']"));
        this.webElementsLink = driver.findElement(By.xpath("//li/a[@id='m-documentationwebdriverelements']"));
    }

    public void clickToNavigateWebDriverPage() {
        webDriverLink.click();
    }

    public void clickToNavigateWebElementsPage() {
        webElementsLink.click();
    }
}
