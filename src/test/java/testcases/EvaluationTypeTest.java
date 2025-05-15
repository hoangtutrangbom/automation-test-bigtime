package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EvaluationTypePage;
import page.HomePage;
import page.LoginPage;
import utils.Config;

public class EvaluationTypeTest extends BaseTest {
    private LoginPage loginPage;
    private EvaluationTypePage evaluationTypePage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        evaluationTypePage = new EvaluationTypePage(driver);
        homePage = new HomePage(driver);
        driver.get(Config.url);
        loginPage.login(Config.username, Config.password);
    }

    @Test(priority = 1)
    public void AddEvaluationType() {
        homePage.clickAdmin();
        evaluationTypePage.clickEvaluationType();
        evaluationTypePage.clickAdd();
        evaluationTypePage.setEvaluationTypeName("Automation test");

        evaluationTypePage.setDescription("Automation test");
        evaluationTypePage.clickSave();

        String toastMsg = evaluationTypePage.getToastMessageAdd();
        Assert.assertEquals(toastMsg, "Thêm thành công", "Toast message không đúng");
        logger.info("Thêm thành công");
    }


    @Test(priority = 2)
    public void UpdateEvaluationType() {
        homePage.clickAdmin();
        evaluationTypePage.clickEvaluationType();
        evaluationTypePage.clickEdit();
        evaluationTypePage.setEvaluationTypeName("Automation test");
        evaluationTypePage.clickDropDownStatus();
        evaluationTypePage.clickLockStatus();
        evaluationTypePage.setDescription("Automation test");
        evaluationTypePage.clickSave();

        String toastMsg = evaluationTypePage.getToastMessageUpdate();
        Assert.assertEquals(toastMsg, "Cập nhật thành công", "Toast message không đúng");
        logger.info("Cập nhật thành công");

    }

    @Test(priority = 3)
    public void DeleteEvaluationType() {
        homePage.clickAdmin();
        evaluationTypePage.clickEvaluationType();
        evaluationTypePage.clickDelete();
        evaluationTypePage.clickConfirmDelete();

        String toastMsg = evaluationTypePage.getToastMessageDelete();
        Assert.assertEquals(toastMsg, "Xóa thành công", "Toast message không đúng");
        logger.info("Xóa điều khoản thành công");
    }

}
