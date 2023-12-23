package org.IntroToSeleniume.logic;

import org.IntroToSeleniume.infra.BrowserLocation;
import org.openqa.selenium.WebDriver;

public class WordTest {
    public static boolean testCheckWord(WebDriver driver, String inputText, String myWord){
        BrowserLocation b1 = new BrowserLocation(driver);
        b1.open();
        b1.getElements(inputText);
        return b1.searchingWord(myWord);
    }
}
