package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.base.MainPage;
import pages.loanfacilities.CarLoansPage;
import pages.telecomunications.MobilePhoneRefillPage;
import setupdata.Browsers;
import setupdata.HeadlessBrowsers;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static constants.ProjectConstants.*;

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    protected  WebDriver driver;
    protected BasePage basePage;
    protected CarLoansPage carLoansPage;
    protected MobilePhoneRefillPage mobilePhoneRefillPage;
    protected MainPage mainPage;


    public   void gotToUrl(String url) {
        driver.get(url);
    }
    public String siteUrl = SITE_URL;

/*    @BeforeAll
    static void beforeAll() {
          //String SITE_URL = "https://next.privat24.ua/?lang=en";
        WebDriverManager.chromedriver().setup();
    }*/
    static {
         LOGGER.info("Start cleaning allure files: " + LocalTime.now());
         File allureFolder = new File("allure-results");
         if (allureFolder.isDirectory()) {
             for (File file : Objects.requireNonNull(allureFolder.listFiles())) {
                 file.delete();
             }
         }
         LOGGER.info("Allure directory was cleared");
         LOGGER.info("Start cleaning screenshot folder's files: " + LocalTime.now());
         if (CLEAR_SCREEN_DIRECTORY) {
             for (File file : Objects.requireNonNull(new File(FILE_PATH).listFiles())) {
                 file.delete();
             }
         }
        LOGGER.info("screenshot folder's files directory was cleared");
    }


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
        mainPage = new MainPage(driver);
        carLoansPage = new CarLoansPage(driver);
        mobilePhoneRefillPage = new MobilePhoneRefillPage(driver);
        //driver.get("https://next.privat24.ua/?lang=en");
    }
  /*  @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

/*    @Attachment(value = "Page Screenshot", type = "image/png")
    public  byte[] saveScreenshotPNG() {
        System.out.println("Attaching screenshot to Allure report");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

  /*  @AfterEach
      void  tearDown() {
        //ScreenShotActions.screenShotSaver(driver);
            driver.quit();

    }*/

}

