import org.IntroToSeleniume.infra.DriverUtils;
import org.IntroToSeleniume.logic.WordTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main{
    @Test
    public void testWords(){
        WebDriver driver = DriverUtils.initDriver();
        boolean result = WordTest.testCheckWord(driver, "Aardvark", "bear");
        driver.close();
        assertTrue(result, "There is word ");
    }
}