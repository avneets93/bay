package pageObjects;

public interface HomePageElements {

    String searchBox = "autocomplete-0-input";
    String searchSubmit = "//*[@id=\"autocomplete-0-label\"]/button";
    String suggestionList = "#autocomplete-0-0-list li a";
    String ordersAndReturns = "//*[@id=\"header-container\"]/descendant::span[contains(text(),\"Orders & Returns\")]/parent::a";
    String homecategoryL1 = "nav > div > ul > li:nth-child(6)";
    String homecategoryL3 = "a[id='2534374302032419'] span";
    String listCategoryL1 = ".nav-item.dropdown";
    String savingsPopUp = "bx-close-inside-2131232";
}
