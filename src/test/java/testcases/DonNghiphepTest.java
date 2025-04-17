package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.DonNghiPhepPage;
import page.LoginPage;
import utils.Config;

public class DonNghiphepTest extends BaseTest {
    private LoginPage loginPage;
    private DonNghiPhepPage donNghiPhepPage;

    @BeforeMethod
    public void setupDonNghiphepTest() {
        loginPage = new LoginPage(driver);
        donNghiPhepPage = new DonNghiPhepPage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);

    }

    @Test
    public void AddDonNghiPhep()  {
        donNghiPhepPage.clickDonNghiPhep();

    }



}
