package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occassionalEmail;
    WebElement nameElement, emailElement, phoneElement,  passwordElement, verifyPasswordElement, countryElement, maleRadio, femaleRadio, weeklyCheckBox, monthlyCheckBox, occassionalCheckBox;
    WebDriver driver;


    @Before
    public void setUp (){
        driver = utilities.DriverFactory.open("Chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();

    }
    @Test
    public void newAccountTest() {
        System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occassionalEmail);
        defineWebElements();
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phone);
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

   //     driver.findElement(By.id("MainContent_btnSubmit")).click();
    }

    @After
    public void tearDown () {
        driver.quit();
    }
    public void defineWebElements(){
        nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        phoneElement =  driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        passwordElement = driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]"));
        verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword'][type='password']"));
        countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
        femaleRadio = driver.findElement(By.id("MainContent_Female"));
        weeklyCheckBox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        monthlyCheckBox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        occassionalCheckBox = driver.findElement(By.id("MainContent_checkUpdates"));

    }

    @Parameterized.Parameters
    public static List<String[]> getData() {
        return utilities.CSV.get("/Users/kate/Downloads/UserAccounts.csv");

    }
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
    String weeklyEmail, String monthlyEmail, String occassionalEmail){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;
        if (weeklyEmail.equals("TRUE")){
            this.weeklyEmail = true;
        }else {
            this.weeklyEmail = false;
        }
        if (monthlyEmail.equals("TRUE")){
            this.monthlyEmail = true;
        }else {
            this.monthlyEmail = false;
        }
        if (occassionalEmail.equals("TRUE")){
            this.occassionalEmail = true;
        }else {
            this.occassionalEmail = false;
        }

}

}



