package testcases;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import page.PaysheetPage;
import page.HomePage;
import page.LoginPage;
import page.LogoutPage;
import utils.Config;

public class PaysheetTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(PaysheetTest.class);
    private LoginPage loginPage;
    private PaysheetPage paysheetPage;
    private HomePage homePage;
    private LogoutPage logoutPage;


    @BeforeMethod
    public void setupBangLuongTest() {
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        paysheetPage = new PaysheetPage(driver);
        homePage = new HomePage(driver);
        logger.info("Khởi tạo trang LoginPage và PaysheetPage");
    }

    // Duyệt lương theo quy trình Nhân viên -> Quản lý bộ phận -> Quản lý
    @Test(priority = 1)
    public void test_QuyTrinhDuyet_ChotLuong_ThanhToanLuong() throws InterruptedException {
        logger.info("Bắt đầu test quy trình duyệt lương, chốt lương và thanh toán lương theo quy trình Nhân viên -> Quản lý bộ phận -> Quản lý ");
        // Thêm bảng lương
        driver.get(Config.url);
        logger.info("Truy cập vào URL: " + Config.url);
        loginPage.login(Config.username, Config.password);
        logger.info("Đăng nhập với tài khoản admin");
        homePage.clickSalary();
        paysheetPage.clickBangLuong();
        logger.info("Click menu Bảng lương");
        paysheetPage.clickThemBangLuong();
        logger.info("Click nút Thêm bảng lương");
        paysheetPage.clickTenBangLuong();
        paysheetPage.setTenBangLuong();
        logger.info("Nhập tên bảng lương");
        paysheetPage.clickCheckBoxHangThang();
        logger.info("Check mục Hàng tháng");
        paysheetPage.clickDropDownChonThang();
        paysheetPage.clickChonThangOption();
        paysheetPage.setGhiChu();
        logger.info("Nhập ghi chú");
        paysheetPage.click_sendkeys_DropDownNhanVien();
        paysheetPage.clickNhanVienOption();
        logger.info("Chọn nhân viên");
        paysheetPage.clickLuu();
        logger.info("Lưu bảng lương");

        // Gửi bảng lương
        paysheetPage.clickBangLuongID();
        paysheetPage.clickXemBangLuong();
        paysheetPage.clickGuiTatCa();
        paysheetPage.clickXacNhan();
        logger.info("Gửi bảng lương đã tạo");
        Thread.sleep(1000);
        logoutPage.Logout();
        logger.info("Đăng xuất admin");
        Thread.sleep(1000);

        // Nhân viên duyệt lương
        driver.get(Config.url);
        loginPage.login(Config.employee_username, Config.employee_password);
        logger.info("Đăng nhập với tài khoản nhân viên");
        homePage.clickSalary();
        paysheetPage.clickPhieuLuong();
        paysheetPage.clickMaPhieuLuong();
        paysheetPage.clickDuyet();
        paysheetPage.clickCo();
        logger.info("Nhân viên duyệt phiếu lương");
        Thread.sleep(1000);
        logoutPage.Logout();
        logger.info("Đăng xuất nhân viên");
        Thread.sleep(1000);

        // Quản lý bộ phận duyệt lương
        driver.get(Config.url);
        loginPage.login(Config.manager_username, Config.manager_password);
        logger.info("Đăng nhập với tài khoản quản lý bộ phận");
        homePage.clickSalary();
        paysheetPage.clickPhieuLuong();
        paysheetPage.clickMaPhieuLuong();
        paysheetPage.clickDuyet();
        paysheetPage.clickCo();
        logger.info("Quản lý bộ phận duyệt phiếu lương");
        Thread.sleep(1000);
        logoutPage.Logout();
        logger.info("Đăng xuất quản lý bộ phận");
        Thread.sleep(1000);

        // Quản lý duyệt lương
        driver.get(Config.url);
        loginPage.login(Config.admin_username, Config.admin_password);
        logger.info("Đăng nhập với tài khoản quản lý");
        homePage.clickSalary();
        paysheetPage.clickPhieuLuong();
        paysheetPage.clickMaPhieuLuong();
        paysheetPage.clickDuyet();
        paysheetPage.clickCo();
        logger.info("Quản lý duyệt phiếu lương");
        Thread.sleep(2000);
        paysheetPage.clickBangLuong();
        paysheetPage.clickBangLuongID();
        paysheetPage.clickXemBangLuong();
        paysheetPage.clickChotLuong();
        logger.info("Click chốt lương");
        paysheetPage.clickXacNhan();
        paysheetPage.clickXacNhanChotLuong();
        logger.info("Xác nhận chốt lương");
        paysheetPage.clickBangLuongID();
        logger.info("Click bảng lương");
        paysheetPage.clickPhieuLuongThanhToan();
        paysheetPage.clickThanhToan();
        logger.info("Click thanh toán");
        paysheetPage.clickTaoPhieu();
        paysheetPage.clickLamMoi();
        logger.info("Click vào nút làm mới");
        paysheetPage.clickLichSuThanhToan();
        logger.info("Click vào lịch sử thanh toán");
        paysheetPage.clickLamMoi();
        paysheetPage.clickMaLichSuThanhToan();
        logger.info("Click vào mã lịch sử thanh toán");

        // Verify get employee name
        String EMPLOYEE_NAME = paysheetPage.getEmployeeName();
        Assert.assertNotNull(EMPLOYEE_NAME, "Tên nhân viên không được null");
        Assert.assertTrue(paysheetPage.isLichSuThanhToanDisplayed(), "Lịch sử thanh toán không hiển thị");
        logger.info("Kết thúc testQuyTrinhDuyetLuong");
    }


    @Test(priority = 2)
    public void AddPaySheet() {
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
        homePage.clickSalary();
        paysheetPage.clickBangLuong();
        paysheetPage.clickThemBangLuong();
        paysheetPage.clickTenBangLuong();
        paysheetPage.setTenBangLuong();
        logger.info("Nhập tên bảng lương");
        paysheetPage.clickCheckBoxHangThang();
        logger.info("Check mục Hàng tháng");
        paysheetPage.clickDropDownChonThang();
        paysheetPage.clickChonThangOption();
        logger.info("Chọn tháng");
        paysheetPage.clickCheckBoxAllEmployee();
        paysheetPage.setGhiChu();
        logger.info("Nhập ghi chú");
        paysheetPage.clickLuu();
        logger.info("Lưu bảng lương");
    }

    @Test(priority = 3)
    public void testTimBangLuong() {
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
        homePage.clickSalary();
        paysheetPage.clickBangLuong();
        paysheetPage.setMaBangLuong();
        boolean ketQua = paysheetPage.isMaBangLuongHienThi("BL000001");
        Assert.assertTrue(ketQua, "Không tìm thấy mã bảng lương BL000001");
    }

    @Test(dependsOnMethods = "AddPaySheet")
    public void CancelPaySheet() {
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
        homePage.clickSalary();
        paysheetPage.clickBangLuong();
        paysheetPage.clickBangLuongID();
        paysheetPage.clickCancel();
        paysheetPage.setReason();
        paysheetPage.clickOK();
    }
}
