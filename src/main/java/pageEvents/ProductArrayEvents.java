package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public void verifyCartTotal(int expectedTotal){
        FetchElements fetch = new FetchElements();
        String actualTotalString = fetch.getElement("XPATH",ProductArrayElements.cartCount).getText();
        int actualTotal = Integer.parseInt(actualTotalString);
        Assert.assertEquals(actualTotal, expectedTotal);
    }

    public void hoverOverProduct(int product){   // here we can specify which product to hover from the product list
        FetchElements fetch = new FetchElements();
        String productToHover = "(" + ProductArrayElements.productTile +")["+product+"]";
        WebElement hoverElement = fetch.getElement("XPATH", productToHover);
        Actions actions = new Actions(BaseTest.driver);
        actions.moveToElement(hoverElement).perform();
    }

    public void clickOnQuickView(){
        FetchElements fetch = new FetchElements();
        fetch.getElement("LINKTEXT",ProductArrayElements.quickView).click();
    }
}
