package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.ProjectConstants.EXPLICITLY_WAIT;



public  class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        action = new Actions(driver);
    }

 /*   public void gotToUrl(String url) {
        driver.get(url);
    }*/
}
