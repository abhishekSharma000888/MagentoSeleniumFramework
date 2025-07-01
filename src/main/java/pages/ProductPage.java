package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String validateErrorMessage() {
        WebDriverWait messageWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement errorMessage = messageWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Your search returned no results.')]")));

        Assert.assertTrue(errorMessage.isDisplayed(), "The error message is not displayed!");

        return errorMessage.getText();
    }



}
