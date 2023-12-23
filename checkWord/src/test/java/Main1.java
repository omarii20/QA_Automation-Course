//import org.IntroToSeleniume.infra.countSpecificWord;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class Main1 {
//
//    private static WebDriver driver;
//
//    @BeforeAll
//    public static void setupWebDriver() {
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void testSearchAWord() {
//        searchAword("Aardvark", "bear");
//    }
//
//    public void searchAword(String searchInput, String theWord) {
//        // Arrange
//        setupWebDriver();
//
//        // Act
//        Searching(searchInput);
//
//        // Assert
//        int occurrences = countSpecifiWord(theWord);
//        assertTrue(occurrences > 0, "The word " + theWord + " appears at less one time.");
//    }
//
//    public void Searching(String inputText) {
//        driver.get("https://www.wikipedia.org");
//        WebElement searchBox = driver.findElement(By.id("searchInput"));
//        searchBox.sendKeys(inputText);
//        WebElement searchButton = driver.findElement(By.xpath("//form[@id='search-form']//button[@type='submit']"));
//        searchButton.click();
//    }
//
//    public int countSpecifiWord(String wordToCount) {
//        String pageText = driver.findElement(By.tagName("body")).getText();
//        return countSpecificWord.countWord(pageText, wordToCount);
//    }
//
//    @AfterEach
//    public void closeWebDriver() {
//        driver.close();
//    }
//
//}
