package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoaiPhuCapPage;
import page.LoginPage;
import utils.Config;

public class LoaiPhuCapTest extends BaseTest {

    private LoaiPhuCapPage loaiPhuCapPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupTestLoaiPhuCap() {
        loaiPhuCapPage = new LoaiPhuCapPage(driver);
        loginPage = new LoginPage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);

    }

    @Test(priority = 1)
    public void ThemLoaiPhuCap() throws InterruptedException {

        loaiPhuCapPage.clickLoaiPhuCap();
        loaiPhuCapPage.clickThem();
        Thread.sleep(2000);
        loaiPhuCapPage.clickTenPhuCap();
        Thread.sleep(2000);
        loaiPhuCapPage.sendKeysTenPhuCap();
//        loaiPhuCapPage.sendKeysTienPhuCap();
        loaiPhuCapPage.clickGhiChu();
        loaiPhuCapPage.sendKeysGhiChu();
//        loaiPhuCapPage.clickLuu();
//        loaiPhuCapPage.clickXoa();
//        loaiPhuCapPage.clickCo();


    }

    @Test(priority = 2)
    public void SuaPhuCap() throws InterruptedException {
        loaiPhuCapPage.clickLoaiPhuCap();
        loaiPhuCapPage.clickSua();
        loaiPhuCapPage.sendKeysCapNhatTenPhuCap();
        loaiPhuCapPage.sendKeysCapNhatTienPhuCap();
        loaiPhuCapPage.clickGhiChu();
        loaiPhuCapPage.sendKeysCapNhatGhiChu();
        loaiPhuCapPage.clickLuu();
        loaiPhuCapPage.clickXoa();
        loaiPhuCapPage.clickCo();
    }

    @Test(priority = 3)
    public void XoaPhuCap() {
        loaiPhuCapPage.clickLoaiPhuCap();
        loaiPhuCapPage.clickXoa();
        loaiPhuCapPage.clickCo();
    }

}
