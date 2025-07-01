package tests.homepage.homePageNegativeTests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class HomePageNegativeTests extends BaseTest {

    @Description("Ensure that submitting an empty search does not break the system.")
    @Test
    public void emptyProductSearch(){

        HomePage homePage = new HomePage(driver);

        homePage.emptyProductSearch();

        String expectedCurrentUrl = "https://magento.softwaretestingboard.com/";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedCurrentUrl,"The URLs got mismathec!");

    }

    @Description("Validate that the system handles special character searches gracefully.")
    @Test
    public void validateSpecialCharactersInSearch() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.searchProduct("@#$%^&*()_+");

        String expectedErrorMessage = "Your search returned no results.";
        String actualErrorMessage = productPage.validateErrorMessage();

        Assert.assertEquals(actualErrorMessage.trim(), expectedErrorMessage, "Error message does not match!");
    }

}
