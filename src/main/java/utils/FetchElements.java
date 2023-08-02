package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.BaseTest.driver;

public class FetchElements {
    public WebElement getElement(String identifierType, String identifier){
        switch (identifierType){
            case "ID":
                return driver.findElement(By.id(identifier));
            case "CSS":
                return driver.findElement(By.cssSelector(identifier));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifier));
            case "XPATH":
                return driver.findElement(By.xpath(identifier));
            case "LINKTEXT":
                return driver.findElement(By.linkText(identifier));
            default:
                return null;
        }
    }
public By identifierType(String identifierType, String identifier) {

    switch (identifierType) {
        case "ID":
            return (By.id(identifier));
        case "CSS":
            return (By.cssSelector(identifier));
        case "TAGNAME":
            return (By.tagName(identifier));
        case "XPATH":
            return (By.xpath(identifier));
        case "LINKTEXT":
            return (By.linkText(identifier));
        default:
            return null;

    }
}
public WebElement explictwait(String identifierType, String identifier){
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(identifierType(identifierType,identifier)));
    return null;
}
    public WebElement implcitwait(String identifierType, String identifier){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return null;
    }


    public List<WebElement> getListOfElements(String identifierType, String identifier){
        switch (identifierType){
            case "ID":
                return driver.findElements(By.id(identifier));
            case "CSS":
                return driver.findElements(By.cssSelector(identifier));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifier));
            case "XPATH":
                return driver.findElements(By.xpath(identifier));
            case "LINKTEXT":
                return driver.findElements(By.linkText(identifier));
            default:
                return null;
        }
    }
}
