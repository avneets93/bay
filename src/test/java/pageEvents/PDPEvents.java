package pageEvents;

import org.testng.Assert;
import pageObjects.PDPObjects;
import utils.FetchElements;

public class PDPEvents {

    public void increaseQuantity() {
        FetchElements fetch = new FetchElements();
        fetch.getElement("XPATH", PDPObjects.increaseQuantity).click();

    }

    public void decreaseQuantity() {
    }
}
