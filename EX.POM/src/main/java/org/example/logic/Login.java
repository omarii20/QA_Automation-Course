package org.example.logic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage{
    private final By usernameElement = By.id("user-name");
    private final By passwordElement= By.id("password");
    private final By loginButton = By.id("login-button");

    public Login(WebDriver driver){
        super(driver);
    }
    private void fillUserName (String name){
        WebElement userNameElement = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(usernameElement));
        userNameElement.sendKeys(name);
    }
    private void fillUserPassword (String pass){
        WebElement userPassElement = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(passwordElement));
        userPassElement.sendKeys(pass);

    }
    private void clickBtn (){
        WebElement elementButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loginButton));
        elementButton.click();
    }
    public void insertToLogin(String userName, String password){
        this.fillUserName(userName);
        this.fillUserPassword(password);
        this.clickBtn();
    }

}

