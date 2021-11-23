package setupdata;

import constants.ProjectConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static constants.ProjectConstants.FILE_PATH;
import static constants.ProjectConstants.TIME_ZONE;


// Deprecated !
public class ScreenShotActions {

    public static void screenShotSaver(WebDriver driver) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
        String fileName = dateFormat.format(currentDate) + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(FILE_PATH + fileName));
            System.out.println("Screenshot was saved!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
