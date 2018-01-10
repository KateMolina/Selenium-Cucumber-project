package kk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPageModel {
    private WebDriver driver;

    public CreateAccountPageModel(String browserType){
        driver = utilities.DriverFactory.open(browserType);
    }

    public void navigate(){
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();
    }

    public void inputName(String name){
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        nameElement.sendKeys(name);
    }

    public void inputEmail(String email){
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        emailElement.sendKeys(email);
    }

    public void inputCommonData(String phoneNumber) {
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        phoneElement.sendKeys(phoneNumber);
    }
    public void inputPassword(String password){
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]"));
        passwordElement.sendKeys(password);

        WebElement verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword'][type='password']"));
        verifyPasswordElement.sendKeys(password);
    }

    public void inputCommonData2 (String country) {
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        new Select(countryElement).selectByVisibleText(country);
    }


    public void inputCommonData3(String gender) {
        WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        if (gender.equalsIgnoreCase("Male")) {
            maleRadio.click();
        }else {
            femaleRadio.click();
        }
    }
    public void inputCommonData4(boolean weeklyEmail) {
        WebElement weeklyCheckBox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        if (weeklyEmail) {
            if (!weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            } else {
                if (weeklyCheckBox.isSelected()) {
                    weeklyCheckBox.click();
                }
            }
        }
    }

     public void inputCommonData5(boolean monthlyEmail) {
         WebElement monthlyCheckBox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
         if (monthlyEmail) {
             if (!monthlyCheckBox.isSelected()) {
                 monthlyCheckBox.click();
             }else {
                 monthlyCheckBox.click();
             }
             }
    }

     public void inputCommonData6(boolean occassionalEmail) {
         WebElement occassionalCheckBox = driver.findElement(By.id("MainContent_checkUpdates"));
         if (occassionalCheckBox.isSelected()) {
             occassionalCheckBox.click();
         }
     }

    public void clickSubmit(){
        driver.findElement(By.id("MainContent_btnSubmit")).click();
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if (conf.equals(expected)){
            System.out.println("Conformation: " + conf);

        } else {
            System.out.println("Test Failed");
        }

    }
    public void stop() {
        driver.close();
    }
}
