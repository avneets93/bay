package pageEvents;

import pageObjects.HomePageElements;
import utils.FetchElements;

public class HomePageEvents {

    public void searchProduct(String product){
        FetchElements fetch = new FetchElements();
        fetch.getElement("ID", HomePageElements.searchBox).sendKeys(product);
        fetch.getElement("XPATH", HomePageElements.searchSubmit).click();
    }

}
