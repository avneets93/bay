package pageEvents;

import org.reactivestreams.FlowAdapters;
import org.testng.Assert;
import pageObjects.OrdersAndReturnsElements;
import utils.FetchElements;

public class OrdersAndReturnsEvents {
    FetchElements fetch = new FetchElements();
    public void checkOrderStatus(String orderID, String postalCode){
        fetch.getElement("ID", OrdersAndReturnsElements.orderNumber).sendKeys(orderID);
        fetch.getElement("ID", OrdersAndReturnsElements.postalCode).sendKeys(postalCode);
        fetch.getElement("XPATH",OrdersAndReturnsElements.submit).click();
        String header = fetch.getElement("CSS",OrdersAndReturnsElements.orderStatusHeader).getText();
        Assert.assertEquals(header,"Order Status");
        String orderNumber = fetch.getElement("CSS",OrdersAndReturnsElements.actualOrderNumber).getText();
        Assert.assertEquals(orderNumber,"Order #"+orderID);
        String expectedOrderStatus = "Shipped";
        String actualOrderStatus = fetch.getElement("CSS",OrdersAndReturnsElements.orderStatus).getText();
        Assert.assertEquals(actualOrderStatus,expectedOrderStatus);
    }
}
