package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.TamUngPage;
import utils.Config;


public class TamUngTest extends BaseTest {

    private LoginPage loginPage;
    private TamUngPage tamUngPage;

    @BeforeMethod
    public void setupBangLuongTest() {
        loginPage = new LoginPage(driver);
        tamUngPage = new TamUngPage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
    }

    @Test
    public void AddTamUng() {
        tamUngPage.clickTamUng();
        tamUngPage.clickThem();
        tamUngPage.clickChonNhanVien();
//        tamUngPage.sendKeysChonNhanVien();
//        tamUngPage.clickTienTamUng();
//        tamUngPage.sendKeysTienTamUng();
//        tamUngPage.sendKeysGhiChu();
//        tamUngPage.clickLuu();
    }

}
