package testcases;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TermPage;
import page.HomePage;
import page.LoginPage;
import utils.Config;

public class TermTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TermTest.class);
    private HomePage homePage;
    private LoginPage loginPage;
    private TermPage termPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        termPage = new TermPage(driver);
        homePage = new HomePage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
    }

    @Test(priority = 1)
    public void testThemDieuKhoanTrangThaiHoatDong() {

        homePage.clickAdmin();
        termPage.clickDieuKhoan();
        termPage.clickThem();
        termPage.inputRandomTieuDe("Automation test");
        termPage.setNoiDungDieuKhoan();
        termPage.clickLuuDieuKhoan();
        termPage.getToastMessageAdd();
    }

    @Test(priority = 2)
    public void testThemDieuKhoanTrangThaiKhoa() {
        homePage.clickAdmin();
        termPage.clickDieuKhoan();
        termPage.clickThem();
        termPage.inputRandomTieuDe("Automation test");
        termPage.setNoiDungDieuKhoan();
        termPage.clickIconTrangThai();
        termPage.clickTrangThaiKhoa();
        termPage.clickLuuDieuKhoan();
        termPage.getToastMessageAdd();
    }

    @Test()
    public void testXoaDieuKhoan() {
        homePage.clickAdmin();
        termPage.clickDieuKhoan();
        termPage.clickXoaDieuKhoan();
        termPage.clickCo();
        termPage.getToastMessageDelete();
        logger.info("Xóa điều khoản thành công");
    }
}
