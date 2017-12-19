package kk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPageModel {
    private WebDriver driver;

    public ConfirmationPageModel(String browserType){
        driver = utilities.DriverFactory.open(browserType);
    }

    public boolean isOnScreen(){
        WebElement element = driver.findElement(By.id("CHANGE TO REAL ID"));

        boolean isElementAvailable = element != null;

        return isElementAvailable;
    }

}
