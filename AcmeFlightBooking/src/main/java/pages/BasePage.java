package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GenericUtils;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,20);
    }

    //Wait Wrapper Method
    public WebElement waitToBeClickable(By byLocator) {
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(byLocator));
        return webElement;
    }

    //Wait Wrapper Method
    public WebElement waitToBeVisible(By byLocator) {
        //visibilityOfAllElementsLocatedBy
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        return webElement;
    }

    //Click Method
    public void waitAndClickElement (By elementBy, long timeout) throws InterruptedException {
        WebElement webElement = waitToBeClickable(elementBy);
        webElement.click();

        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.sleep(timeout);
    }
    //Click Method
    public void clickElement (By elementBy) throws InterruptedException {
        WebElement webElement = waitToBeClickable(elementBy);
        webElement.click();

        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.sleep(1L);
    }

    //Write Text
    public void setText (By elementBy, String text) {
        WebElement webElement = waitToBeVisible(elementBy);
        //driver.findElement(elementBy).sendKeys(text);
        webElement.sendKeys(text);
    }

    //Write setDropDownTypeText
    public void selectDropDownText (By elementBy, By dropDownElementBy) throws InterruptedException {
        TimeUnit timeUnit = TimeUnit.SECONDS;

        //Click the element to expose the options
        // and then click the dropdown option
        clickElement (elementBy);
        clickElement (dropDownElementBy);
        timeUnit.sleep(1L);
    }

    //Write setDropDownTypeText
    public void setDropDownTypeText (By elementBy, By dropDownElementBy, String text) throws InterruptedException {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        WebElement webElement = waitToBeVisible(elementBy);
        webElement.click();

        driver.findElement(dropDownElementBy).sendKeys(text);
        timeUnit.sleep(1L);

        driver.findElement(dropDownElementBy).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(dropDownElementBy).sendKeys(Keys.ENTER);
    }

    //Read Text
    public String getText (By elementBy) {
        WebElement webElement = waitToBeVisible(elementBy);
        //return driver.findElement(elementBy).getText();
        return webElement.getText();
    }

    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        String actualText = getText(elementBy);
        Assert.assertEquals(actualText, expectedText);
    }

    //Assert
    public void assertWildcard (By elementBy, String expectedText) {
        String actualText = getText(elementBy);
        Assert.assertTrue(actualText.contains(expectedText));

    }
}
