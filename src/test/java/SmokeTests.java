import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.ProductArrayEvents;
import pageEvents.QuickViewEvents;
import utils.BaseTest;

public class SmokeTests extends BaseTest {

    @Test
    public void testSearchBox(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct("towel");

        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResults("towel");
    }

    @Test(enabled = false)
    public void addToCartFromQuickView(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct("towel");

        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResults("towel");
        //scroll into view
        productArray.hoverOverProduct(1);
        productArray.clickOnQuickView(1);

        QuickViewEvents quickView = new QuickViewEvents();
        quickView.quickViewAddToBag();

        productArray.verifyCartTotal(1);
    }

}
