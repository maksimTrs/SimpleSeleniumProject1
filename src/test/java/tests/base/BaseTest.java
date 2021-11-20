package tests.base;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import setupdata.Browsers;
import setupdata.HeadlessBrowsers;
import setupdata.ScreenShotActions;

import static constants.ProjectConstants.*;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public  static void gotToUrl(String url) {
        driver.get(url);
    }

      public String siteUrl = SITE_URL;

  /*  @BeforeAll
    static void beforeAll() {
          String SITE_URL = "https://next.privat24.ua/?lang=en";
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

