package tests.homepage.actionClasses;

import base.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActionsPage;

import java.time.Duration;

public class ActionsPageTests extends BaseTest {

    @Description("Hover over Men -> Tops -> Click Jackets and verify navigation.")
    @Test
    public void validateHoverAndClickJackets() {

        ActionsPage actionsPage = new ActionsPage(driver);

        actionsPage.hoverOverMenAndSelectJackets();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base']")));

        String expectedTitle = "Home Page";
        String actualTitle = pageTitle.getText();

        Assert.assertEquals(actualTitle.trim(), expectedTitle, "The Jackets page title does not match!");
    }

    @Description("Hover over Women -> Tops -> Click Jackets and verify navigation.")
    @Test
    public void validateHoverAndClickJacketsForWomen() {

        Actions actions = new Actions(driver);

        WebElement womenTab = driver.findElement(By.xpath("//*[text()='Women']"));

        WebElement topsTab = driver.findElement(By.cssSelector("a[id=ui-id-9]"));

        WebElement jacketButton = driver.findElement(By.cssSelector("a[id=ui-id-9]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base']")));

        actions.moveToElement(womenTab)
                .pause(1000)
                .moveToElement(topsTab)
                .pause(1000)
                .moveToElement(jacketButton)
                .pause(1000)
                .click()
                .build()
                .perform();

        String expectedTitle = "Home Page";
        String actualTitle = pageTitle.getText();

        Assert.assertEquals(actualTitle.trim(), expectedTitle, "The Jackets page title does not match!");
    }
}