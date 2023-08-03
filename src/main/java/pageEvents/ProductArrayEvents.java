package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.ProductArrayElements;
import utils.BaseTest;
import utils.FetchElements;

public class ProductArrayEvents {

    public void verifySearchResults(String searchQuery){
        FetchElements fetch = new FetchElements();
        String searchResult = fetch.getElement("XPATH", ProductArrayElements.searchResult).getText();
        String cleanSearchResult = searchResult.substring(2, searchResult.length() - 2);
        Assert.assertEquals(cleanSearchResult, searchQuery);
    }

    public void verifyCartTotal(int expectedTotalInt){
        FetchElements fetch = new FetchElements();
        String actualTotal = fetch.getElement("XPATH",ProductArrayElements.cartCount).getText();

        String expectedTotal = String.valueOf(expectedTotalInt);
        Assert.assertEquals(actualTotal, expectedTotal);
    }

    public void hoverOverProduct(int product){   // here we can specify which product to hover from the product list
        FetchElements fetch = new FetchElements();
        String productToHover = "(" + ProductArrayElements.quickView +")["+product+"]";
        WebElement hoverElement = fetch.getElement("XPATH", productToHover);
        Actions actions = new Actions(BaseTest.driver);
        actions.moveToElement(hoverElement).perform();
    }

    public void clickOnQuickView(int product){
        FetchElements fetch = new FetchElements();
        String quickViewID = "(" + ProductArrayElements.quickView +")["+product+"]";
        fetch.getElement("XPATH",quickViewID).click();

    }
    public void sortinresults(String sort){
        FetchElements fetch = new FetchElements();
        WebElement dropdown =fetch.getElement("CSS",ProductArrayElements.sortDropdown);
        Select select = new Select(dropdown);
        select.selectByIndex(2);
         dropdown =fetch.getElement("CSS",ProductArrayElements.sortDropdown);
        String selectedOptionText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionText,sort);


    }
}
