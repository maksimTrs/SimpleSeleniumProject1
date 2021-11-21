package tests.loanfacilities.positive;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.MainPage;
import pages.loanfacilities.CarLoansPage;
import pages.telecomunications.MobilePhoneRefillPage;
import tests.base.BaseTest;


import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

//@Execution(ExecutionMode.CONCURRENT)
public class CarLoansGeneralTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CarLoansGeneralTest.class);


    private static final String PAGE_TITLE = "You live Online-Bank";
    private static final String PAGE_URL = "https://next.privat24.ua/auto-credit/order";
    private static final String AGREEMENTS_TAB = "Agreements";
    private static final String ORDERS_TAB = "Order";
    private static final String HEADER_TABS = "Can't afford a car? The car in installments will make this purchase available!";

    private void startPage() {
        gotToUrl(siteUrl);
        mainPage.сarLoansMovement();
    }



    @Test
    @Epic("Test next.privat24.ua/auto-credit/order page functionality")
    @Feature("Testing auto-credit/order Page")
    @Story(value = "Test: Open  auto-credit/order page and check the Page Title and URL")
    @Severity(SeverityLevel.BLOCKER)
    @Description("TEST: Check Page Title name in Browser Tab and Page URL")
    public void carLoansPageTitleUrlTest() {


        logger.info("Test was started for {} test class", CarLoansGeneralTest.class.getSimpleName().toUpperCase());

       startPage();

        assertThat(carLoansPage.getPageTitle()).as("Wrong title page name = '%s'", carLoansPage.getPageTitle())
                .isEqualToIgnoringCase(PAGE_TITLE);

        assertThat(carLoansPage.getPageUrl()).as("Wrong URL of page = '%s'", carLoansPage.getPageUrl())
                .isEqualTo(PAGE_URL);

        logger.info("Test was finished for {}  page", carLoansPage.getPageUrl());

        saveScreenshotPNG();
    }

    @Test
    @Epic("Test next.privat24.ua/mobile page functionality")
    @Feature("Testing Mobile Login Widget Page")
    @Story(value = "Test: Open  mobile page and check the Page Title")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TEST: Check Page Title name in Browser Tab and Page Header name")
    public void carLoansPageTabsTest() {


       startPage();

        assertThat(carLoansPage.checkAgreementsTab()).as("Wrong tab page name = '%s'", carLoansPage.checkAgreementsTab())
                .isEqualToIgnoringCase(AGREEMENTS_TAB);

        assertThat(carLoansPage.checkOrderTab()).as("Wrong tab page name = '%s'", carLoansPage.checkOrderTab())
                .isEqualTo(ORDERS_TAB);

        assertThat(carLoansPage.checkOrderTabHeader())
                .isEqualToIgnoringCase(HEADER_TABS);

        saveScreenshotPNG();

    }
}
