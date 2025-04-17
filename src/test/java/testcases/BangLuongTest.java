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
    public void testQuyTrinhDuyetLuong() throws InterruptedException {

        // Thêm bảng lương và gửi
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
        bangLuongPage.clickBangLuongID();
        bangLuongPage.clickXemBangLuong();
        Thread.sleep(1000);
        bangLuongPage.clickGuiTatCa();
        bangLuongPage.clickXacNhan();
        Thread.sleep(1000);
        bangLuongPage.clickLogout();
        bangLuongPage.clickLogoutCo();

        // Nhân viên duyệt lương
        driver.get(Config.url);
        loginPage.login("minh00@gmail.com", "123456");
        bangLuongPage.clickPhieuLuong();
        Thread.sleep(1000);
        bangLuongPage.clickMaPhieuLuong();
        Thread.sleep(1000);
        bangLuongPage.clickDuyet();
        bangLuongPage.clickDongYDuyet();
        Thread.sleep(1000);
        bangLuongPage.clickLogout();
        bangLuongPage.clickLogoutCo();

        
        // Quản lý bộ phận duyệt lương
        driver.get(Config.url);
        loginPage.login("minh01@gmail.com", "123456");
        bangLuongPage.clickPhieuLuong();
        bangLuongPage.clickMaPhieuLuong();
        Thread.sleep(1000);
        bangLuongPage.clickDuyet();
        bangLuongPage.clickDongYDuyet();
        Thread.sleep(1000);
        bangLuongPage.clickLogout();
        bangLuongPage.clickLogoutCo();

        // Quản lý duyệt lương
        driver.get(Config.url);
        loginPage.login("admin@gmail.com", "123456");
        bangLuongPage.clickPhieuLuong();
        bangLuongPage.clickMaPhieuLuong();
        bangLuongPage.clickDuyet();
        bangLuongPage.clickDongYDuyet();
        Thread.sleep(1000);
        bangLuongPage.clickBangLuong();
        Thread.sleep(1000);
        bangLuongPage.clickBangLuongID();
        bangLuongPage.clickXemBangLuong();
        Thread.sleep(1000);
        bangLuongPage.clickChotLuong();
        Thread.sleep(1000);
        bangLuongPage.clickXacNhanChotLuong();
        

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
