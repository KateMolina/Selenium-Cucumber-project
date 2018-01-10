package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;

public class LoginFactory {

    String username = "molinakate888@gmail.com";
    String password = "1234567";
    public void loginTestPageFactory(){
        WebDriver driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(username, password);
    }
}
