package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FareConditionsPage extends BasePage{

    //*********Constructor*********
    public FareConditionsPage(WebDriver driver) {
        super(driver);
    }

    By byAcceptButton = By.cssSelector("button[id='btn-accept']");

    //###################################################################
    //  Method - clickContinueButton
    //###################################################################
    public PassengerDetailsPage clickAcceptButton() throws InterruptedException {
        waitAndClickElement(byAcceptButton, 2L);
        return new PassengerDetailsPage(driver);
    }
}// end class