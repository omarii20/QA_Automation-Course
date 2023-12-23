import org.example.logic.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTest {
    private static WebDriver driver;
    private static Login loginPage;

    @BeforeEach
    public void setUp() {
        loginPage = new Login(driver);
        driver.get("www.saucedemo.com");
    }

    @Test
    public void testLogin() {
        loginPage.insertToLogin("standard_user", "secret_sauce");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            loginPage.close();
        }
    }
}
