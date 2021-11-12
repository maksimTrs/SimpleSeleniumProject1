package tests.mobile_phone_refill_test.positive;

import io.qameta.allure.*;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.MainPage;
import pages.mobile_phone_refill.MobilePhoneRefill;
import tests.base.BaseTest;

import static org.assertj.core.api.Assertions.*;
import static tests.base.BaseTest.gotToUrl;

public class MobileLoginWidgetPageWidgetTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileLoginWidgetPageWidgetTest.class);

    private MainPage mainPage;
    private MobilePhoneRefill mobilePhoneRefill;
    private static final String H2_WIDGET_HEADER = "Login to Privat24";
    private static final String SITE_URL = "https://next.privat24.ua/?lang=en";
    private static final String APPSTORE_LINK = "https://apps.apple.com/us/app/privat24-opened-to-everyone/id1333984846?l=ru&ls=1";
    private static final String PLAYMARKET_LINK = "https://play.google.com/store/apps/details?id=ua.privatbank.ap24";


    private  void initiateMobilePage() {
        gotToUrl(SITE_URL);
        mainPage.mobilePhoneRefillMovement();

        mobilePhoneRefill.openMyWalletWidgetFrame()
                .switchToMyWalletWidgetFrame();
    }


    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Header")
    @Severity(SeverityLevel.MINOR)
    @Description("Test: Open  mobile page and check Widget Header")
    public void mobileLoginWidgetH2HeaderTest() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        initiateMobilePage();

        logger.info(String.format("Widget_H2_Header has value on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetHeaderName()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetHeaderName())
                .as("Wrong widget name. Should be '%s'", H2_WIDGET_HEADER)
                .isEqualTo(H2_WIDGET_HEADER);

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Continue Button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Open  mobile page and check Widget Continue Button")
    public void mobileLoginWidgetContinueButtonTest() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        initiateMobilePage();

        logger.info(String.format("Widget_Continue_Button is clickable on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetButton()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetButton())
                .as("Continue Button is inactive!")
                .isTrue();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget QR Code")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test: Open  mobile page and check Widget QR Code")
    public void mobileLoginWidgetQRCodeTest() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        initiateMobilePage();

        logger.info(String.format("Widget_QR_Code is displayed on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetQRCode()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetQRCode())
                .as("QR CODE is inactive!")
                .isTrue();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget App Store Link")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test: Open  mobile page and check Widget App Store Link")
    public void mobileLoginWidgetAppStoreLinkTest() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

       initiateMobilePage();

        logger.info(String.format("Widget_AppStore_Link has value on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetAppStoreLink()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetAppStoreLink())
                .as("Wrong Widget AppStoreLink!")
                .isEqualTo(APPSTORE_LINK);

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Play Market Link")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test: Open  mobile page and check Widget Play Market Link")
    public void mobileLoginWidgetPlayMarketLinkTest() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        initiateMobilePage();

        logger.info(String.format("Widget_PlayMarket_Link has value on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetPlayMarketLink()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetPlayMarketLink())
                .as("Wrong Widget PlayMarketLink!")
                .isEqualTo(PLAYMARKET_LINK);

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Phone Number Code")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Open  mobile page and check Widget Phone Number Code")
    public void mobileLoginWidgetPhoneNumberCodeTest() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        initiateMobilePage();

        logger.info(String.format("Widget_PhoneNumberCode has default value on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetPhoneNumberCode()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetPhoneNumberCode())
                .as("Wrong default phone code!")
                .matches(p -> p.startsWith("UA+") && p.endsWith("380"), "should be: UA+380")
                .isNotBlank();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Phone Number Field")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Open  mobile page and check Widget Phone Number Field")
    public void checkMyWalletWidgetPhoneNumberField() {

        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        initiateMobilePage();

        logger.info(String.format("Widget_PhoneNumberField has default <empty> value on the site = '%s'.", mobilePhoneRefill.checkMyWalletWidgetPhoneNumberField()));

        assertThat(mobilePhoneRefill.checkMyWalletWidgetPhoneNumberField())
                .isBlank();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
        saveScreenshotPNG();
    }
}
