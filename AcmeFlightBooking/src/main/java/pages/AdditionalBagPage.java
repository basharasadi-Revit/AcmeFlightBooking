package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdditionalBagPage extends BasePage{

    //*********Constructor*********
    public AdditionalBagPage(WebDriver driver) {
        super(driver);
    }

    By byAddButton = By.cssSelector("button[class='btn right']");
    By byContinueButton =  By.cssSelector("button[id='bags-btn-continue']");
    By byConfirmAdditionalBag =  By.cssSelector("button[class='btn btn-primary btn-navigation e2e-btn-continue-tac']");

    //###################################################################
    //  Method - clickContinueButton
    //###################################################################
    public PassengerDetailsPage addAdditionalBags(int bagCount) throws InterruptedException {

        for (int indx = 1; indx < bagCount; indx++) {
            clickElement(byAddButton);
        }

        clickElement(byContinueButton);
        clickElement(byConfirmAdditionalBag);
        return new PassengerDetailsPage(driver);
    }

}// class

