package tests.loanfacilities.negative;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.MainPage;
import pages.loanfacilities.CarLoansPage;
import tests.base.BaseTest;
import tests.base.Listener;
import org.junit.Rule;
import tests.loanfacilities.positive.CarLoansGeneralTest;

import static org.assertj.core.api.Assertions.assertThat;



public class CarLeasingNegativeTest extends BaseTest {


    private static final Logger logger = LoggerFactory.getLogger(CarLoansGeneralTest.class);


    private String submitError = "Incorrect value was entered";

    @Test
    @Epic("Test next.privat24.ua/auto-credit/order page functionality")
    @Feature("Testing auto-credit/order Page")
    @Story(value = "Test: Open  auto-credit/order page and check negative submit action")
    @Severity(SeverityLevel.MINOR)
    @Description("TEST: Submit car credit with empty phone field")
    public void carLoansPageTitleUrlTest() {


        logger.info("Test was started for {} test class", CarLoansGeneralTest.class.getSimpleName().toUpperCase());

        gotToUrl(siteUrl);
        mainPage.сarLoansMovement();

        assertThat(carLoansPage.checkSubmitError()).as("Wrong error page  = '%s'", carLoansPage.checkSubmitError())
                .isNotBlank()
                .isEqualToIgnoringCase(submitError);

        logger.info("Test was finished for {}  page", carLoansPage.getPageUrl());

        //saveScreenshotPNG();
    }
}
