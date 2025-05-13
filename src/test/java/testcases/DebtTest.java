package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.DebtPage;
import utils.Config;


public class DebtTest extends BaseTest {

    private LoginPage loginPage;
    private DebtPage debtPage;

    @BeforeMethod
    public void setupBangLuongTest() {
        loginPage = new LoginPage(driver);
        debtPage = new DebtPage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
    }

    @Test
    public void AddTamUng() {
        debtPage.clickTamUng();
        debtPage.clickThem();
        debtPage.clickChonNhanVien();
//        debtPage.sendKeysChonNhanVien();
//        debtPage.clickTienTamUng();
//        debtPage.sendKeysTienTamUng();
//        debtPage.sendKeysGhiChu();
//        debtPage.clickLuu();
    }

}
