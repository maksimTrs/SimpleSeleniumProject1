package pages.telecomunications;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class MobilePhoneRefillPage extends BasePage {
//https://next.privat24.ua/mobile   342342342   Top-up of the cell phone with the bank card online  — Privat24

    public MobilePhoneRefillPage() {
        super();
    }



    @FindBy(css = "div[data-qa-node='debitSourceSource']")
    private WebElement myWalletButton;

   @FindBy(xpath = "//iframe[@src='https://login-widget.privat24.ua/']")
    private WebElement loginWidget;


    @FindBy(css = "form[method='post'] h2")    //button[text()='Continue']
    private WebElement loginWidgetH2Header;

    @FindBy(xpath = "//button[text()='Continue']") //div[contains(@class, 'qrContainer')]
    private WebElement loginWidgetContinueButton;

    @FindBy(xpath = "//div[contains(@class, 'qrContainer')]//table")
    private WebElement loginWidgetQRContainer;

    @FindBy(css = "a[title='App Store']")
    private WebElement loginWidgetAppStoreLink;

    @FindBy(css = "a[title='Play Market']")
    private WebElement loginWidgetPlayMarket;

    @FindBy(css = "button[data-qa-node='login-code'] div[title='Україна']")
    private WebElement loginWidgetPhoneNumberCode;

    @FindBy(css = "input[data-qa-node='login-number']")
    private WebElement loginWidgetPhoneNumberField;


    public String getPageTitle() {
        return driver.getTitle();
    }


    public MobilePhoneRefillPage openMyWalletWidgetFrame() {
        myWalletButton.click();
        return this;
    }

    public MobilePhoneRefillPage switchToMyWalletWidgetFrame() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loginWidget));
        driver.switchTo().frame(loginWidget);
        return  this;
    }

    public String checkMyWalletWidgetHeaderName() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loginWidgetH2Header));
        return loginWidgetH2Header.getText();
    }

    public boolean checkMyWalletWidgetButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginWidgetContinueButton));
        return loginWidgetContinueButton.isEnabled();
    }

    public boolean checkMyWalletWidgetQRCode() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loginWidgetQRContainer));
        return loginWidgetQRContainer.isDisplayed();
    }

    public String checkMyWalletWidgetAppStoreLink() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginWidgetAppStoreLink));
        return loginWidgetAppStoreLink.getAttribute("href");
    }

    public String checkMyWalletWidgetPlayMarketLink() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginWidgetPlayMarket));
        return loginWidgetPlayMarket.getAttribute("href");
    }


    public String checkMyWalletWidgetPhoneNumberCode() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginWidgetPhoneNumberCode));
        return loginWidgetPhoneNumberCode.getAttribute("value");
    }

    public String checkMyWalletWidgetPhoneNumberField() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginWidgetPhoneNumberField));
        return loginWidgetPhoneNumberField.getAttribute("value");
    }

}
