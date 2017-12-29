package Kate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {
    public static void main(String[] args){
        String name = "Marry Smith";
        String email = "ms@testemail.com";
        String password = "mspass";
        String phoneNumber = "565688768";
        String country = "Canada";
        String browserType = "Firefox";
        String gender = "Female";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occassionalEmail = false;


        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();

        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement =  driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]"));
        WebElement verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword'][type='password']"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckBox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        WebElement monthlyCheckBox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        WebElement occassionalCheckBox = driver.findElement(By.id("MainContent_checkUpdates"));


        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        if (gender.equalsIgnoreCase("Male")) {
            maleRadio.click();
        }
        else {
            femaleRadio.click();
        }
       // driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
        if (weeklyEmail) {
            if (!weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            }

        }else {
            if (weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            }

        }
        if (monthlyEmail) {
            if (!monthlyCheckBox.isSelected()) {
                monthlyCheckBox.click();
            }
        }else {
            if (monthlyCheckBox.isSelected()) {
                monthlyCheckBox.click();
            }
        }
        if (occassionalEmail) {
            if (occassionalCheckBox.isSelected()) {
                occassionalCheckBox.click();
            }
        }

         weeklyCheckBox.click();

       driver.findElement(By.id("MainContent_btnSubmit")).click();
        // 4. Get conformation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if (conf.equals(expected)) {
            System.out.println("Conformation: " + conf);
        } else {
            System.out.println("Test Failed");
        }


        driver.close();
    }
}
