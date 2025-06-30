package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        getSearchBox().sendKeys(productName);
        getSearchBox().submit();
    }
}
