package tests.telecomunications.positive;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.MainPage;
import pages.telecomunications.MobilePhoneRefillPage;
import tests.base.BaseTest;

import static org.assertj.core.api.Assertions.*;

public class MobileLoginWidgetPageWidgetTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MobileLoginWidgetPageWidgetTest.class);


    private static final String H2_WIDGET_HEADER = "Login to Privat24";
   // private static final String SITE_URL = "https://next.privat24.ua/?lang=en";
    private static final String APPSTORE_LINK = "https://apps.apple.com/us/app/privat24-opened-to-everyone/id1333984846?l=ru&ls=1";
    private static final String PLAYMARKET_LINK = "https://play.google.com/store/apps/details?id=ua.privatbank.ap24";


    private  void initiateMobilePage() {
        gotToUrl(siteUrl);
        mainPage.mobilePhoneRefillMovement();

        mobilePhoneRefillPage.openMyWalletWidgetFrame()
                .switchToMyWalletWidgetFrame();
    }


    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Header")
    @Severity(SeverityLevel.MINOR)
    @Description("Test: Open  mobile page and check Widget Header")
    public void mobileLoginWidgetH2HeaderTest() {


        initiateMobilePage();

        logger.info(String.format("Widget_H2_Header has value on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetHeaderName()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetHeaderName())
                .as("Wrong widget name. Should be '%s'", H2_WIDGET_HEADER)
                .isEqualTo(H2_WIDGET_HEADER);

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
      //  saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Continue Button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Open  mobile page and check Widget Continue Button")
    public void mobileLoginWidgetContinueButtonTest() {



        initiateMobilePage();

        logger.info(String.format("Widget_Continue_Button is clickable on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetButton()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetButton())
                .as("Continue Button is inactive!")
                .isTrue();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
       // saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget QR Code")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test: Open  mobile page and check Widget QR Code")
    public void mobileLoginWidgetQRCodeTest() {



        initiateMobilePage();

        logger.info(String.format("Widget_QR_Code is displayed on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetQRCode()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetQRCode())
                .as("QR CODE is inactive!")
                .isTrue();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
       // saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget App Store Link")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test: Open  mobile page and check Widget App Store Link")
    public void mobileLoginWidgetAppStoreLinkTest() {



       initiateMobilePage();

        logger.info(String.format("Widget_AppStore_Link has value on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetAppStoreLink()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetAppStoreLink())
                .as("Wrong Widget AppStoreLink!")
                .isEqualTo(APPSTORE_LINK);

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
      //  saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Play Market Link")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test: Open  mobile page and check Widget Play Market Link")
    public void mobileLoginWidgetPlayMarketLinkTest() {

        initiateMobilePage();

        logger.info(String.format("Widget_PlayMarket_Link has value on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetPlayMarketLink()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetPlayMarketLink())
                .as("Wrong Widget PlayMarketLink!")
                .isEqualTo(PLAYMARKET_LINK);

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
      //  saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Phone Number Code")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Open  mobile page and check Widget Phone Number Code")
    public void mobileLoginWidgetPhoneNumberCodeTest() {



        initiateMobilePage();

        logger.info(String.format("Widget_PhoneNumberCode has default value on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetPhoneNumberCode()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetPhoneNumberCode())
                .as("Wrong default phone code!")
                .matches(p -> p.startsWith("UA+") && p.endsWith("380"), "should be: UA+380")
                .isNotBlank();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
     //   saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check Widget Phone Number Field")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Open  mobile page and check Widget Phone Number Field")
    public void checkMyWalletWidgetPhoneNumberField() {



        initiateMobilePage();

        logger.info(String.format("Widget_PhoneNumberField has default <empty> value on the site = '%s'.", mobilePhoneRefillPage.checkMyWalletWidgetPhoneNumberField()));

        assertThat(mobilePhoneRefillPage.checkMyWalletWidgetPhoneNumberField())
                .isBlank();

        logger.info("Test was passed for {} test class", MobileLoginWidgetPageWidgetTest.class.getSimpleName().toUpperCase());
       // saveScreenshotPNG();
    }
}
