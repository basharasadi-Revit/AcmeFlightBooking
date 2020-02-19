package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GenericUtils {

    //###################################################################
    //  Method - scrolltoView
    //###################################################################
    public static void scrolltoViewElement(WebDriver driver, WebElement element) {

        // scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");

    }//scrolltoView


    //###################################################################
    //  Method - getConfigPropObject
    //###################################################################
    public static Properties getConfigPropObject() {

        Properties propObject = null;
        try (InputStream input = GenericUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            propObject = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }
            //load a properties file from class path, inside static method
            propObject.load(input);

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

        return propObject;
    }//getConfigPropObject


}//emd class
