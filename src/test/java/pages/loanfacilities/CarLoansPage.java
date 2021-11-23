package pages.loanfacilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class CarLoansPage extends BasePage {
  //  protected WebDriver driver;

    public CarLoansPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'auto-credit/my')]")
    private WebElement agreementsTab;

    @FindBy(xpath = "//div[text() ='Order']/parent::a[contains(@href, 'auto-credit/order')]")
    private WebElement orderTab;

    @FindBy(css = "div > h1")
    private WebElement textH1Header;


    @FindBy(xpath = "//div[@data-qa-node='type' and text()='With mileage']")
    private WebElement withMileageCarControl;


    @FindBy(xpath = "//label[@data-id='new' and text()='New']")
    private WebElement clickNewCarControl;

    @FindBy(xpath = "//div[@data-qa-node='type' and text()='New']")
    private WebElement withNewCarControl;

    @FindBy(xpath = "//div[text() = 'Car price']/../following-sibling::div//button[@type='button' and not(@data-qa-node='login')]")
    private WebElement carPriceSlider;

    @FindBy(xpath = "//div[text() = 'Your prepayment']/../following-sibling::div//button[@type='button' and not(@data-qa-node='login')]")
    private WebElement yourPrepaymentSlider;

    @FindBy(xpath = "//div[text()='Car price']/following::h3[1]")    //div[div[text()='Car price']]//h3
    private WebElement carPriceH3;

    @FindBy(xpath = "//div[text()='Your prepayment']/following::h3")
    private WebElement yourPrepaymentH3;

    @FindBy(xpath = "//input[@data-qa-node='amount']")   // getAttribute("value")
    private WebElement carPriceInput;

    @FindBy(xpath = "//input[@data-qa-node='prepaid']")   // getAttribute("value")
    private WebElement yourPrepaymentInput;

    @FindBy(xpath = "//div[contains(text(), 'Monthly payment')]/following-sibling::div/b")
    private WebElement monthlyPaymentCost;

    @FindBy(xpath = "//button[text() = 'Submit an application']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[text() = 'Incorrect value was entered']")
    private WebElement submitError;

    @FindBy(xpath = "//a[contains(text(), 'pb.ua/avto')]")
    private WebElement autoInCreditLink;


    @FindBy(xpath = "//div[. = 'FAQ']")
    private WebElement headerFAQ;

    @FindBys(@FindBy(xpath = "//div[contains(@class, 'marginTop2_')]//div[contains(@class, 'content_')]/div"))
    private List<WebElement> listOfFAQElements;




    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String checkAgreementsTab() {
        return agreementsTab.getText();
    }

    public String checkOrderTab() {
        return orderTab.getText();
    }

    public String checkOrderTabHeader() {
        return textH1Header.getText();
    }

    public String checkNewCarControlColor() {
        return  withNewCarControl.getCssValue("background-color");
    }

    public CarLoansPage moveToNewCarControl() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickNewCarControl));
        clickNewCarControl.click();
        return this;
    }

    public CarLoansPage moveCarPriceSlider() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(carPriceSlider));
        action.moveToElement(carPriceSlider).clickAndHold().moveByOffset(950, 0).release().perform();
        return this;
    }

    public String checkCarPriceSliderH3Price() {
        return carPriceH3.getText();
    }

    public CarLoansPage movePrepaymentSlider() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(yourPrepaymentSlider));
        action.moveToElement(yourPrepaymentSlider).clickAndHold().moveByOffset(950, 0).release().perform();
        return this;
    }

    public String checkPrepaymentSliderH3Price() {
        return yourPrepaymentH3.getText();
    }

    public String getWindowCarPriceInputPrice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(carPriceInput));
        return carPriceInput.getAttribute("value");
    }


    public String getWindowYourPrepaymentInputPrice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(yourPrepaymentInput));
        return yourPrepaymentInput.getAttribute("value");
    }

    public String getWindowMonthlyPaymentPrice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(monthlyPaymentCost));
        return monthlyPaymentCost.getText();
    }

    public String checkSubmitError() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(submitError));
        return submitError.getText();
    }

    public String checkAvtoVKreditLink() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(autoInCreditLink));
        return autoInCreditLink.getAttribute("href");
    }

    public boolean checkHeaderFAQ() {
        webDriverWait.until(ExpectedConditions.visibilityOf(headerFAQ));
        return headerFAQ.isDisplayed();
    }

    public int checkListOfFAQElementsCount() {
        return listOfFAQElements.size(); // 9
    }

    public String checkListOfFAQElementsFAQName(int indexFAQHeader) {
       return listOfFAQElements.get(indexFAQHeader).getText();
    }


    public List<WebElement> returnListOfFAQElements() {
        return listOfFAQElements;
    }

}
