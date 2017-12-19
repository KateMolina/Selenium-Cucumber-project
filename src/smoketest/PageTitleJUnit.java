package smoketest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
    WebDriver driver;
    String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    @Test
    public void pageTitleTest() {
        System.out.println("Running the test");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";

        Assertions.assertEquals(expectedTitle, actualTitle);


    }

    @BeforeEach
    public void setUp() {
        System.out.println("Initializing the driver");
        driver = utilities.DriverFactory.open("Opera");


    }
    @AfterEach
    public void tearDown() {
        System.out.println("Closing the driver");
        driver.close();

    }
}
