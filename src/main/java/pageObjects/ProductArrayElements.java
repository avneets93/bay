package pageObjects;

public interface ProductArrayElements {

    String searchResult = "//*[@id=\"algolia-stats-placeholder\"]/descendant::span[2]";
    String productTile = "//a[@class='thumb-link']";
    String quickView = "Quickview";
    String cartCount = "//span[@class = \"minicart-quantity tabbedExperience-minicart-quantity\"]";
}
