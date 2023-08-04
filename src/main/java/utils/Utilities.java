package utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseTest.driver;

public class Utilities {

    FetchElements fetch = new FetchElements();
    public void explictwait(String identifierType, String identifier, int time){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.identifierTypeBy(identifierType,identifier)));
    }

}