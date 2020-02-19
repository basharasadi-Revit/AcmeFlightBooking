package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.CommonVars;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public CommonVars commonVars;

    @BeforeClass
    public void setupClass() {
        //WebDriverManager.chromedriver().version("2.26").setup();
        WebDriverManager.chromedriver().setup();
        commonVars = CommonVars.getInstance();
    }

    @BeforeMethod
    public void setupTest() {
        //Create a Chrome driver. All test classes use this.
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardownClass () {
        driver.quit();
    }
    @AfterMethod
    public void teardownTest () {
        driver.close();
    }
}
