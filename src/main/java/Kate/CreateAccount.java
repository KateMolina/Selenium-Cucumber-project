package Kate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

    public static void main (String[] args){
        //1. Create WebDriver
        System.setProperty("webdriver.gecko.driver", "/Users/kate/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        // 2. Navigate to Account Management Page >> Click on Create account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.linkText("Create Account")).click();

        // 3. Fill out the form
        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Marry Smith ");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("565688768");
        driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]")).sendKeys("mspass");
        driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword'][type='password']")).sendKeys("565688768");


        //driver.findElement(By.id("MainContent_Female")).click();
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();

        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Canada");

        driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();

        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get conformation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("Conformation: " + conf);

        // 5. Close the browser
        driver.close();

    }
}
