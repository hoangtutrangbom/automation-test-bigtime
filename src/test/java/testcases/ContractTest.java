package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.ContractPage;
import page.LoginPage;
import utils.Config;

public class ContractTest extends BaseTest {

    private LoginPage loginPage;
    private ContractPage contractPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        contractPage = new ContractPage(driver);
        homePage = new HomePage(driver);
        driver.get(Config.url);
        loginPage.login(Config.admin_username, Config.admin_password);
        logger.info("Đăng nhập với tài khoản quản lý: {}", Config.admin_username);
    }

    @Test
    public void CanCelConTract(){
        logger.info("Bắt đầu test hủy hợp đồng");
        homePage.clickAdmin();
        contractPage.clickHopDong();

        // Kiểm tra trang hợp đồng đã được mở
        Assert.assertTrue(contractPage.isContractPageDisplayed(), "Trang hợp đồng không hiển thị");
        contractPage.clickIconAction();
        contractPage.clickCanCel();
        contractPage.setReason();
        contractPage.clickOK();

        // Kiểm tra hủy hợp đồng thành công
        Assert.assertTrue(contractPage.isCancelSuccessful(), "Hủy hợp đồng không thành công");
        logger.info("Hủy hợp đồng thành công");
    }


    @Test
    public void testThemHopDongThoiVuVaXacNhan() throws InterruptedException {

        homePage.clickAdmin();
        contractPage.clickHopDong();
        Thread.sleep(5000);
        contractPage.clickThem();
        contractPage.clickTitleHopDong();
        contractPage.setNhanVien();
        contractPage.clickTenNhanVien();
        contractPage.clickOpenLoaiHopDong();
        contractPage.clickHopDongThoiVu();
        contractPage.clickLichNgayBatDau();
        contractPage.clickNgayBatDau();
        contractPage.clickChon();
        contractPage.clickLichDenNgay();
        contractPage.clickDenNgay();
        contractPage.clickChon();
        contractPage.setGhiChu();
        contractPage.setNoiDung();
        contractPage.scrollToThongTinDieuKhoan();
        contractPage.clickChonTatCadieuKhoan();
        contractPage.clickLuu();
        contractPage.clickIconAction();
        contractPage.clickEdit();
        contractPage.clickOptionTrangThai();
        contractPage.clickXacNhan();
        contractPage.clickLuu();
        contractPage.clickCoXacNhan();
        Thread.sleep(2000);
        contractPage.clickIconAction();
        contractPage.clickCanCel();
        contractPage.setReason();
        contractPage.clickOK();


    }


    @Test
    public void testThemHopDongChinhThucVaXacNhan() throws InterruptedException {

        homePage.clickAdmin();
        contractPage.clickHopDong();
        Thread.sleep(5000);
        contractPage.clickThem();
        contractPage.clickTitleHopDong();
        contractPage.setNhanVien();
        contractPage.clickTenNhanVien();
        contractPage.clickOpenLoaiHopDong();
        contractPage.clickHopDongChinhThuc();
        contractPage.setLuongCoBan();
        contractPage.setGhiChu();
        contractPage.setNoiDung();
        contractPage.scrollToThongTinDieuKhoan();
        contractPage.clickChonTatCadieuKhoan();
        contractPage.clickLuu();
    }


    @Test
    public void testThemHopDongThuViec() throws InterruptedException {

        homePage.clickAdmin();
        contractPage.clickHopDong();
        Thread.sleep(5000);
        contractPage.clickThem();
        contractPage.clickTitleHopDong();
        contractPage.setNhanVien();
        contractPage.clickTenNhanVien();
        contractPage.setLuongCoBan();
        contractPage.clickLichNgayBatDau();
        contractPage.clickNgayBatDau();
        contractPage.clickChon();
        contractPage.clickLichDenNgay();
        contractPage.clickDenNgay();
        contractPage.clickChon();
        contractPage.setGhiChu();
        contractPage.setNoiDung();
        contractPage.scrollToThongTinDieuKhoan();
        contractPage.clickChonTatCadieuKhoan();
        contractPage.clickLuu();
    }

    // Search
    @Test
    public void SearchContractCode() throws InterruptedException {
        homePage.clickAdmin();
        contractPage.clickHopDong();
        Thread.sleep(3000);
        contractPage.setContractCode();
        contractPage.clickSearchButton();
    }

    @Test
    public void SearchEmployeeCode() throws InterruptedException {
        homePage.clickAdmin();
        contractPage.clickHopDong();
        Thread.sleep(3000);
        contractPage.setEmployeeCode();
        contractPage.clickSearchButton();
        contractPage.verifyEmployeeCodeDisplayed();
    }

    @Test
    public void testHuyThemHopDong() throws InterruptedException {
        homePage.clickAdmin();
        contractPage.clickHopDong();
        Thread.sleep(5000);
        contractPage.clickThem();
        contractPage.clickHuy();
    }
}
