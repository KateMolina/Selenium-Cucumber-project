package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }
    @Test(dataProvider = "getData")
    public void loginTest(String name, String email, String password) {
       // System.out.println("NEW RECORD: " + name + " " + email + " " + password);
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);

        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFORMATION: " + message);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();

    }
    @DataProvider
    public Object[][] getData(){
    return utilities.Excel.get("/Users/kate/Selenium3/src/utilities/UserLogin.xls");
    }

}
