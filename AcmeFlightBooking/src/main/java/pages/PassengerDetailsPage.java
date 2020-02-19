package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.util.concurrent.TimeUnit;

public class PassengerDetailsPage extends BasePage{

    //*********Constructor*********
    public PassengerDetailsPage(WebDriver driver) {
        super(driver);
    }

    By byAcceptButton = By.cssSelector("button[id='btn-accept']");
    By byAddAdditionalBag = By.cssSelector("span[class='ng-star-inserted'][msg-src-key='ALPI.text.Bags.AddLink']");
    By byContinueButton = By.cssSelector("button[id='btn-continue']");

    //###################################################################
    //  Method - clickContinueButton
    //###################################################################
    public PassengerDetailsPage clickContinueButton() throws InterruptedException {
        clickElement(byContinueButton);
        return this;
    }
    //###################################################################
    //  Method - addAdditionalBags
    //###################################################################
    public PassengerDetailsPage addAdditionalBags(int bagCount) throws InterruptedException {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        WebElement tmpElement= driver.findElement(byAddAdditionalBag);

        // scroll to the element
        GenericUtils.scrolltoViewElement(driver, tmpElement);

        tmpElement.click();
        timeUnit.sleep(3L);

        AdditionalBagPage additionalBagPage= new AdditionalBagPage(driver);
        additionalBagPage.addAdditionalBags(bagCount);
        return this;
    }
}
