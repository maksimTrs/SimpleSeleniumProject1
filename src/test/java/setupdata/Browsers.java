package setupdata;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browsers {
    CHROME {
        public WebDriver createBrowserInstance() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    IE {
        // for the future plan
    },
    FIREFOX {
        public WebDriver createBrowserInstance() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public WebDriver createBrowserInstance() {
        //return null;
        throw new RuntimeException("Incorrect BrowserName! Use value: CHROME or FIREFOX");
    }
}

