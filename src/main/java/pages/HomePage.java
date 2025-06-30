package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Example: Click on "Men" menu
    public WebElement getMenMenu() {
        return driver.findElement(By.xpath("//span[text()='Men']"));
    }

    // Example: Click on "What's New" menu
    public WebElement getWhatsNewMenu() {
        return driver.findElement(By.xpath("//span[text()=\"What's New\"]"));
    }

    // Search product
    public WebElement getSearchBox() {
        return driver.findElement(By.id("search"));
    }

    public void searchProduct(String productName) {
        getSearchBox().sendKeys(productName);
        getSearchBox().submit();
    }
}
