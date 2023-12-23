import org.example.logic.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class ShopCartTest {
    private static WebDriver driver;
    private static ShoppingCart shoppingCartPage;

    @BeforeEach
    public void setUp() {
        shoppingCartPage = new ShoppingCart(driver);
        driver.get("https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testIsProductAddedToCart() {
        boolean productAddedToCart = shoppingCartPage.isProductAddedToCart();
        Assert.assertTrue(productAddedToCart);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            shoppingCartPage.close();
        }
    }
}
