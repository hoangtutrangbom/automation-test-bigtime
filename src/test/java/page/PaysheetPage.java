package page;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaysheetPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(PaysheetPage.class);

    public PaysheetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(normalize-space(),'Hủy')]")
    private WebElement btnCancel;

    @FindBy(xpath = "//a[@href='/salary/pay-sheet']")
    private WebElement BangLuong_Button;

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement ThemBangLuong_Button;

    @FindBy(xpath = "//div[@class='v-input v-input--horizontal v-input--center-affix v-input--density-compact v-theme--lightColor7 v-locale--is-ltr v-text-field custom-input']")
    private WebElement TenBangLuong_Input;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[3]/div/input")
    private WebElement TenBangLuong_Input_2;

    @FindBy(xpath = "//div[@class='v-col-md-4 v-col-12']//i[@class='mdi-radiobox-blank mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    private WebElement Radio_CheckBox_HangThang;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//i[@title='Open']")
    private WebElement ChonThang_DropDown;

    @FindBy(xpath = "//div[@class='v-list-item-title'][normalize-space()='1/5/2025 - 31/5/2025']")
    private WebElement ChonThang_Option;

    @FindBy(xpath = "//div[@class='v-field v-field--appended v-field--center-affix v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//div[@class='v-field__input']")
    private WebElement NhanVien_DropDown;

    @FindBy(xpath = "//div[@role='option']//div[@class='v-list-item-title']")
    private WebElement NhanVien_Option;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    private WebElement Luu_Button;

    @FindBy(xpath = "//div[contains(text(),'Đăng xuất')]")
    private WebElement Logout_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement Logout_Co_Button;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//tr[@id='row-0']")
    private WebElement bangLuongID;

    @FindBy(xpath = "//span[contains(normalize-space(),'Xem bảng lương')]")
    private WebElement XemBangLuong_Button;

    @FindBy(xpath = "//span[contains(normalize-space(),'Gửi tất cả')]")
    private WebElement GuiTatCa_Button;

    @FindBy(xpath = "//span[.='Xác nhận']")
    private WebElement XacNhan_Button;

    @FindBy(xpath = "//textarea[@class='v-field__input']")
    private WebElement GhiChu_Input;

    @FindBy(xpath = "//a[@href='/salary/payslip']")
    private WebElement btnPayslip;

    @FindBy(xpath = "//tr[@id='row-0']//td[2]")
    private WebElement MaPhieuLuong;

    @FindBy(xpath = "//span[contains(normalize-space(),'Duyệt')]")
    private WebElement Duyet_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement btnCo;

    @FindBy(xpath = "//span[contains(normalize-space(),'Chốt lương')]")
    private WebElement ChotLuong_Button;

    @FindBy(xpath = "//button[@class='v-btn v-btn--slim v-theme--lightColor7 text-red v-btn--density-default rounded-lg v-btn--size-small v-btn--variant-outlined']//span[@class='v-btn__content']")
    private WebElement XacNhanChotLuong_Button;

    @FindBy(xpath = "//tbody/tr[1]")
    private WebElement latestBangLuongRow;

    @FindBy(xpath = "//span[normalize-space()='Phiếu lương']")
    private WebElement PhieuLuongThanhToan_Button;

    @FindBy(xpath = "//span[normalize-space()='Thanh toán']")
    private WebElement ThanhToan_Button;

    @FindBy(xpath = "//span[normalize-space()='Tạo phiếu']")
    private WebElement TaoPhieu_Button;

    @FindBy(xpath = "//span[normalize-space()='Làm mới']")
    private WebElement LamMoi_Button;

    @FindBy(xpath = "//div[@class='v-slide-group__content']//button[@value='2']//span[@class='v-btn__content']")
    private WebElement LichSuThanhToan_Button;

    @FindBy(xpath = "//td[@class='text-left cursor-pointer']")
    private WebElement MaLichSuThanhToan_Button;

    @FindBy(xpath = "//div[contains(text(),'Nguyễn Văn Minh')]")
    private WebElement TenNhanVien_Label;

    @FindBy(xpath = "//span[normalize-space() = 'Hủy']")
    private WebElement HuyBangLuong_Button;

    @FindBy(xpath = "//label[@class='v-label v-field-label']")
    private WebElement ThanhTimKiem;

    @FindBy(xpath = "//td[normalize-space()='BL000001']")
    private WebElement VerifyBangLuongID;

    @FindBy(xpath = "//div[@class='v-col-md-12 v-col-12']//i[@class='mdi-radiobox-blank mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    private WebElement checkBoxAllEmployee;

    @FindBy(xpath = "//form/div/div[3]/div/div/div/div[1]/div/div[3]/textarea")
    private WebElement inputReason;

    @FindBy(xpath = "//form/div/div[3]/div/div/div/div/div/div[3]/textarea")
    private WebElement labelReason;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement btnOK;

    @FindBy(xpath = "//span[contains(normalize-space(),'Làm mới')]")
    private WebElement btnRefresh;

    public void clickRefresh() {
        clickElement(btnRefresh);
    }

    public void clickOK() {
        clickElement(btnOK);
    }

    public void setReason() {
        wait.until(ExpectedConditions.elementToBeClickable(labelReason));
        labelReason.click();
        inputReason.sendKeys("Automation test");
    }

    public void clickCheckBoxAllEmployee() {
        actions.moveToElement(checkBoxAllEmployee).click().perform();
    }

    public boolean isMaBangLuongHienThi(String maBangLuong) {
        try {
            String text = VerifyBangLuongID.getText();
            System.out.println("Giá trị hiển thị trong ô bảng lương là: " + text);
            return VerifyBangLuongID.isDisplayed() && text.equals(maBangLuong);
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy mã bảng lương: " + maBangLuong);
            return false;
        }
    }

    public void setMaBangLuong() {
        actions.moveToElement(ThanhTimKiem).click().sendKeys("BL000001", Keys.ENTER).build().perform();
    }

    public void clickHuyBangLuong() {
        clickElementByJS(HuyBangLuong_Button);
    }

    public String getEmployeeName() {
        return getText(TenNhanVien_Label);
    }

    public boolean isLichSuThanhToanDisplayed() {
        try {
            return isElementVisible(LichSuThanhToan_Button) && isElementVisible(MaLichSuThanhToan_Button);
        } catch (Exception e) {
            logger.error("Lỗi khi kiểm tra lịch sử thanh toán: {}", e.getMessage());
            return false;
        }
    }

    public void clickMaLichSuThanhToan() {
        clickElement(MaLichSuThanhToan_Button);
    }

    public void clickLichSuThanhToan() {
        clickElement(LichSuThanhToan_Button);
    }

    public void clickLamMoi() {
        clickElement(LamMoi_Button);
    }

    public void clickTaoPhieu() {
        clickElement(TaoPhieu_Button);
    }

    public void clickThanhToan() {
        clickElement(ThanhToan_Button);
    }

    public void clickPhieuLuongThanhToan() {
        clickElement(PhieuLuongThanhToan_Button);
    }

    public void clickBangLuong() {
        clickElement(BangLuong_Button);
    }

    public void clickThemBangLuong() {
        clickElement(ThemBangLuong_Button);
    }

    public void clickTenBangLuong() {
        clickElement(TenBangLuong_Input);
    }

    public void setTenBangLuong() {
        setText(TenBangLuong_Input_2, "Automation Test ", false);
    }

    public void clickCheckBoxHangThang() {
        clickAction(Radio_CheckBox_HangThang);
    }

    public void clickDropDownChonThang() {
        clickAction(ChonThang_DropDown);
    }

    public void clickChonThangOption() {
        clickElement(ChonThang_Option);
    }

    public void click_sendkeys_DropDownNhanVien() {
        wait.until(ExpectedConditions.elementToBeClickable(NhanVien_DropDown));
        actions.moveToElement(NhanVien_DropDown).click().sendKeys("Nguyễn Văn Minh").build().perform();
    }

    public void clickNhanVienOption() {
        actions.moveToElement(NhanVien_Option).click().build().perform();
    }

    public void clickLuu() {
        clickElement(Luu_Button);
    }

    public void clickBangLuongID() {
        waitForOverlayToDisappear();
        clickElement(bangLuongID);
    }

    public void clickXemBangLuong() {

        clickElement(XemBangLuong_Button);
    }

    public void clickGuiTatCa() {
        clickElement(GuiTatCa_Button);
    }

    public void clickXacNhan() {
        clickElement(XacNhan_Button);
    }

    public void setGhiChu() {
        actions.moveToElement(GhiChu_Input).click().sendKeys("Automation test").build().perform();
    }

    public void clickPhieuLuong() {
        clickElement(btnPayslip);
    }

    public void clickMaPhieuLuong() {
        clickElement(MaPhieuLuong);
    }

    public void clickDuyet() {
        clickElement(Duyet_Button);
    }

    public void clickCo() {
        clickElement(btnCo);
    }

    public void clickChotLuong() throws InterruptedException {
        try {
            waitForOverlayToDisappear();
            // Wait for any animations to complete
            Thread.sleep(1000);
            // Wait for button to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(ChotLuong_Button));
            // Scroll into view
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ChotLuong_Button);
            // Use JavaScript click which bypasses overlay issues
            jsExecutor.executeScript("arguments[0].click();", ChotLuong_Button);
            logger.info("Clicked Chốt lương button successfully");
        } catch (Exception e) {
            logger.error("Failed to click Chốt lương button: {}", e.getMessage());
            throw e;
        }
    }

    public void clickXacNhanChotLuong() {
        clickElement(XacNhanChotLuong_Button);
    }

    public void clickCancel() {
        clickElement(btnCancel);
    }
}
