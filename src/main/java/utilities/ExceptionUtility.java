package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExceptionUtility {

    WebDriver driver;

    public ExceptionUtility(WebDriver driver){
        this.driver = driver;
    }
    public WebElement safeFindElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Exception caught while finding element: " + e.getMessage());
            return null;
        }
    }

    public void safeClick(By locator) {
        try {
            WebElement element = safeFindElement(locator);
            if (element != null && element.isDisplayed()) {
                element.click();
            } else {
                System.out.println("Element not interactable or not found.");
            }
        } catch (Exception e) {
            System.out.println("Exception during clicking: " + e.getMessage());
        }
    }
}
