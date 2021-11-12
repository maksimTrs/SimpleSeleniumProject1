package tests.mobile_phone_refill_test.positive;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.base.MainPage;
import pages.mobile_phone_refill.MobilePhoneRefill;
import tests.base.BaseTest;
import static org.assertj.core.api.Assertions.*;


public class MobileLoginWidgetPageTitleTest  extends BaseTest {

    private MainPage mainPage;
    private MobilePhoneRefill mobilePhoneRefill;
    private static final String PAGE_TITLE = "Top-up of the cell phone with the bank card online — Privat24";
    private static final String PAGE_HEADER = "Top-up";



    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check the Page Title")
    @Severity(SeverityLevel.BLOCKER)
    @Description("TEST: Check Page Title name in Browser Tab and Page Header name")
    public void mobileLoginWidgetPageTitleTest() {
        mainPage = new MainPage();
        mobilePhoneRefill = new MobilePhoneRefill();

        gotToUrl("https://next.privat24.ua/?lang=en");
        mainPage.mobilePhoneRefillMovement();

        assertThat(mobilePhoneRefill.getPageTitle()).as("Wrong title page name = '%s'",mobilePhoneRefill.getPageTitle())
                .isEqualToIgnoringCase(PAGE_TITLE);
 /*       assertThat(mobilePhoneRefill.getPageHeader()).as("Wrong header page name = '%s'",mobilePhoneRefill.getPageHeader())
                .isEqualToIgnoringCase(PAGE_HEADER);*/

       // attachScreenshot();
        saveScreenshotPNG();

    }
}
