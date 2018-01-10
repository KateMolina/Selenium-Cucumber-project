package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType = "firefox";
    String city = "New York, NY";
    String checkin = "01/10/2018";
    String checkout = "01/17/2018";
    String numOfGuests = "1";
    String starRating = "star4";
    String searchResult = "1";
    @Test
    public void hotelReservation(){
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkin);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkout);
        new Select(driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select"))).selectByValue(numOfGuests);
        driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();

        String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
        System.out.println("CITY: " + actualCity);
        driver.findElement(By.cssSelector("input[name='star'][id='" + starRating + "']")).click();

        //driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();


        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        String hotelName = driver.findElement(By.id("hotel-name")).getText();
        String hotelRating = driver.findElement(By.cssSelector("span[class='rating-number']")).getText();
        System.out.println("HOTEL: " + hotelName);
        System.out.println("RATING: " + hotelRating);

        driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr[1]/td[4]/form/div[1]/button")).click();
        String hotelPrice = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[10]/div[2]/section/article/div[2]/div[3]/div[7]/span[2]")).getText();
        System.out.println("PRICE: " + hotelPrice);

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Payment"));


    }
    @BeforeMethod
    public void setUp(){
        driver = utilities.DriverFactory.open(browserType);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
