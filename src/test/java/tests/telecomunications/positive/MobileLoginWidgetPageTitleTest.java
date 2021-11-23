package tests.telecomunications.positive;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.base.MainPage;
import pages.telecomunications.MobilePhoneRefillPage;
import tests.base.BaseTest;
import static org.assertj.core.api.Assertions.*;


public class MobileLoginWidgetPageTitleTest  extends BaseTest {


    private static final String PAGE_TITLE = "Top-up of the cell phone with the bank card online — Privat24";
    private static final String PAGE_HEADER = "Top-up";



    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check the Page Title")
    @Severity(SeverityLevel.BLOCKER)
    @Description("TEST: Check Page Title name in Browser Tab and Page Header name")
    public void mobileLoginWidgetPageTitleTest() {


        gotToUrl(siteUrl);
        mainPage.mobilePhoneRefillMovement();

        assertThat(mobilePhoneRefillPage.getPageTitle()).as("Wrong title page name = '%s'", mobilePhoneRefillPage.getPageTitle())
                .isEqualToIgnoringCase(PAGE_TITLE);
 /*       assertThat(mobilePhoneRefillPage.getPageHeader()).as("Wrong header page name = '%s'",mobilePhoneRefillPage.getPageHeader())
                .isEqualToIgnoringCase(PAGE_HEADER);*/

       // attachScreenshot();
       // saveScreenshotPNG();

    }
}
