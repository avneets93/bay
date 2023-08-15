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
    public void testSearchBox() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct(testData.getData("Search String").get(1));
        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResults(testData.getData("Search String").get(1));
    }

    @Test
    public void addToCartFromQuickView() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct(testData.getData("Search String").get(1));

        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResults(testData.getData("Search String").get(1));
        //scroll into view
        productArray.clickOnQuickView(1);

        QuickViewEvents quickView = new QuickViewEvents();
        quickView.quickViewAddToBag();

        productArray.verifyCartTotal(1);
    }
    @Test
    public void autosuggestionSearch() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProductWithAutosugtn(testData.getData("Autosuggestion").get(1),testData.getData("Autosuggestion").get(2));
        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.sortinresults(testData.getData("Sort").get(1));
        productArray.verifySearchResults(testData.getData("Search String").get(2));
    }
    @Test
    public void testSearchResultsWithCat() throws IOException {
        Utilities utilities = new Utilities();
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProductWithCategoryL1(testData.getData("L1 category").get(1));
        homePage.searchProductWithCategoryL3(testData.getData("L3 Category").get(1));
        ProductArrayEvents productArray = new ProductArrayEvents();
        productArray.verifySearchResultsWithCat(testData.getData("L3 Category").get(1));
    }

    @Test
    public void PDPQuantityEditor() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchProduct(testData.getData("Product").get(1));
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
        orders.checkOrderStatus(testData.getData("Order ID").get(1),testData.getData("Postal Code").get(1));

    }
    @Test
    public void checkAllL1Category() throws IOException {
        HomePageEvents homePage = new HomePageEvents();
        homePage.findAllL1Categories(testData.getCategories());
    }

}
