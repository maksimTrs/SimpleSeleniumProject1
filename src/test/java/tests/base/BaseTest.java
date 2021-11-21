package tests.base;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.base.MainPage;
import pages.loanfacilities.CarLoansPage;
import pages.telecomunications.MobilePhoneRefillPage;
import setupdata.Browsers;
import setupdata.HeadlessBrowsers;
import setupdata.ScreenShotActions;

import static constants.ProjectConstants.*;

@Execution(ExecutionMode.CONCURRENT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public  class BaseTest {

    protected  WebDriver driver;
    protected BasePage basePage;
    protected CarLoansPage carLoansPage;
    protected MobilePhoneRefillPage mobilePhoneRefillPage;
    protected MainPage mainPage;


    public   void gotToUrl(String url) {
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
        basePage = new BasePage(driver);
        carLoansPage = new CarLoansPage(driver);
        mobilePhoneRefillPage = new MobilePhoneRefillPage(driver);
        mainPage = new MainPage(driver);
       // driver.get("https://next.privat24.ua/?lang=en");
    }

  /*  @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

    @Attachment(value = "Page Screenshot", type = "image/png")
    public  byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterEach
    void tearDown() {
        ScreenShotActions.screenShotSaver(driver);
        driver.quit();
    }
}

