package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageObjects.HomePageElements;
import utils.FetchElements;

import java.util.List;

public class HomePageEvents {

    public void searchProduct(String product) {
        FetchElements fetch = new FetchElements();
        fetch.getElement("ID", HomePageElements.searchBox).sendKeys(product);
        fetch.getElement("XPATH", HomePageElements.searchSubmit).click();
    }

    public void searchProductWithAutosugtn(String product, String suggestionname) {
        FetchElements fetch = new FetchElements();
        fetch.getElement("ID", HomePageElements.searchBox).sendKeys(product);
        WebElement autosuggestion = fetch.getElement("CSS", HomePageElements.autosuggestion);
        List<WebElement> suggestionsList = autosuggestion.findElements(By.tagName("li"));
        String getTextsuggestion = suggestionsList.get(1).getText();
        //fetch.explictwait("CSS", HomePageElements.autosuggestion);
        fetch.implcitwait("CSS", HomePageElements.autosuggestion);
        suggestionsList.get(1).click();

        Assert.assertEquals(getTextsuggestion, suggestionname);
    }
}
