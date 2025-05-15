package testcases;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.LogoutPage;
import utils.Config;

public class LogoutTest extends BaseTest {

    private LogoutPage logoutPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        logoutPage = new LogoutPage(driver);
        loginPage = new LoginPage(driver);
        driver.get(Config.url);
    }

    @Test
    public void testLogout() {
        loginPage.login(Config.username, Config.password);
        logoutPage.Logout();
    }
}
