package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlarmsNotification extends BasePage {
    private final String ALARMS_NOTIFICATION_BTN = "//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/itemNotificacoes\"]/android.widget.RelativeLayout";
    private final String DURATION = "com.claudivan.taskagenda:id/itemDuracaoAlarmeEvento";
    private final String PICK_NEW_DURATION = "//android.widget.TextView[@resource-id='android:id/text1' and @text='30 seconds']";
    private final String GET_DURATION_TXT = "com.claudivan.taskagenda:id/tvValorDuracaoAlarmeEvento";
    private final WebDriverWait wait;
    public AlarmsNotification(AndroidDriver<MobileElement> driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
    }
    public void get_alarms_notification(){
        MobileElement alarmsNotificationBtn = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALARMS_NOTIFICATION_BTN)));
        alarmsNotificationBtn.click();
    }
    public void changeDuration(){
        MobileElement duration = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DURATION)));
        duration.click();
        MobileElement newDuration = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PICK_NEW_DURATION)));
        newDuration.click();
    }

    public String validateDurationTime (){
        MobileElement durationTime = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(GET_DURATION_TXT)));
        return durationTime.getAttribute("text");
    }

}
