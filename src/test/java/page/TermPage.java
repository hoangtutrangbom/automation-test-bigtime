package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DataGenerator;

public class TermPage extends BasePage {

    public TermPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/term']")
    private WebElement DieuKhoan_Button;

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement Them_Button;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[3]/div/input")
    private WebElement inputDieuKhoan;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/textarea")
    private WebElement inputNoiDungDieuKhoan;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    private WebElement btnLuuDieuKhoan;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--prepended v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//i[@class='mdi-menu-down mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default v-select__menu-icon']")
    private WebElement iconTrangThai;

    @FindBy(xpath = "//div[contains(text(),'Khóa')]")
    private WebElement trangThaiKhoa;

    @FindBy(xpath = "//tr[@id='row-0']//button[2]")
    private WebElement btnXoaDieuKhoan;

    @FindBy(xpath = "//span[contains(normalize-space(),'Có')]")
    private WebElement btnCo;

    @FindBy(xpath = "//div[contains(text(),'Cập nhật thành công')]")
    private WebElement toastUpdateSuccess;

    @FindBy(xpath = "//div[contains(text(),'Xóa thành công')]")
    private WebElement toastDeleteSuccess;

    @FindBy(xpath = "//div[contains(text(),'Thêm thành công')]")
    private WebElement toastAddSuccess;

    private void waitForToast(WebElement toast) {
        wait.until(ExpectedConditions.visibilityOf(toast));
        wait.until(ExpectedConditions.invisibilityOf(toast));
    }

    public String getToastMessageAdd() {
        waitForToast(toastAddSuccess);
        return toastAddSuccess.getText();
    }

    public String getToastMessageUpdate() {
        waitForToast(toastUpdateSuccess);
        return toastUpdateSuccess.getText();
    }

    public String getToastMessageDelete() {
        waitForToast(toastDeleteSuccess);
        String text = toastDeleteSuccess.getText();
        logger.info("Tost delete message: " + text);
        return text;
    }

    public void clickCo() {
        clickElementByJS(btnCo);
    }

    public void clickXoaDieuKhoan() {
        clickElement(btnXoaDieuKhoan);
    }

    public void clickTrangThaiKhoa() {
        clickElement(trangThaiKhoa);
    }

    public void clickIconTrangThai() {
        clickElement(iconTrangThai);
    }

    public void clickLuuDieuKhoan() {
        clickElement(btnLuuDieuKhoan);
    }

    public void clickDieuKhoan() {
        clickElement(DieuKhoan_Button);
    }

    public void setNoiDungDieuKhoan() {
        actions.moveToElement(inputNoiDungDieuKhoan).click().sendKeys("Automation test").perform();
    }

    public void clickThem() {
        clickElement(Them_Button);
    }

    public String inputRandomTieuDe(String prefix) {
        return setRandomValue(inputDieuKhoan, prefix);
    }
}
