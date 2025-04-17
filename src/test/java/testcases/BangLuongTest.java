package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BangLuongPage;
import page.LoginPage;
import utils.Config;

public class BangLuongTest extends BaseTest {
    private LoginPage loginPage;
    private BangLuongPage bangLuongPage;

    @BeforeMethod
    public void setupBangLuongTest() {
        loginPage = new LoginPage(driver);
        bangLuongPage = new BangLuongPage(driver);

    }

    @Test
    public void ThemBangLuong() throws InterruptedException {
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
        bangLuongPage.clickBangLuong();
        bangLuongPage.clickThemBangLuong();
        bangLuongPage.clickTenBangLuong();
        bangLuongPage.setTenBangLuong();
        bangLuongPage.clickCheckBoxHangThang();
        bangLuongPage.clickDropDownChonThang();
        bangLuongPage.clickChonThangOption();
        bangLuongPage.setGhiChu();
        bangLuongPage.click_sendkeys_DropDownNhanVien();
        bangLuongPage.clickNhanVienOption();

        bangLuongPage.clickLuu();
        Thread.sleep(2000);
//        bangLuongPage.clickBangLuongID();
//        bangLuongPage.clickXemBangLuong();
//        bangLuongPage.clickGuiTatCa();

    }

    @Test
    public void GuiBangLuong(){
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
        bangLuongPage.clickBangLuong();
        bangLuongPage.clickBangLuongID();
        bangLuongPage.clickXemBangLuong()   ;
        bangLuongPage.clickGuiTatCa();
        bangLuongPage.clickXacNhan();
    }


    @Test
    public void DuyetBangLuong () throws InterruptedException {
        driver.get(Config.url);
        loginPage.login("minh00@gmail.com", "123456");
        Thread.sleep(2000);
    }
}
