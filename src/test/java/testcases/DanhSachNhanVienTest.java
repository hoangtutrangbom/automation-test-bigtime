package testcases;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DanhSachNhanVienPage;
import page.LoginPage;
import utils.Config;;

public class DanhSachNhanVienTest extends BaseTest {

    private DanhSachNhanVienPage danhSachNhanVienPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
        danhSachNhanVienPage = new DanhSachNhanVienPage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
    }


    @Test
    public void AddEmployee(){
        danhSachNhanVienPage.clickDanhSachNhanVien();
    }
}
