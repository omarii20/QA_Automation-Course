package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PlayerSection {
    private final WebDriver driver;
    public PlayerSection (WebDriver driver){
        this.driver = driver;
    }
    private final By playerPoint = By.xpath("//table[@class='Crom_table__p1iZz']/tbody/tr[1]/td[9]");
    private final By dropDownElement = By.xpath("(//div/label/div/select/option[@value='2023-24'])/ancestor::select");
    private final By firstPlayer = By.xpath("//table[@class='Crom_table__p1iZz']/tbody/tr[1]/td[2]/a");
    public void selectSeason(String seasonYear) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.elementToBeClickable(dropDownElement)).click();
        By optionLocator = By.xpath("//div/label/div/select/option[@value='" + seasonYear + "']");
        driver.findElement(optionLocator).click();
    }
    public String getPlayerPoint (){
        WebElement playerPointElement = driver.findElement(playerPoint);
        return playerPointElement.getText();
    }
    public String getTopPlayerName(){
        WebElement topPlayerElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(firstPlayer));
        return topPlayerElement.getText();
    }
}
