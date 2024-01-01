package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEvent extends BasePage {
    private final String PICK_DAY_EVENT = "//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/containerColunasHorarios\"]/android.widget.RelativeLayout[5]";
    private final String NEW_EVENT = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"New event\"]";
    private final String EVENT_NAME = "com.claudivan.taskagenda:id/etTitulo";
    private final String EVENT_DESCRIPTION = "com.claudivan.taskagenda:id/etDescricao";
    private final String EVENT_SAVE_BTN = "com.claudivan.taskagenda:id/item_salvar";
    private MobileElement pickDateEvent;
    private MobileElement evenName;
    private MobileElement eventDescription;
    private MobileElement newEvent;
    private final WebDriverWait wait;
    public AddEvent (AndroidDriver<MobileElement> driver){
        super(driver);
        this.pickDateEvent = driver.findElement(By.xpath(PICK_DAY_EVENT));
        wait = new WebDriverWait(driver, 5);
        pickDateForEvent();
    }
    public void pickDateForEvent(){
        pickDateEvent.click();
    }
    public void addNewEvent(String name, String description){
        this.newEvent= (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NEW_EVENT)));
        newEvent.click();
        this.evenName = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(EVENT_NAME)));
        evenName.sendKeys(name);
        this.eventDescription = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(EVENT_DESCRIPTION)));
        eventDescription.sendKeys(description);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(EVENT_SAVE_BTN))).click();
    }
    public boolean validateEvent(String desiredText) {
        MobileElement pickDayEvent = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PICK_DAY_EVENT)));
        By eventTagLocator = By.xpath("//android.widget.TextView[@text='" + desiredText + "']");
        MobileElement eventElement = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(eventTagLocator));
        return eventElement.isDisplayed();
    }

}
