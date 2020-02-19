package tests;

import org.testng.annotations.Test;
import pages.*;
import utils.DateUtils;

import java.util.concurrent.TimeUnit;

public class FlightSearchTests extends BaseTest {

    @Test (priority = 0)
    public void FlightBookingAdd_OneBag () throws InterruptedException {
        FlightBookingProcess("oneway", "Sydney", "Brisbane", 1);
    }

    @Test (priority = 1)
    public void FlightBookingAdd_TwoBags () throws InterruptedException {
        FlightBookingProcess("oneway", "Sydney", "Brisbane", 2);
    }

    @Test (priority = 2)
    public void FlightBookingAdd_ThreeBags () throws InterruptedException {
        FlightBookingProcess("oneway", "Sydney", "Brisbane", 3);
    }

    @Test (priority = 3)
    public void FlightBookingAdd_FourBags () throws InterruptedException {
        FlightBookingProcess("oneway", "Sydney", "Brisbane", 4);
    }

    @Test (priority = 4)
    public void FlightBookingAdd_FiveBags () throws InterruptedException {
        FlightBookingProcess("oneway", "Sydney", "Brisbane", 5);
    }


    //###################################################################
    //  Method - FlightBookingProcess
    //###################################################################
    public void FlightBookingProcess(String tripType, String departurePort, String arrivalPort, int additionalBags) throws InterruptedException{
        TimeUnit timeUnit = TimeUnit.SECONDS;
        String strDate = DateUtils.calculateDate();

        driver.get(commonVars.autURL);

        SearchFlightPage searchFlightPage = new SearchFlightPage(driver);

        // Set the Flight Serach Parameters
        searchFlightPage.SetSearchParams(tripType, departurePort, arrivalPort);
        searchFlightPage.SelectTravelDates(strDate);
        FlightListPage flightListPage = searchFlightPage.ClickSearchButton();

        // Check the initial price is $0
        flightListPage.CheckFlightPrice("$0");

        // Get the price of the first Red Deal Flight
        StringBuilder flightPrice = new StringBuilder("");
        flightListPage.getFirstRedDealPrice(flightPrice);

        // Select the First RedDeal flight and Add to Trip
        flightListPage.selectFirstRedDealFlight();

        // Check the flight price is as per the RedDeal price
        flightListPage.CheckFlightPrice(flightPrice.toString());

        // Press the Continue button
        RedeemPointsPage redeemPointsPage = flightListPage.clickContinueButton();

        // Redeem points
        FareConditionsPage fareConditionsPage = redeemPointsPage.clickContinueButton();

        // Fare Conditions
        PassengerDetailsPage passengerDetailsPage = fareConditionsPage.clickAcceptButton();

        // Passenger Details
        // Add Additional Bag/s & Confirm
        passengerDetailsPage.addAdditionalBags(additionalBags);
        passengerDetailsPage.clickContinueButton();
    }
}//end class