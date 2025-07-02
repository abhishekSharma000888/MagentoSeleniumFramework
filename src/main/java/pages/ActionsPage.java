package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsPage {

    WebDriver driver;

    public ActionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMenMenu() {
        return driver.findElement(By.xpath("//*[text()='Men']"));
    }

    public WebElement getTopsSubMenu() {
        return driver.findElement(By.xpath("//*[text()='Men']/following::span[text()='Tops'][1]"));
    }

    public WebElement getJacketsOption() {
        return driver.findElement(By.xpath("//*[text()='Men']/following::span[text()='Jackets'][1]"));
    }

    // Actions Method
    public void hoverOverMenAndSelectJackets() {
        Actions actions = new Actions(driver);

        actions.moveToElement(getMenMenu())
                .pause(1000)
                .moveToElement(getTopsSubMenu())
                .pause(1000)
                .moveToElement(getJacketsOption())
                .click()
                .build()
                .perform();
    }
}
