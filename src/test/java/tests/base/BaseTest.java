package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.base.BasePage;
import pages.car_loans.CarLoansPage;
import setupdata.Browsers;
import setupdata.HeadlessBrowsers;
import setupdata.ScreenShotActions;

import java.sql.DriverManager;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected static WebDriver driver;
    protected CarLoansPage carLoansPage;

    public static WebDriver getDriver() {
        return driver;
    }

    public  static void gotToUrl(String url) {
        driver.get(url);
    }

 /*   @BeforeAll
    static void beforeAll() {
         https://next.privat24.ua/?lang=en
    }*/

    @BeforeEach
    void setUp() {
        boolean  switcher = true;

        if (switcher) {
            driver = HeadlessBrowsers.HEADLESS_CHROME.createHeadlessBrowserInstance();
        }
        else {
            driver = Browsers.CHROME.createBrowserInstance();
            driver.manage().window().maximize();
        }
       // driver.get("https://next.privat24.ua/?lang=en");
    }

  /*  @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterEach
    void tearDown() {
        ScreenShotActions.screenShotSaver(driver);
        driver.quit();
    }
}

