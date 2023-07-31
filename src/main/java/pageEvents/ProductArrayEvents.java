package pageEvents;

import org.testng.Assert;
import pageObjects.ProductArrayElements;
import utils.FetchElements;

public class ProductArrayEvents {

    public void verifySearchResults(String searchQuery){
        FetchElements fetch = new FetchElements();
        String searchResult = fetch.getElement("XPATH", ProductArrayElements.searchResult).getText();
        String cleanSearchResult = searchResult.substring(2, searchResult.length() - 2);
        Assert.assertEquals(cleanSearchResult, searchQuery);
    }
}
