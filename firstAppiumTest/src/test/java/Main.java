import infra.SetUp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class Main {
    SetUp setUp;

    @Before
    public void setUp() {
        setUp = new SetUp();
    }

    @After
    public void tearDown() {
        if (setUp.getDriver() != null) {
            setUp.quitDriver();
        }
    }

    @Test
    public void testOpenSettings() {
        MobileElement settingsButton = setUp.getDriver().findElement(By.id("com.android.settings:id/homepage_app_bar_regular_phone_view"));
        settingsButton.click();
        MobileElement pageTitle = setUp.getDriver().findElement(By.id("com.android.settings:id/homepage_title"));
        Assert.assertEquals(pageTitle.getText(), "Settings", "Settings app is not open");
    }

    @Test
    public void testClickDisplay() {
        MobileElement displayButton = setUp.getDriver().findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.android.settings:id/text_frame'])[5]"));
        displayButton.click();
    }

    @Test
    public void testTurnOffAutoRotate() {
        MobileElement autoRotateSwitch = setUp.getDriver().findElement(By.xpath("//com.android.settings///android.widget.TextView[@resource-id='android:id/title' and @text='Auto-rotate screen']"));
        autoRotateSwitch.click();
    }

    @Test
    public void testValidateAutoRotateOff() {
        MobileElement autoRotateSwitch = setUp.getDriver().findElement(By.id("//android.widget.TextView[@resource-id='android:id/title' and @text='Auto-rotate screen']"));
        boolean isOff = autoRotateSwitch.getAttribute("checked").equals("false");
        Assert.assertTrue(isOff, "Auto rotate screen is off.");
    }
}
