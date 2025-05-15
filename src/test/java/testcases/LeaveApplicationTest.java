package testcases;

import base.BaseTest;
import page.HomePage;
import page.LogoutPage;
import utils.MySQLCleaner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LeaveApplicationPage;
import page.LoginPage;
import utils.Config;

public class LeaveApplicationTest extends BaseTest {

    private LoginPage loginPage;
    private LeaveApplicationPage leaveApplicationPage;
    private HomePage homePage;
    private LogoutPage logoutPage;

    @BeforeMethod
    public void setupDonNghiphepTest() {

        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        homePage = new HomePage(driver);
        leaveApplicationPage = new LeaveApplicationPage(driver);
        driver.get(Config.url);
    }

    @Test//(invocationCount = 2)
    public void testThem_DuyetDonNghiPhep() {
        // Xóa dữ liệu test trước mỗi lần chạy
        MySQLCleaner.clearLeaveApplication();

        loginPage.login(Config.employee_username, Config.employee_password);
        logger.info("Đăng nhập với tài khoản nhân viên: {}", Config.employee_username);

        homePage.clickTimeKeepingManagement();

        // 1. Nhân viên tạo đơn nghỉ phép
        logger.info("Bắt đầu tạo đơn nghỉ phép");
        leaveApplicationPage.clickDonNghiPhep();

        leaveApplicationPage.clickThem();
        leaveApplicationPage.clickLoaiNgayNghi_DropDown();
        leaveApplicationPage.clickNghiPhepNam();
        leaveApplicationPage.clickNghiTuNgay();
        leaveApplicationPage.clickChonNgayNghi();
        leaveApplicationPage.clickChon();

        leaveApplicationPage.clickNghiDenNgay();
        leaveApplicationPage.clickChonNgayNghi();
        leaveApplicationPage.clickChon();


        leaveApplicationPage.setLyDo();
        leaveApplicationPage.clickLuu();
        logger.info("Đã tạo đơn nghỉ phép thành công");

        // 2. Sửa trạng thái đơn thành chờ duyệt
        leaveApplicationPage.clickIconAction();
        leaveApplicationPage.clickSua();
        leaveApplicationPage.clickTrangThai_DropDown();
        leaveApplicationPage.clickChoDuyet_Option();
        leaveApplicationPage.clickLuu();
        logger.info("Đã sửa trạng thái đơn thành chờ duyệt");

        logoutPage.Logout();
        logger.info("Đã đăng xuất tài khoản nhân viên");

        // 3. Quản lý đăng nhập và duyệt đơn
        driver.get(Config.url);
        loginPage.login(Config.admin_username, Config.admin_password);
        logger.info("Đăng nhập với tài khoản quản lý: {}", Config.admin_username);

        homePage.clickTimeKeepingManagement();
        leaveApplicationPage.clickDonNghiPhep();
        leaveApplicationPage.clickIconAction();

        leaveApplicationPage.clickDuyet();
        leaveApplicationPage.clickCoDuyet();
        logger.info("Quản lý đã duyệt đơn nghỉ phép");
//
//        // Kiểm tra duyệt thành công
//        Assert.assertTrue(leaveApplicationPage.isApprovalSuccessful(), "Duyệt đơn không thành công");
    }

}
