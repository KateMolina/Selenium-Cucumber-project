package smoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ATagsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Starting test");
        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        driver = utilities.DriverFactory.open("Opera");
        driver.get(webURL);

    }

    @Test
    public void loginElementPresentTest(){
        boolean createAccountPresent = false;

        System.out.println( "Running test");
        List <WebElement> aElements = driver.findElements(By.tagName("a"));
        int numberOfAElements = aElements.size();
        System.out.println("There are " + numberOfAElements + "a tags on the page");
        for (WebElement aElement : aElements){
            System.out.println(aElement.getText());
            if (aElement.getText().equals("CREATE ACCOUNT")){
                createAccountPresent = true;
                break;
            }
        }
        Assert.assertTrue(createAccountPresent);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing test");
       driver.close();
    }
}
