package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.util.concurrent.TimeUnit;

public class FlightListPage extends BasePage {

    //*********Constructor*********
    public FlightListPage(WebDriver driver) {
        super(driver);
    }

    By byTripType = By.cssSelector("div[data-testid='trip-type']");

    By byFlightPrice = By.cssSelector("span[class='text-right amount ng-star-inserted']");
    By byFirstRedDealFlight = By.xpath("//*[@id='e2e-itinerary-0']/div/div[2]/div/upsell-itinerary-fares/upsell-fare-cell[1]/div/label/div/span[2]/div/span/span/span");
    By byAddtoTripButton = By.cssSelector("button[name='add-to-cart'][aria-label='add to trip']");
    By byContinueButton = By.cssSelector("button[id='btn-continue']");

    //###################################################################
    //  Method - clickContinueButton
    //###################################################################
    public RedeemPointsPage clickContinueButton() throws InterruptedException {
        waitAndClickElement(byContinueButton, 4L);
        return new RedeemPointsPage(driver);
    }

    //###################################################################
    //  Method - CheckFlightPrice
    //###################################################################
    public FlightListPage CheckFlightPrice(String expectedText) {
        assertWildcard (byFlightPrice, expectedText);
        return this;
    }

    //###################################################################
    //  Method - getFirstRedDealPrice
    //###################################################################
    public FlightListPage getFirstRedDealPrice(StringBuilder flightPrice) {
        String actualText = getText(byFirstRedDealFlight);
        flightPrice.append(actualText);
        return this;
    }



    //###################################################################
    //  Method - selectFirstRedDealFlight
    //###################################################################
    public FlightListPage selectFirstRedDealFlight() throws InterruptedException {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        //WebElement tmpElement= driver.findElement(byFirstRedDealFlight);
        WebElement tmpElement= waitToBeVisible(byFirstRedDealFlight);

        // scroll to the element
        GenericUtils.scrolltoViewElement(driver, tmpElement);

        tmpElement.click();
        timeUnit.sleep(2L);

        // Click add to the trip button
        clickElement(byAddtoTripButton);
        return this;
    }
}//end class