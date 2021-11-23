package tests.base;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import tests.loanfacilities.negative.CarLeasingNegativeTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static constants.ProjectConstants.FILE_PATH;
import static constants.ProjectConstants.TIME_ZONE;

public class Listener implements TestWatcher {

    public static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
        String fileName = dateFormat.format(currentDate) + ".png";

        LOGGER.info("TEST {} FAILED!!!", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName()
                + "_" + fileName;//+ String.valueOf(System.currentTimeMillis()).substring(9,13);

        LOGGER.info("Trying to trace screenshot --->>> ");

       TakesScreenshot takesScreenshot = ((TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver);
       File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
      // File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(FILE_PATH + screenshotName)); // build/reports/tests
            LOGGER.info("Screenshot was created <<<--- ");
            attachScreenshotsToAllure(takesScreenshot);
        } catch (Exception e) {
            LOGGER.info(">>>> Exception on saving screenshot <<<<");
            e.printStackTrace();
        } finally {
            ((BaseTest) context.getRequiredTestInstance()).driver.quit();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        ((BaseTest) context.getRequiredTestInstance()).driver.quit();
    }

    @Attachment(value = "Failed test Screenshot")
    public byte[] attachScreenshotsToAllure(TakesScreenshot takesScreenshot) {
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

}
