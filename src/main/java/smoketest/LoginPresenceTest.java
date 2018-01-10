package smoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresenceTest {
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
        System.out.println( "Running test");
       boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
       boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();

       Assert.assertTrue(loginEmailBox, "Email textBox present");
       Assert.assertTrue(passwordBox, "Password textBox present" );

   }

   @AfterMethod
    public void tearDown(){
       System.out.println("Closing test");
       driver.close();
   }

    //@org.testng.annotations.BeforeMethod
    //public void setUp() throws Exception {
    //}

    //@org.testng.annotations.AfterMethod
    //public void tearDown() throws Exception {
    //}

}