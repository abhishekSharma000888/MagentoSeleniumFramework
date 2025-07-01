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

    public void addProductToTheCartAndProceedToCheckout() {
        // Click on the first product
        WebElement selectProduct = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a"));
        selectProduct.click();

        // Optional: Fetch the product title (if you want to verify later)
        String actualTitle = driver.findElement(By.xpath("//*[@itemprop='name']")).getText();
        System.out.println("Selected Product: " + actualTitle);

        // Select color
        WebElement selectColor = driver.findElement(By.xpath("//*[@id='option-label-color-93-item-53']"));
        selectColor.click();

        // Select size
        WebElement selectSize = driver.findElement(By.xpath("//*[@id='option-label-size-143-item-168']"));
        selectSize.click();

        // Click on 'Add to Cart' button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add to Cart']")));
        addToCartButton.click();

        // Open cart by clicking cart quantity icon
        WebElement cartQtyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='counter qty']")));
        cartQtyButton.click();

        // Click 'Proceed to Checkout' button
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top-cart-btn-checkout']")));
        proceedToCheckoutButton.click();
    }

    public String validateTheUrlOftheCart(){

        //validate the url of the cart

        String actualUrl = driver.getCurrentUrl();

        return actualUrl;
    }


}
