package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CustomerSupport;
import pageObjects.FooterElements;
import pageObjects.Services;
import utils.BaseTest;
import utils.FetchElements;

import java.util.Set;

public class FooterEvents {
    FetchElements fetch = new FetchElements();
    public void clickOnHelpAndFAQ(){
        String currentWindowHandle = BaseTest.driver.getWindowHandle();
        fetch.getElement("LINKTEXT", FooterElements.helpAndFAQ).click();
        Set<String> allWindowHandles =  BaseTest.driver.getWindowHandles();
        for(String windowHandle : allWindowHandles){
            if(!windowHandle.equals(currentWindowHandle)){
                BaseTest.driver.switchTo().window(windowHandle);
            }
        }
        Assert.assertEquals(fetch.getElement("XPATH", CustomerSupport.pageHeader).getText(),
                "How Can We Help?");
        BaseTest.driver.close();
        BaseTest.driver.switchTo().window(currentWindowHandle);
    }
    public void clickOnAffirm(){
        fetch.getElement("LINKTEXT",FooterElements.affirm).click();
        Assert.assertEquals(fetch.getElement("XPATH", Services.affirmPageHeader).getText(),
                "Why choose Affirm?");
    }
}
