package stepImplementations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDLoginTest {
    WebDriver driver;

    @Given("^user is on the login page$")
    public void Given_user_is_on_the_login_page (){
        System.out.println("User is on the login page");
        driver = utilities.DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password(){
        System.out.println("User enters username and password");
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("molinakate888@gmail.com");
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("1234567");
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @When("^user enters email (.*)$")
    public void user_enters_username (String username){
        System.out.println("TESTING: " + username);
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);

    }

    @And("^user enters password (.*)$")
    public void user_enters_password (String password){
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        click_login();
    }

    //@And("^user clicks login button$")
    public void click_login(){
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @Then("^user gets conformation$")
    public void user_gets_conformation(){
        System.out.println("User gets conformation");
        Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
    }

    @cucumber.api.java.After
    public void tearDown(){
        driver.quit();
    }
}
