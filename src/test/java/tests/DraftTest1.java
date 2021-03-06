package tests;


import org.junit.jupiter.api.Assertions;
import setupdata.User;
import setupdata.UserBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DraftTest1 extends BaseTest {

    private static final String COOKIE_NAME = "PHPSESSID";
    private static final String COOKIE_VALUE = "XXXXXXXXXXXXXXXXXXXXX";
    private User user = UserBuilder.createUserMethod();

    @Disabled
   // @ExtendWith({BaseTest2.class})
    @Test
    void mainTestMethod1() {
        driver.get("https://www.google.com/");
      /*  driver.manage().deleteCookieNamed("PHPSESSID"); // delete default value, after then add login cookie data from user session
        driver.manage().addCookie(new Cookie("PHPSESSID", "xSzf7Jem62s1Zk9ViVqKbt6ecGFdWcbI0"));*/

        Set<String> oldWindows = driver.getWindowHandles();
        System.out.println(oldWindows + " ++++ ");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        List<String> dataOfWindows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(dataOfWindows.get(1));
        driver.get("https://github.com/bonigarcia/webdrivermanager#webdrivermanager-as-java-dependency");

        Set<String> newWindows = driver.getWindowHandles();
        System.out.println(newWindows + " ++++ ");

        driver.close();

        driver.switchTo().window(dataOfWindows.get(0));
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenide");


    }

    @Disabled
    @Test
    void testMethod1() throws InterruptedException {
        driver.get("https://www.google.com/");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenide");

        Thread.sleep(2000);

        String ss = searchField.getAttribute("value"); // get shadow-root (user-agent) value inside parent element
        System.out.println(ss);
        String sss = searchField.getAttribute("ENTITY_NODE");
        System.out.println(sss);

        String shadowText = (String) ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"input[name='q']\").value");
        System.out.println(shadowText);

        if (!ss.isEmpty() && !shadowText.isEmpty()) searchField.clear();

        searchField.sendKeys("Selenium");

        System.out.println(searchField.getCssValue("color"));
        System.out.println(searchField.getAttribute("color"));
        System.out.println(searchField.getCssValue("maxlength"));
        System.out.println(searchField.getAttribute("maxlength"));
        System.out.println(searchField.getCssValue("appearance"));
        System.out.println(searchField.getAttribute("appearance"));
        System.out.println(searchField.getCssValue("size"));
        System.out.println(searchField.getAttribute("size"));
        System.out.println(searchField.getAttribute("innerHTML"));
        System.out.println(searchField.getAttribute("outerHTML"));

        String outerHTML = searchField.getAttribute("outerHTML");
       final String[] outerHTML1 = outerHTML.split("<|>");
        System.out.println(Arrays.toString(outerHTML1));
        String styleResult = "";

        for (String ssss:
             outerHTML1) {
           final String[] itemInfo = ssss.split(" ");
            for (String zz : itemInfo) {
                if (zz.contains("role"))
                styleResult += zz;
            }
        }
        System.out.println(styleResult);

        Assertions.assertEquals(styleResult, "role=\"combobox\"");


       // Thread.sleep(2000);
    }

    @Disabled
    @Test
    void testMethod2() throws InterruptedException {
        driver.get("https://www.traektoria.ru/");
        driver.findElement(By.cssSelector("div[data-class='js-update-user'] >span.trigger")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()='?????????? ???? ??????????']")));

        driver.findElement(By.xpath("//li/a[text()='?????????? ???? ??????????']")).click();
        WebElement email = driver.findElement(By.xpath("//input[@type='text'][@name=\"USER_LOGIN\"]"));
        WebElement passW = driver.findElement(By.xpath("//input[@type='password'][@name=\"USER_PASSWORD\"]"));
      //  email.sendKeys("roronoazorroippo@gmail.com");
      //  passW.sendKeys("SCFEDLvBNM020590");
        email.sendKeys(user.getUsername());
        passW.sendKeys(user.getUserpassword());
        System.out.println(user);

        driver.findElement(By.xpath("//input[@value='??????????']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text()) = '???????????? ??????????????']")));

        String cookieName2 = driver.manage().getCookieNamed("PHPSESSID").getName();
        System.out.println(cookieName2);
        String cookieValue2 = driver.manage().getCookieNamed("PHPSESSID").getValue();
        System.out.println(cookieValue2);


       Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//a[normalize-space(text()) = '???????????? ??????????????']")))
                .moveToElement(driver.findElement(By.xpath("//a[(text()) = '??????????']"))).click().build().perform();
    }

    @Disabled
    @Test
    void testMethod3() throws InterruptedException {
        driver.get("https://www.traektoria.ru/");
        driver.manage().deleteCookieNamed("PHPSESSID");

        driver.manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_VALUE));
        System.out.println(driver.manage().getCookieNamed("PHPSESSID"));

        driver.navigate().refresh();

        LogEntries logs =  driver.manage().logs().get(LogType.BROWSER);
        for  (LogEntry entry : logs) System.out.println(entry);
    }

}


