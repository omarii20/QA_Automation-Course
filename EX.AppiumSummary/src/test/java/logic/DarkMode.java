package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DarkMode extends BasePage {
    private final String SIDE_MENU =  "com.claudivan.taskagenda:id/hamburguer";
    public final String COLOR_AND_EVENT_TYPE="com.claudivan.taskagenda:id/btCores";
    public final String DARK_MODE = "com.claudivan.taskagenda:id/itemTemaEscuro";
    public final String ENABLE_DARK_MODE = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Enabled\"]";
    public final String DARK_MODE_IS_ENABLE="//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/tvTemaEscuroValor\"]";
    public MobileElement darkModeIsEnable;
    public MobileElement darkMode;
    public MobileElement enableDarkMode;
    public MobileElement menuSideBtn;
    public MobileElement BtnColorAndEventType;
    private final WebDriverWait wait;
    public DarkMode(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.menuSideBtn = super.driver.findElement(By.id(SIDE_MENU));
        wait = new WebDriverWait(driver, 5);
    }
    public void ClickMenu(){
        menuSideBtn.click();
    }
    public void ClickColorAndEventType(){
        this.BtnColorAndEventType = super.driver.findElement(By.id(COLOR_AND_EVENT_TYPE));
        BtnColorAndEventType.click();
    }
    public void DarkMode(){
        ClickMenu();
        ClickColorAndEventType();
        this.darkMode= (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DARK_MODE)));
        darkMode.click();
        this.enableDarkMode= (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENABLE_DARK_MODE)));
        enableDarkMode.click();

    }
    public String DarkModeIsEnable(){
        darkModeIsEnable = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DARK_MODE_IS_ENABLE)));
        return darkModeIsEnable.getAttribute("text");
    }
}
