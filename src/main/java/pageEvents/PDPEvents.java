package pageEvents;

import org.testng.Assert;
import pageObjects.PDPObjects;
import utils.FetchElements;

public class PDPEvents {

    public void increaseQuantity() {
        FetchElements fetch = new FetchElements();
        fetch.getElement("XPATH", PDPObjects.increaseQuantity).click();
        String quantity = fetch.getElement("XPATH",PDPObjects.quantity).getAttribute("value");
        Assert.assertEquals(quantity,"2");
    }

    public void decreaseQuantity() {
        FetchElements fetch = new FetchElements();
        fetch.getElement("XPATH", PDPObjects.decreaseQuantity).click();
        String quantity = fetch.getElement("XPATH",PDPObjects.quantity).getAttribute("value");
        Assert.assertEquals(quantity,"1");
    }

}
