import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageEvents.*;
import utils.BaseTest;

public class SmokeTests extends BaseTest {

    @Test(enabled = false)
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
    @Test(enabled = true)
    public void autosuggestionSearch(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProductWithAutosugtn("mango","mango women in Women's Clothing");
        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.sortinresults("Newest");
       productArray.verifySearchResults("mango women");


    }

    @Test(enabled = false)
    public void PDPQuantityEditor(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct("0600086722740");
        PDPEvents pdp = new PDPEvents();
        pdp.increaseQuantity();
        pdp.decreaseQuantity();
    }

    @Test(enabled = false)
    public void FooterLinks(){
        FooterEvents footer = new FooterEvents();
        footer.clickOnHelpAndFAQ();
        footer.clickOnAffirm();
    }

}
