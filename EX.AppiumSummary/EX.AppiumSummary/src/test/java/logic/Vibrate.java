package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Objects;

public class Vibrate extends BasePage {
    public final String ALARM_AND_NOTIFICATION="//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/itemNotificacoes\"]";
    public MobileElement alarmAndNotification;
    public final String VIBRATE="//android.widget.Switch[@resource-id=\"com.claudivan.taskagenda:id/swVibracaoAlarmeEvento\"]";
    private MobileElement vibrate;
    private WebDriverWait wait;

    public Vibrate (AndroidDriver<MobileElement> driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
    }
    public void CheckVibrate(){
        this.alarmAndNotification=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALARM_AND_NOTIFICATION)));
        alarmAndNotification.click();
        this.vibrate=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(VIBRATE)));
    }
    public String VibrateIsChecked(){
        String checked = vibrate.getAttribute("checked");
        if(!(Objects.equals(checked, "true"))){
            vibrate.click();
        }
        return checked;
    }
}
