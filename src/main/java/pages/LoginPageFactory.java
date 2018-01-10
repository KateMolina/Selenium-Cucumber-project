package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    WebDriver driver;


    @FindBy(id="MainContent_txtUserName")
    WebElement usernameBox;
    @FindBy(id="MainContent_txtPassword")
    WebElement passwordBox;
    @FindBy(id="MainContent_btnLogin")
    WebElement loginButton;

    public void setUserName(String username){
        usernameBox.sendKeys(username);
    }
    public void setPassword(String password){
        passwordBox.sendKeys(password);
    }
    public void clickSubmit(){
        loginButton.click();
    }
    public void login(String username, String password){
        setUserName(username);
        setPassword(password);
        clickSubmit();

    }

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}

