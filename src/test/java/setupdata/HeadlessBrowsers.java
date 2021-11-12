package setupdata;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum HeadlessBrowsers {
    HEADLESS_CHROME {
        public WebDriver createHeadlessBrowserInstance() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless","--disable-gpu", "--window-size=1920,1080");
            return  new ChromeDriver(chromeOptions);
        }
    },
    HEADLESS_IE {
        // for the future plan
    },
    FIREFOX {
        public WebDriver createHeadlessBrowserInstance() {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless","--disable-gpu", "--window-size=1920,1080");
            return  new FirefoxDriver(firefoxOptions);
        }
    };

    public WebDriver createHeadlessBrowserInstance() {
        //return null;
        throw new RuntimeException("Incorrect BrowserName! Use value: HEADLESS_CHROME or HEADLESS_FIREFOX");
    }
}
