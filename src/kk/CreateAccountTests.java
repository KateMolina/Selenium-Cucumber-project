package kk;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateAccountTests {

    private CreateAccountPageModel createAccountPageModel;
    private ConfirmationPageModel confirmationPageModel;


    @BeforeEach
    public void setup() {
        String browserType = "Firefox";
        createAccountPageModel = new CreateAccountPageModel(browserType);
        confirmationPageModel = new ConfirmationPageModel(browserType);

        createAccountPageModel.navigate();
    }

    @Test
    public void createAccountPositiveTest() {
        createAccountPageModel.inputName("Marry Smith");
        createAccountPageModel.inputEmail("ms@testemail.com");
        createAccountPageModel.inputPassword("MyVerySecuredPassword");

        createAccountPageModel.inputCommonData("3126694479");

        createAccountPageModel.clickSubmit();

        boolean success = confirmationPageModel.isOnScreen();
        Assert.assertTrue(success);
    }

    @Test
    public void createDuplicateAccountNegativeTest() {
        createAccountPageModel.inputName("John Smith");
        createAccountPageModel.inputEmail("ms@testemail.com"); // duplicate email is not allowed

        createAccountPageModel.clickSubmit();

        boolean success = confirmationPageModel.isOnScreen();
        Assert.assertFalse(success);
    }

    @AfterEach
    public void tearDown(){
        createAccountPageModel.stop();
    }

}
