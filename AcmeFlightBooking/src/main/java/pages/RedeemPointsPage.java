package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedeemPointsPage extends BasePage{

    //*********Constructor*********
    public RedeemPointsPage(WebDriver driver) {
        super(driver);
    }

    By byContinueButton = By.cssSelector("button[id='btn-continue']");

    //###################################################################
    //  Method - clickContinueButton
    //###################################################################
    public FareConditionsPage clickContinueButton() throws InterruptedException {
        waitAndClickElement(byContinueButton, 3L);
        return new FareConditionsPage(driver);
    }
}// end class