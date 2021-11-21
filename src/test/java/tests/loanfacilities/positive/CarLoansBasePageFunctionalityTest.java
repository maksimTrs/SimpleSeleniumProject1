package tests.loanfacilities.positive;

import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.MainPage;
import pages.loanfacilities.CarLoansPage;
import tests.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;


public class CarLoansBasePageFunctionalityTest extends BaseTest {  //You live Online-Bank

    private static final Logger logger = LoggerFactory.getLogger(CarLoansBasePageFunctionalityTest.class);


    private final String FAQ_LAST_QUESTION = "Can the bank increase the interest rate by leasing?";
    private final String CAR_CREDIT_LINK = "https://pb.ua/avto";


    private  void initiateCatLoansPage() {
        gotToUrl(siteUrl);
        mainPage.сarLoansMovement();
    }

    @Test
    @Epic("Test next.privat24.ua/auto-credit/order page functionality")
    @Feature("Testing auto-credit/order Page")
    @Story(value = "Test: Open  auto-credit/order page and FAQ section")
    @Severity(SeverityLevel.NORMAL)
    @Description("TEST: Check FAQ Header and FAQ questions")
    public void carLoansFAQSectionTest() {

        SoftAssertions softly = new SoftAssertions();

        logger.info("Test was started for {} test class", CarLoansGeneralTest.class.getSimpleName().toUpperCase());

        initiateCatLoansPage();

        assertThat(carLoansPage.checkHeaderFAQ()).isTrue();

        assertThat(carLoansPage.returnListOfFAQElements())
                .as("Text does not contain '?' sign!")
                .allMatch(q -> q.getText().contains("?"));

        softly.assertThat(carLoansPage.checkListOfFAQElementsCount())
                .as("Wrong number (%d) of FAQ advices!", carLoansPage.checkListOfFAQElementsCount())
                .isEqualTo(9);

         softly.assertThat(carLoansPage.checkListOfFAQElementsFAQName(8))
                .isEqualTo(FAQ_LAST_QUESTION);

        softly.assertAll();
        saveScreenshotPNG();

        logger.info("Test was finished for {}  page", carLoansPage.getPageUrl());
    }

    @Test
    @Epic("Test next.privat24.ua/auto-credit/order page functionality")
    @Feature("Testing auto-credit/order Page")
    @Story(value = "Test: Open  auto-credit/order page and check credit calculation")
    @Severity(SeverityLevel.NORMAL)
    @Description("TEST: Check Car price/Your prepayment/Monthly payment calculation")
    public void carLoansCalculatorTest() {

        SoftAssertions softly = new SoftAssertions();

        logger.info("Test was started for {} test class", CarLoansGeneralTest.class.getSimpleName().toUpperCase());

        initiateCatLoansPage();
                carLoansPage.moveToNewCarControl()
                .moveCarPriceSlider()
                .movePrepaymentSlider();

        softly.assertThat(carLoansPage.checkNewCarControlColor())
                .as("Back Ground button color is not green. Actual color is %s", carLoansPage.checkNewCarControlColor())
                .containsAnyOf("rgb(141, 198, 65)", "rgba(141, 198, 65, 1)");


         assertThat(carLoansPage.checkCarPriceSliderH3Price())
                 .contains("1 500 000");

        assertThat(carLoansPage.checkPrepaymentSliderH3Price())
                .contains("1 400 000");

        assertThat(carLoansPage.getWindowCarPriceInputPrice())
                .isEqualTo("1 500 000");

        assertThat(carLoansPage.getWindowYourPrepaymentInputPrice())
                .isEqualTo("1 400 000");

        assertThat(carLoansPage.getWindowMonthlyPaymentPrice())
                .contains("1720.29");


        softly.assertAll();
        saveScreenshotPNG();

        logger.info("Test was finished for {}  page", carLoansPage.getPageUrl());
    }

    @Test
    @Epic("Test next.privat24.ua/auto-credit/order page functionality")
    @Feature("Testing auto-credit/order Page")
    @Story(value = "Test: Open  auto-credit/order page and check car credit link")
    @Severity(SeverityLevel.NORMAL)
    @Description("TEST: Open  auto-credit/order page anc check pb.ua/avto link")
    public void checkCarCreditLink() {


        logger.info("Test was started for {} test class", CarLoansGeneralTest.class.getSimpleName().toUpperCase());

        initiateCatLoansPage();

        assertThat(carLoansPage.checkAvtoVKreditLink())
                .isEqualTo(CAR_CREDIT_LINK);

        saveScreenshotPNG();

        logger.info("Test was finished for {}  page", carLoansPage.getPageUrl());
    }

}
