package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.mobile_phone_refill.MobilePhoneRefill;

import java.time.Duration;

public class MainPage extends BasePage{



    public MainPage() {
        super();
    }

    @FindBy(css = "div[data-qa-value='communications']")
    private WebElement teleCommunications;

    @FindBy(css = "div[data-qa-value='pay_mob']")
    private WebElement mobileTopUp;

    @FindBy(xpath = "//div[text() = 'Top-up']")
    private WebElement pageHeaderTitle;



    public MobilePhoneRefill mobilePhoneRefillMovement() {
         webDriverWait.until(ExpectedConditions.elementToBeClickable(teleCommunications));
           /* action.moveToElement(teleCommunications)
                    .click()
                    .moveToElement(mobileTopUp).click().build().perform();*/
        teleCommunications.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mobileTopUp));
        mobileTopUp.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageHeaderTitle));
        return new MobilePhoneRefill();
    }
}
