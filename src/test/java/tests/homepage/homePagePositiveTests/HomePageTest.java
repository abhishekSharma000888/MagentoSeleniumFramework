package tests.homepage.homePagePositiveTests;

import base.BaseTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Description("Validate the men menu is being dislplayed!")
    @Test
    public void validateMenMenuIsDisplayed(){

        HomePage homePage = new HomePage(driver);

        boolean isDisplayed = homePage.getMenMenu().isDisplayed();

        Assert.assertTrue(isDisplayed, "Men menu is not displayed.");

    }

    @Description("Validate that what's menu is being displayed!")
    @Test
    public void validateWhatsMenuIsDisplayed() {

        HomePage homePage = new HomePage(driver);
        boolean isDisplayed = homePage.getWhatsNewMenu().isDisplayed();
        Assert.assertTrue(isDisplayed, "What's New menu is not displayed.");

    }
}
