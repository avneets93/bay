import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.ProductArrayEvents;
import utils.BaseTest;

public class SmokeTests extends BaseTest {

    @Test
    public void testSearchBox(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct("towel");

        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResults("towel");
    }
}
