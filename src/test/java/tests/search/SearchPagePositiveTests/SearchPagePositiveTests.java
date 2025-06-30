package tests.search.SearchPagePositiveTests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

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
}
