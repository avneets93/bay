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

    @Test
    public void addToCartFromQuickView(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct("towel");

        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResults("towel");
        productArray.hoverOverProduct(1);
        productArray.clickOnQuickView();

        QuickViewEvents quickView = new QuickViewEvents();
        quickView.quickViewAddToBag();

        productArray.verifyCartTotal(1);
    }

}
