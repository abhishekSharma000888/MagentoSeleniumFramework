package tests.exceptions;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.ExceptionUtility;

public class ExceptionHandlingTest extends BaseTest {

    @Test(description = "Test Selenium Exception Handling with safe click")
    public void validateExceptionHandling() {

        driver.get("https://magento.softwaretestingboard.com/");

        ExceptionUtility exceptionUtility = new ExceptionUtility(driver);

        // Safe click: existing element
        exceptionUtility.safeClick(By.xpath("//*[text()='Men']"));

        // Safe click: non-existing element to trigger exception
        exceptionUtility.safeClick(By.xpath("//a[@id='non-existent-element']"));
    }
}
