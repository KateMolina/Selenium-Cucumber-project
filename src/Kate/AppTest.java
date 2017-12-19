package Kate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver", "/Users/kate/Sel/chromedriver/2.34/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("molinakate888@gmail.com");
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("1234567");

        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFORMATION: " + message);

        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: " + pageTitle);
        //if(pageTitle == "SDET Training | Account Management") {
          //  System.out.println("PAGE TITLE TEST PASSED");
        //}

        driver.close();


    }
}
