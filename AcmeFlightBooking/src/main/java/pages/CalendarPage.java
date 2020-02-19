package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CalendarPage extends BasePage {

    //*********Constructor*********
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public SearchFlightPage SelectTravelDates(String strDate) {

        // Select the date by double clicking
        Actions action = new Actions(driver);
        //WebElement tmpElement = driver.findElement(By.cssSelector("button[aria-label^='Thu Mar 05 2020']"));
        WebElement tmpElement = driver.findElement(By.cssSelector("button[aria-label^='" + strDate + "']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tmpElement);
        action.doubleClick(tmpElement).perform();
        // Confirm the date
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        return new SearchFlightPage(driver);
    }

}
