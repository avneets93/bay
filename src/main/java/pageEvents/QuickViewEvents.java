package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.ProductArrayElements;
import pageObjects.QuickViewElements;
import utils.BaseTest;
import utils.FetchElements;

import static utils.BaseTest.driver;

public class QuickViewEvents {

    public void quickViewAddToBag(){

        FetchElements fetch = new FetchElements();
        fetch.getElement("ID","qv-add-to-cart-btn").click();

    }
}
