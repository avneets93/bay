package pageEvents;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.HomePageElements;
import pageObjects.OrdersAndReturnsElements;
import utils.FetchElements;
import utils.Utilities;

import java.util.ArrayList;
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
    public void findallL1Categories(){
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("WOMEN");
        categories.add("MEN");
        categories.add("KIDS & BABY");
        categories.add("SHOES");
        categories.add("BEAUTY & WELLNESS");
        categories.add("HOME LIVING");
        categories.add("MORE");
        categories.add("BRANDS");
        categories.add("SALE");
        categories.add("ZELLERS");

        fetch = new FetchElements();
        List<WebElement> allL1Categories = fetch.getListOfElements("CSS",HomePageElements.listCategoryL1);
        ArrayList<String> linkText = new ArrayList<String>();
        for (WebElement ele :allL1Categories ){
            linkText.add(ele.getText());
        }
try {
    for (int i = 0; i <= linkText.size(); i++) {
        String s = linkText.get(i);
        System.out.println(s);

    }
} catch (Exception e){
    System.out.println("exception");
}
        boolean listsMatch = compareLists(linkText, categories);


        if (listsMatch) {
            System.out.println("Lists match.");
        } else {
            System.out.println("Lists do not match.");
        }
        Assert.assertEquals(true,listsMatch);
        //System.out.println(listsMatch);
    }

    public static <T> boolean compareLists(ArrayList<String> categories, ArrayList<String> linkText) {
        if (categories.size() != linkText.size()) {
            return false;
        }

        for (int i = 0; i < categories.size(); i++) {
            if (!categories.get(i).equals(linkText.get(i))) {
                return false;
            }
        }

        return true;
    }

    }



