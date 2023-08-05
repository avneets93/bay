package pageObjects;

public interface OrdersAndReturnsElements {

    String headerText = "h2.track-order-header.signIn-text";
    String orderNumber = "trackorder-form-number";
    String postalCode = "trackorder-form-zip";
    String submit = "//button[@name=\"submit\"]";
    String orderStatusHeader = ".order-status-head.card-header-custom.text-center";
    String actualOrderNumber = ".order-number.order-number-label";
    String orderStatus = "span.order-status";
}
