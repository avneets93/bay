package pageEvents;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.HomePageElements;
import pageObjects.OrdersAndReturnsElements;
import utils.FetchElements;
import utils.TestData;
import utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageEvents {
    TestData testData;
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
        String locatorL1 = "//span[contains(text(),\""+product+"\")]";
        utilities.explictwait("XPATH", locatorL1, 20);
        utilities.mouseActions(fetch.getElement("XPATH", locatorL1));
    }
    public void searchProductWithCategoryL3(String product) {
        fetch = new FetchElements();
        utilities = new Utilities();
        String locatorL1 = "//span[contains(text(),\""+product+"\")]";
        utilities.explictwait("XPATH", locatorL1, 20);
        utilities.mouseActions(fetch.getElement("XPATH", locatorL1));
        fetch.getElement("XPATH", locatorL1).click();
    }
    public void findallL1Categories() {
        testData = new TestData();
        utilities = new Utilities();
        fetch = new FetchElements();
        List<WebElement> allL1Categories = fetch.getListOfElements("CSS",HomePageElements.listCategoryL1);
       List<String> linkText = new ArrayList<>();
        for (WebElement ele :allL1Categories ){
            linkText.add(ele.getText());
        }
//try {
//    for (int i = 0; i <= linkText.size(); i++) {
//        String s = linkText.get(i);
//        System.out.println(s);
//
//    }
//} catch (Exception e){
//    System.out.println("exception");
//}
        boolean listsMatch = utilities.compareLists(linkText, testData.categories);
//        boolean listsMatch = false;
//        try {
//            listsMatch = compareLists(linkText, testData.getCategories());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        Assert.assertTrue(listsMatch);
        //System.out.println(listsMatch);
    }

    }



