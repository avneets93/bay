package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface ProductArrayElements {

    String searchResult = "//*[@id=\"algolia-stats-placeholder\"]/descendant::span[2]";
    String productTile = "//a[@class='thumb-link']";
    String quickView = "//a[@class='quickview hidden-sm-down text-center']";
    String cartCount = "//span[@class = \"minicart-quantity tabbedExperience-minicart-quantity\"]";
    String sortDropdown = "div[id=\"algolia-sort-by-placeholder\"] select";
    String selectedsortOption = "select option[selected]";
    String closeAddToBag = ".close.fa-pull-right";
    String searchResultwithCategory = "//div[@id='algolia-stats-placeholder']//h1[contains(text(),searchQuery)]";
}
