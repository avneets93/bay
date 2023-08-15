import org.testng.annotations.Test;
import pageEvents.*;
import utils.BaseTest;
import utils.ExcelReader;
import utils.TestData;
import utils.Utilities;

import java.io.IOException;

public class SmokeTests extends BaseTest {

    TestData testData = new TestData();
    @Test
    public void testSearchBox() {
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
        //scroll into view
        productArray.clickOnQuickView(1);

        QuickViewEvents quickView = new QuickViewEvents();
        quickView.quickViewAddToBag();

        productArray.verifyCartTotal(1);
    }
    @Test
    public void autosuggestionSearch(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProductWithAutosugtn("mango","mango women in Women's Clothing");
        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.sortinresults("Newest");
        productArray.verifySearchResults("mango women");
    }
    @Test
    public void testSearchResultsWithCat(){
        Utilities utilities = new Utilities();
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProductWithCategoryL1("Home Living");
        homePage.searchProductWithCategoryL3("Cushions");
        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResultsWithCat("Cushions");
    }

    @Test
    public void PDPQuantityEditor(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct("0600086722740");
        PDPEvents pdp = new PDPEvents();
        pdp.increaseQuantity();
        pdp.decreaseQuantity();
    }

    @Test
    public void FooterLinks(){
        FooterEvents footer = new FooterEvents();
        footer.clickOnHelpAndFAQ();
        footer.clickOnAffirm();
    }
    @Test
    public void checkOrderStatus() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.clickOrdersAndReturns();
        OrdersAndReturnsEvents orders = new OrdersAndReturnsEvents();
        //orders.checkOrderStatus("1216464018","L6Y 0Z1");
        orders.checkOrderStatus(testData.getData("Order ID").get(0),testData.getData("Postal Code").get(0));

    }
    @Test
    public void checkAllL1Category() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.findAllL1Categories(testData.getCategories());
    }

}
