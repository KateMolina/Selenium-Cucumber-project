package smoketest;

import kk.CreateAccountPageModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPresence {

    private CreateAccountPageModel model;


    @BeforeEach
    public void setup() {
        String browserType = "Firefox";
        model = new CreateAccountPageModel(browserType);
    }

    @Test
    public void createAccountPositiveTest() {

    }
}
