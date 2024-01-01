package test;

import infra.AppWrapper;
import logic.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class OpenAppTest {
    private AppWrapper appWrapper;
    @Before
    public void setUp() {
        appWrapper = new AppWrapper();
        appWrapper.getDriver();
    }

    @Test
    public void openApp() {
        System.out.println("Task Agenda App is ready!");
    }

    @Test
    public void openSideMenuAndOpenSetting(){
        OpenSetting openSetting = new OpenSetting(appWrapper.getDriver());
        openSetting.openSetting();
        Assert.assertEquals("Settings", openSetting.getTitle());
    }

    @Test
    public void EnableDarkMode(){
        DarkMode darkMode=new DarkMode(appWrapper.getDriver());
        darkMode.DarkMode();
        Assertions.assertEquals("Enabled" ,darkMode.DarkModeIsEnable());

    }
    @Test
    public void TestCalendar(){
        Calendar calendar = new Calendar(appWrapper.getDriver());
        calendar.ClickCalendar();
        Assertions.assertEquals(true,calendar.IsSelected());
    }

    @Test
    public void alaramsAndNotification(){
        AlarmsNotification alarmsNotification = new AlarmsNotification(appWrapper.getDriver());
        openSideMenuAndOpenSetting();
        alarmsNotification.get_alarms_notification();
        //change duration to 30 seconds
        alarmsNotification.changeDuration();
        String getDurationTime = alarmsNotification.validateDurationTime().trim();
        String expectedNumericPart = getDurationTime.replaceAll("[^0-9]", "");
        Assert.assertEquals( "30", expectedNumericPart);
    }

    @Test
    public void VibrateCheck(){
        Vibrate SettingsVibrate = new Vibrate(appWrapper.getDriver());
        openSideMenuAndOpenSetting();
        SettingsVibrate.CheckVibrate();
        Assertions.assertEquals("true",SettingsVibrate.VibrateIsChecked());
    }

    @Test
    public void addNewEvent(){
        AddEvent newEvent = new AddEvent(appWrapper.getDriver());
        String eventName = "Test Event";
        String eventDesc = "QA Automation course meeting";
        newEvent.addNewEvent(eventName, eventDesc);
        Assertions.assertTrue(newEvent.validateEvent(eventName));
    }

//    @After
//    public void tearDown() {
//        if (appWrapper.getDriver() != null) {
//            appWrapper.closeDriver();
//        }
//    }
}
