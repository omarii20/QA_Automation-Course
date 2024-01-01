package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenSetting extends BasePage {
//    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    private final String SIDE_MENU =  "com.claudivan.taskagenda:id/hamburguer";
    private final String SETTINBG_BTN = "com.claudivan.taskagenda:id/tvAjustes";
    private final String GET_TITLE= "//android.widget.TextView[@text=\"Settings\"]";
    MobileElement menuSideBtn;
    MobileElement settingsButton;
    MobileElement pageTitle;
    public OpenSetting(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.menuSideBtn = super.driver.findElement(By.id(SIDE_MENU));
        this.wait = new WebDriverWait(super.driver, 5);
    }
    public void openSetting(){
        menuSideBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SETTINBG_BTN))).click();
    }
    public String getTitle(){
        this.pageTitle = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GET_TITLE)));
        return pageTitle.getAttribute("text");
    }
}
