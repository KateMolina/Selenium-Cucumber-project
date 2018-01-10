package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    //This method return a WebDriver object
    public static WebDriver open(String browserType) {
        //1. Create WebDriver
        if (browserType.equalsIgnoreCase("Firefox")) {
            // code for FF
            System.setProperty("webdriver.gecko.driver", "/Users/kate/Downloads/geckodriver");
            return new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("Opera")) {
            System.setProperty("webdriver.opera.driver", "/Users/kate/Downloads/operadriver_mac64/operadriver");
            return new OperaDriver();
        }
        else {
            System.setProperty("webdriver.chrome.driver", "/Users/kate/Sel/chromedriver/2.34/bin/chromedriver");
            return new ChromeDriver();
        }





    }
}
