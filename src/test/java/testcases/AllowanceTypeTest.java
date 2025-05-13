package testcases;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.AllowanceTypePage;
import page.LoginPage;
import utils.Config;

public class AllowanceTypeTest extends BaseTest {

    protected static final Logger logger = LogManager.getLogger(AllowanceTypeTest.class);
    private LoginPage loginPage;
    private AllowanceTypePage allowanceTypePage;
    private HomePage homePage;

    @BeforeMethod
    public void setupTestLoaiPhuCap() {
        allowanceTypePage = new AllowanceTypePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);

    }

    @Test(priority = 1)
    public void testThemLoaiPhuCap() {

        homePage.clickSalary();

        allowanceTypePage.clickLoaiPhuCap();
        logger.info("Click vào loại phụ cấp");
        allowanceTypePage.clickThem();
        logger.info("Click vào nút thêm");
        allowanceTypePage.clickTenPhuCap();

        // Tạo tên phụ cấp ngẫu nhiên
        String newName = allowanceTypePage.inputRandomTenPhuCap("Automation test");
        allowanceTypePage.setTienPhuCap();
        allowanceTypePage.clickLoaiPhuCapOptions();
        allowanceTypePage.clickHangThangOption();
        allowanceTypePage.setGhiChu();
        allowanceTypePage.clickLuu();
        allowanceTypePage.verifyToastThemThanhCong();
        logger.info("Đã tạo bảng lương thành công");
    }

    @Test(priority = 2)
    public void testThemTrungTenLoaiPhuCap() {
        homePage.clickSalary();

        allowanceTypePage.clickLoaiPhuCap();
        logger.info("Click vào loại phụ cấp");
        allowanceTypePage.clickThem();
        logger.info("Click vào nút thêm");
        allowanceTypePage.clickTenPhuCap();
        allowanceTypePage.setTenPhuCap();
        allowanceTypePage.setTienPhuCap();
        allowanceTypePage.clickLoaiPhuCapOptions();
        allowanceTypePage.clickHangThangOption();
        allowanceTypePage.setGhiChu();
        allowanceTypePage.clickLuu();
        allowanceTypePage.verifyThongBaoNhapTrungTen();
    }


    @Test(priority = 3)
    public void testSuaTenPhuCap() {
        homePage.clickSalary();

        allowanceTypePage.clickLoaiPhuCap();
        allowanceTypePage.clickSua();
        allowanceTypePage.updateRandomTenPhuCap("Automation test");
        allowanceTypePage.clickLuu();
    }

    @Test(priority = 4)
    public void testXoaPhuCap() {
        homePage.clickSalary();

        allowanceTypePage.clickLoaiPhuCap();
        allowanceTypePage.clickXoa();
        allowanceTypePage.clickCo();
        allowanceTypePage.verifyToastXoaThanhCong();

    }

}
