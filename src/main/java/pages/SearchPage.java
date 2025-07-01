package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.cssSelector("input#search"));
    }

    public WebElement getFirstProductUsingJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return document.querySelector('.product-item-info a.product-item-link');");
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//button[@title='Add to Cart']"));
    }

    public WebElement getShoppingCartLink() {
        return driver.findElement(By.partialLinkText("Cart"));
    }

    public void searchProduct(String productName) {
        WebElement searchBox = getSearchBox();
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.submit(); // Correct submission
    }

    public List<WebElement> getAllProductsUsingCSS(){

        return driver.findElements(By.cssSelector("li.product-item a.product-item-link"));
    }

    public WebElement pageTitle() {
        WebDriverWait waitForElementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(8));
        return waitForElementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")));
    }


}
