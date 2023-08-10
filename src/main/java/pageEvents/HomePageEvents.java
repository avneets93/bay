package pageEvents;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.HomePageElements;
import pageObjects.OrdersAndReturnsElements;
import utils.FetchElements;
import utils.Utilities;

import java.util.List;

public class HomePageEvents {
    FetchElements fetch;
    Utilities utilities;
    public void searchProduct(String product) {
        fetch = new FetchElements();
        fetch.getElement("ID", HomePageElements.searchBox).sendKeys(product);
        fetch.getElement("XPATH", HomePageElements.searchSubmit).click();
    }

    public void searchProductWithAutosugtn(String product, String suggestionname) {
        fetch = new FetchElements();
        fetch.getElement("ID", HomePageElements.searchBox).sendKeys(product);
        //WebElement autosuggestion = fetch.getElement("CSS", HomePageElements.autosuggestion);
        //List<WebElement> suggestionsList = autosuggestion.findElements(By.tagName("li"));
        List<WebElement> suggestionsList = fetch.getListOfElements("CSS",HomePageElements.suggestionList);
        String getTextsuggestion = suggestionsList.get(1).getText();
        suggestionsList.get(1).click();
        Assert.assertEquals(getTextsuggestion, suggestionname);
    }
    public void clickOrdersAndReturns(){
        fetch = new FetchElements();
        fetch.getElement("XPATH",HomePageElements.ordersAndReturns).click();
        String header = fetch.getElement("CSS",OrdersAndReturnsElements.headerText).getText();
        Assert.assertEquals(header,"Check Order Status");
    }

    public void searchProductWithCategoryL1(String product) {
        fetch = new FetchElements();
        utilities = new Utilities();
        utilities.explictwait("CSS", HomePageElements.homecategoryL1, 20);
        utilities.mouseActions(fetch.getElement("CSS", HomePageElements.homecategoryL1));
    }
    public void searchProductWithCategoryL3(String product) {
        fetch = new FetchElements();
        utilities = new Utilities();
        utilities.explictwait("CSS", HomePageElements.homecategoryL3, 20);
        utilities.mouseActions(fetch.getElement("CSS", HomePageElements.homecategoryL3));
        fetch.getElement("CSS", HomePageElements.homecategoryL3).click();
    }
}



