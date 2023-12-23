package org.IntroToSeleniume.infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserLocation {
    private final WebDriver driver;
    public BrowserLocation(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get("https://www.wikipedia.org");
    }
    public void getElements(String searchInput){
        driver.findElement(By.id("searchInput")).sendKeys(searchInput);
        driver.findElement(By.xpath("//form[@id='search-form']//button[@type='submit']")).click();
    }
    public boolean searchingWord(String wordToCount){
        String pageText = driver.findElement(By.tagName("body")).getText();
        int result = countSpecificWord.countWord(pageText, wordToCount);
        return result > 0;
    }
}
