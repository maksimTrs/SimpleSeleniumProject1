package pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.loanfacilities.CarLoansPage;
import pages.telecomunications.MobilePhoneRefillPage;

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


    @FindBy(css = "div[data-qa-value='credits']")
    private WebElement loanFacilities;

    @FindBy(xpath = "//div[@data-qa-value='auto_credit']/a")
    private WebElement carLeasing;

    @FindBy(xpath = "//div[text() = 'Car leasing']")
    private WebElement pageHeaderTitleCarLoans;



    public MobilePhoneRefillPage mobilePhoneRefillMovement() {
         webDriverWait.until(ExpectedConditions.elementToBeClickable(teleCommunications));
           /* action.moveToElement(teleCommunications)
                    .click()
                    .moveToElement(mobileTopUp).click().build().perform();*/
        teleCommunications.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mobileTopUp));
        mobileTopUp.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageHeaderTitle));
        return new MobilePhoneRefillPage();
    }

    public CarLoansPage сarLoansMovement() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loanFacilities));
           /* action.moveToElement(teleCommunications)
                    .click()
                    .moveToElement(mobileTopUp).click().build().perform();*/
        loanFacilities.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(carLeasing));
        carLeasing.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageHeaderTitleCarLoans));
        return new CarLoansPage();
    }
}
