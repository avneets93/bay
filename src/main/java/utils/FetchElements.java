package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FetchElements {
    public WebElement getElement(String identifierType, String identifier){
        switch (identifierType){
            case "ID":
                return BaseTest.driver.findElement(By.id(identifier));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifier));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.tagName(identifier));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifier));
            case "LINKTEXT":
                return BaseTest.driver.findElement(By.linkText(identifier));
            default:
                return null;
        }
    }
    public List<WebElement> getListOfElements(String identifierType, String identifier){
        switch (identifierType){
            case "ID":
                return BaseTest.driver.findElements(By.id(identifier));
            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifier));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.tagName(identifier));
            case "XPATH":
                return BaseTest.driver.findElements(By.xpath(identifier));
            case "LINKTEXT":
                return BaseTest.driver.findElements(By.linkText(identifier));
            default:
                return null;
        }
    }
}
