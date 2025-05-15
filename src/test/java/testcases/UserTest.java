package testcases;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.UserPage;
import page.LoginPage;
import utils.Config;;

public class UserTest extends BaseTest {
    private UserPage userPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
    }

    @Test
    public void AddEmployee(){
        userPage.clickDanhSachNhanVien();
    }
}
