package page;

import base.BasePage;
import helpers.VerifyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataGenerator;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AllowanceTypePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(AllowanceTypePage.class);

    public AllowanceTypePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Loại phụ cấp')]")
    private WebElement LoaiPhuCap_Button;

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement Them_Button;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[4]/div/input")
    private WebElement TenPhuCap_Input;

    @FindBy(xpath = "//i[@class='mdi-cash-100 mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    private WebElement TienPhuCap_Input;

    @FindBy(xpath = "//textarea[@class='v-field__input']")
    private WebElement GhiChu_Input;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    private WebElement Luu_Button;

    @FindBy(xpath = "//tr[@id='row-0']//span[contains(text(),'Sửa')]")
    private WebElement Sua_Button;

    @FindBy(xpath = "//*[@id=\"row-0\"]/td[7]/button[2]/span[3]/span")
    private WebElement Xoa_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement Co_Button;

    @FindBy(xpath = "//i[@class='mdi mdi-form-select mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    private WebElement LoaiPhuCap_Options;

    @FindBy(xpath = "//div[contains(text(),'Hàng tháng')]")
    private WebElement HangThang_Option;

    @FindBy(xpath = "//li[contains(text(),'Tên loại phụ cấp đã tồn tại.')]")
    private WebElement messageLoiTrungTenPhuCap;

    @FindBy(xpath = "//div[contains(text(),'Xóa thành công')]")
    private WebElement messageXoaThanhCong;

    @FindBy(xpath = "//div[contains(text(),'Thêm thành công')]")
    private WebElement messageThemThanhCong;

    @FindBy(xpath = "//div[contains(text(),'Cập nhật thành công')]")
    private WebElement messageCapNhatThanhCong;


    public void verifyToastThemThanhCong() {
        logger.info("Bắt đầu verify toast 'Thêm thành công'");
        boolean ok = VerifyHelper.verifySuccessMessageDisplayed(driver, messageThemThanhCong, "Thêm thành công");
        if (ok) {
            logger.info("Toast 'Thêm thành công' hiển thị đúng nội dung");
        } else {
            logger.error("Toast 'Thêm thành công' không hiển thị hoặc sai nội dung");
        }
        assertTrue(ok, "Thông báo 'Thêm thành công' không hiển thị hoặc sai nội dung!");
    }

    public void verifyToastXoaThanhCong() {
        logger.info("Bắt đầu verify toast 'Xóa thành công'");
        boolean ok = VerifyHelper.verifySuccessMessageDisplayed(driver, messageXoaThanhCong, "Xóa thành công");
        if (ok) {
            logger.info("Toast 'Xóa thành công' hiển thị đúng nội dung");
        } else {
            logger.error("Toast 'Xóa thành công' không hiển thị hoặc sai nội dung");
        }
        assertTrue(ok, "Thông báo 'Xóa thành công' không hiển thị hoặc sai nội dung!");
    }

    public void verifyThongBaoNhapTrungTen() {
        boolean isLoiTrungTenHienThi = VerifyHelper.verifyErrorMessageDisplayed(driver, messageLoiTrungTenPhuCap, "Tên loại phụ cấp đã tồn tại.");
        if (isLoiTrungTenHienThi) {
            logger.info("Thông báo hiển thị đúng nội dung");
        } else {
            logger.error("Thông báo không hiển thị hoặc sai nội dung");
        }

        assertTrue(isLoiTrungTenHienThi, "Thông báo lỗi không đúng hoặc không hiển thị.");
    }

    public String inputRandomTenPhuCap(String prefix) {
        return setRandomValue(TenPhuCap_Input, prefix);
    }


    public void clickHangThangOption() {
        clickElement(HangThang_Option);
    }

    public void clickLoaiPhuCapOptions() {
        clickElement(LoaiPhuCap_Options);
    }

    public void clickLoaiPhuCap() {
        clickElement(LoaiPhuCap_Button);
    }

    public void clickThem() {
        clickElement(Them_Button);
    }

    public void clickTenPhuCap() {
        clickElement(TenPhuCap_Input);
    }

    public void setTenPhuCap() {
        setText(TenPhuCap_Input, "Phụ cấp tiền ăn", false);
    }

    public void setTienPhuCap() {

        actions.moveToElement(TienPhuCap_Input).click().sendKeys("2.000.000").build().perform();
    }

    public void clickGhiChu() {
        jsExecutor.executeScript("arguments[0].click();", GhiChu_Input);
    }

    public void setGhiChu() {
        actions.moveToElement(GhiChu_Input).click().sendKeys("Automation test").build().perform();
    }

    public void clickLuu() {
        actions.moveToElement(Luu_Button).click().build().perform();
    }

    public void clickXoa() {
        clickElement(Xoa_Button);
    }

    public void clickCo() {
        jsExecutor.executeScript("arguments[0].click();", Co_Button);
    }

    public void clickSua() {
        clickElement(Sua_Button);
    }


    public String updateRandomTenPhuCap(String prefix) {
        // 1. Sinh tên mới
        String newName = DataGenerator.generateUniqueName(prefix);
        logger.info("Bắt đầu cập nhật tên phụ cấp thành: " + newName);

        // 2. Đợi input sẵn sàng và clear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(TenPhuCap_Input));
        input.click();

        // Xóa sạch text cũ: Ctrl+A + Delete
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        // 3. Nhập tên mới
        input.sendKeys(newName);
        logger.info("Đã nhập tên mới: " + newName);

        return newName;
    }

    public void setCapNhatTenPhuCap() {
        clickElement(TenPhuCap_Input);
        TenPhuCap_Input.clear();
        setText(TenPhuCap_Input, "Automation Update Ten Phu Cap", false);
    }

    public void setCapNhatTienPhuCap() {
        clickElement(TienPhuCap_Input);
        TienPhuCap_Input.clear();
        setText(TienPhuCap_Input, "300.000", false);
    }

    public void sendKeysCapNhatGhiChu() {
        setText(GhiChu_Input, "Automation Update Ghi Chu", false);
    }

}
