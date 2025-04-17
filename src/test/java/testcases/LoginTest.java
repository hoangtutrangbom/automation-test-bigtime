package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.Config;


public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setupLogin() {
        loginPage = new LoginPage(driver);
        driver.get(Config.url);

    }

    @Test
    public void testLogin() {
        loginPage.login(Config.username, Config.password);

    }
}
