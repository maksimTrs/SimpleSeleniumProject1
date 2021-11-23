package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.loanfacilities.CarLoansPage;
import pages.telecomunications.MobilePhoneRefillPage;

import java.time.Duration;

public class MainPage extends BasePage{


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-qa-value='communications']")
    private WebElement teleCommunications;

    @FindBy(xpath = "//div[@data-qa-value='pay_mob']")
    private WebElement mobileTopUp;

    @FindBy(xpath = "//div[text() = 'Top-up']")
    private WebElement pageHeaderTitle;


    @FindBy(xpath = "//div[@data-qa-value='credits']")
    private WebElement loanFacilities;

    @FindBy(xpath = "//div[@data-qa-value='auto_credit']")
    private WebElement carLeasing;

    @FindBy(xpath = "//div[text() = 'Car leasing']")
    private WebElement pageHeaderTitleCarLoans;



    public void mobilePhoneRefillMovement() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(teleCommunications)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mobileTopUp)).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageHeaderTitle));
    }


    public void сarLoansMovement() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loanFacilities)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(carLeasing)).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageHeaderTitleCarLoans));
    }
}
