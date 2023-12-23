//package logic;
//
//import io.cucumber.java.After;
//import io.cucumber.java.BeforeAll;
//import infra.SetUp;
//import org.openqa.selenium.WebDriver;
//
//public class Hooks {
//    private static SetUp setUp;
//    private static WebDriver driver;
//
//    @BeforeAll
//    public static void beforeAll() {
//        setUp = new SetUp();
//        driver = setUp.getDriver();
//    }
//
//    @After
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//    public static WebDriver getDriver(){
//        return driver;
//    }
//}
