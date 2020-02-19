package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFlightPage extends BasePage{

    //*********Constructor*********
    public SearchFlightPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By byTripType = By.cssSelector("div[data-testid='trip-type']");
    By byOneWayTrip = By.xpath("//span[@class='css-my9p2q-MenuItem'][text()='One way']");
    By byReturnTrip = By.xpath("//span[@class='css-my9p2q-MenuItem'][text()='Return']");

    By byDeparturePort = By.cssSelector("div[data-testid='departure-port']");
    By byArrivalPort = By.cssSelector("div[data-testid='arrival-port']");
    By byPortDropdown = By.cssSelector("input[class='css-1mu1mk2']");

    By byTravelDates = By.cssSelector("div[data-testid='travel-dates']");
    By bySearchButton = By.xpath("//button[text()='SEARCH FLIGHTS']");

    //###################################################################
    //  Method - SetSearchParams
    //###################################################################
    public SearchFlightPage SetSearchParams (String tripType, String departurePort, String arrivalPort) throws InterruptedException {
        if(tripType.toLowerCase() == "oneway")
            selectDropDownText(byTripType,byOneWayTrip);
        else
            selectDropDownText(byTripType,byReturnTrip);

        setDropDownTypeText(byDeparturePort,byPortDropdown, departurePort);
        setDropDownTypeText(byArrivalPort, byPortDropdown, arrivalPort);
        return this;
    }

    //###################################################################
    //  Method - SelectTravelDates
    //###################################################################
    public SearchFlightPage SelectTravelDates(String strDate) throws InterruptedException {
        clickElement(byTravelDates);
        CalendarPage calendarPage = new CalendarPage(driver);
        calendarPage.SelectTravelDates(strDate);

        return this;
    }

    //###################################################################
    //  Method - ClickSearchButton
    //###################################################################
    public FlightListPage ClickSearchButton() throws InterruptedException {
        clickElement(bySearchButton);
        return new FlightListPage(driver);
    }

}
