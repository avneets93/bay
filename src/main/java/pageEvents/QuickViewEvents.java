package pageEvents;

import utils.FetchElements;

public class QuickViewEvents {

    public void quickViewAddToBag(){
        FetchElements fetch = new FetchElements();
        fetch.getElement("ID","qv-add-to-cart-btn").click();
    }
}
