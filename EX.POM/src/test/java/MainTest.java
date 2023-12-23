import org.example.logic.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class MainTest {
    private WebDriver driver;
    private Main mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new Main(driver);
        driver.get("https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testAreItemsLoaded() {
        boolean itemsLoaded = mainPage.areItemsLoaded();
        Assert.assertTrue(itemsLoaded);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            mainPage.close();
        }
    }
}
