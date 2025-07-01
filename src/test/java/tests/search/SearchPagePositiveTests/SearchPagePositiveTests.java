package tests.search.SearchPagePositiveTests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.JavascriptUtil;

import java.time.Duration;

public class SearchPagePositiveTests extends BaseTest {

    @Description("Search a product and validate first product is displayed using JS selector")
    @Test
    public void validProductSearch(){

        HomePage homePage = new HomePage(driver);

        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchProduct("Tank");

        boolean isProductDisplayed = searchPage.getFirstProductUsingJS().isDisplayed();
        Assert.assertTrue(isProductDisplayed,"First product is not displayed.");
    }

    @Description("Search a product and validate multiple products are displayed using CSS selector")
    @Test
    public void validateMultipleProductsDisplayed(){

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);


        searchPage.searchProduct("Tank");
        int productCount = searchPage.getAllProductsUsingCSS().size();

        Assert.assertTrue(productCount>1, "Multiple products are not being displayed.");
    }

    @Description("Search a product and click on the first product using JavaScript Executor")
    @Test
    public void clickProductUsingJavaScriptExecutor() {

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        JavascriptUtil jsUtil = new JavascriptUtil(driver);

        searchPage.searchProduct("Tank");

        WebElement firstProductLink = searchPage.getAllProductsUsingCSS().get(0);

        jsUtil.clickElementByJS(firstProductLink);

        // Validate that the Product Page is opened
    }

    @Description("After clicking on the first product, the product detail page should open, " +
            "and the product title on the detail page should match the name of the product selected.")
    @Test
    public void validateSearchResultsCountIsGreaterThanZero() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Correct: Use HomePage's searchProduct because it correctly submits
        homePage.searchProduct("Tank");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("search"));

        String expectedPageTitle = "Search results for: 'Tank'";
        Assert.assertEquals(searchPage.pageTitle().getText(), expectedPageTitle, "The title didn't matched!");
    }

    @Description("Add first product to the cart and verify the cart URL.")
    @Test
    public void validateAddingFirstProductToTheCart() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 1: Search for the product
        homePage.searchProduct("Tank");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("search"));

        // Step 2: Add the product to the cart and proceed to checkout
        cartPage.addProductToTheCartAndProceedToCheckout();

        // Step 3: Validate the cart/checkout URL
        String actualCartUrl = cartPage.validateTheUrlOftheCart();

        // Example expected URL - Adjust this as per your app
        String expectedCartUrl = "https://magento.softwaretestingboard.com/checkout/#shipping";

        Assert.assertEquals(actualCartUrl, expectedCartUrl, "Cart URL is not as expected.");
    }

    /*
    Css selector = tagName[attribute=value]
     */


}
