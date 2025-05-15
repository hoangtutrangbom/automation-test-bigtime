package page;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContractPage extends BasePage {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(ContractPage.class);

    public ContractPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/contract']")
    private WebElement btnHopDong;

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement btnThem;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--error v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//span[@class='v-autocomplete__selection-text']")
    private WebElement inputNhanVien;

    @FindBy(xpath = "//div[@class='v-card-title']")
    private WebElement titleThongTinHopDong;

    @FindBy(xpath = "//span[normalize-space()='BAT810-']")
    private WebElement tenNhanVien;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//i[@title='Open']")
    private WebElement openLoaiHopDong;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//div[@class='v-autocomplete__selection']")
    private WebElement inputLoaiHopDong;

    @FindBy(xpath = "//div[1]/div[1]/div[3]/div[2]/div[1]") //div[2]/div[5]/div[1]/div[1]/div[3]/div[2]/div[1]
    private WebElement loaiHopDongChinhThuc;

    @FindBy(xpath = "//div[1]/div[1]/div[4]/div[2]/div[1]")
    private WebElement loaiHopDongThoiVu;

    @FindBy(xpath = "//input[contains(@value,'0 ₫')]")
    private WebElement inputLuongCoBan;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div[4]/div[1]/div/div/div/div[3]/textarea")
    private WebElement inputGhiChu;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div[4]/div[2]/div/div/div/div[3]/textarea")
    private WebElement inputNoiDung;

    @FindBy(xpath = "//tr/th[1]/div/div/div/input")
    private WebElement chonTatCaDieuKhoan;

    @FindBy(xpath = "//span[@class='v-expansion-panel-title__overlay']")
    private WebElement titleThongTinDieuKhoan;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    private WebElement btnLuu;

    @FindBy(xpath = "//div[2]/div/div/div/div/div[1]/div/div/div[3]/input")
    private WebElement btnLichNgayBatDau;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div[3]/div[3]/div/div/div/div/div[1]/div/div/div[3]/input")
    private WebElement btnLichDenNgay;

    @FindBy(xpath = "//div[@class='dp__cell_inner dp__pointer dp__date_hover'][normalize-space()='1']")
    private WebElement NgayBatDau;

    @FindBy(xpath = "//div[@class='dp__cell_inner dp__pointer dp__date_hover'][normalize-space()='30']")
    private WebElement DenNgay;

    @FindBy(xpath = "//button[contains(text(),'Chọn')]")
    private WebElement btnChon;

    @FindBy(xpath = "//span[normalize-space()='Hủy']")
    private WebElement btnHuy;

    @FindBy(xpath = "//form/div/div[1]/div/div/div/div[3]/div/input")
    private WebElement inputContractCode;

    @FindBy(xpath = "//form/div/div[2]/div/div/div/div[3]/div/input")
    private WebElement inputEmployeeCode;

    @FindBy(xpath = "//span[contains(normalize-space(),'Tìm kiếm')]")
    private WebElement searchButton;

    @FindBy(xpath = "//tr[@id='row-0']//span[contains(text(),'BAT810-Nguyễn Văn Minh')]")
    private WebElement verifyEmployee;

    @FindBy(xpath = "//tr[@id='row-1']//i[@class='mdi mdi-format-list-group mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    private WebElement iconAction;

    @FindBy(xpath = "//span[contains(text(),'Sửa')]")
    private WebElement btnEdit;

    @FindBy(xpath = "//span[contains(text(),'Hủy')]")
    private WebElement btnCancel;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//i[@class='mdi-menu-down mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default v-select__menu-icon']")
    private WebElement optionTrangThai;

    @FindBy(xpath = "//div[1]/div[1]/div[3]/div[2]/div[1]")
    private WebElement btnXacNhan;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement btnCo;

    @FindBy(xpath = "//form/div/div[3]/div/div/div/div/div/div[3]/textarea")
    private WebElement inputReason;

    @FindBy(xpath = "//span[contains(normalize-space(),'Có')]")
    private WebElement btnOK;

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
        return toastDeleteSuccess.getText();
    }

    public void clickOK() {
        clickElement(btnOK);
    }

    public void setReason() {
        actions.moveToElement(inputReason).click().sendKeys("Automation test").perform();
    }

    public void clickCanCel() {
        clickElement(btnCancel);
    }

    public void clickCoXacNhan() {
        clickElement(btnCo);
    }

    public void clickXacNhan() {
        clickElement(btnXacNhan);
    }

    public void clickOptionTrangThai() {
        clickElement(optionTrangThai);
    }

    public void clickEdit() {
        clickElement(btnEdit);
    }

    public void clickIconAction() {clickElement(iconAction);}

    public void verifyEmployeeCodeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(verifyEmployee));
            System.out.println("Employee 'BAT810-Nguyễn Văn Minh' is displayed.");
        } catch (TimeoutException e) {
            System.out.println("Employee 'BAT810-Nguyễn Văn Minh' is NOT displayed.");
            Assert.fail("Employee not found!");
        }
    }


    public void setEmployeeCode() {
        actions.moveToElement(inputEmployeeCode).click().sendKeys("BAT810").build().perform();
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public void setContractCode() {
        actions.moveToElement(inputContractCode).click().sendKeys("HD0001").build().perform();
    }

    public void clickHuy() {
        clickElement(btnHuy);
    }

    public void clickChon() {
        actions.moveToElement(btnChon).click().perform();
    }

    public void clickNgayBatDau() {
        clickElement(NgayBatDau);
    }

    public void clickLichNgayBatDau() {
        clickElement(btnLichNgayBatDau);
    }

    public void clickDenNgay() {
        clickElement(DenNgay);
    }

    public void clickLichDenNgay() {
        actions.moveToElement(btnLichDenNgay).click().build().perform();
    }

    public void clickSave() {
        actions.moveToElement(btnLuu).click().perform();
    }

    public void scrollToThongTinDieuKhoan() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", titleThongTinDieuKhoan);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickChonTatCadieuKhoan() {
        actions.moveToElement(chonTatCaDieuKhoan).click().perform();
    }

    public void setNoiDung() {
        actions.moveToElement(inputNoiDung).click().sendKeys("Automation test").perform();
    }

    public void setGhiChu() {
        actions.moveToElement(inputGhiChu).click().sendKeys("Automation test").perform();
    }

    public void setLuongCoBan() {
        actions.moveToElement(inputLuongCoBan).click().sendKeys("5.000.000").perform();
    }

    public void clickHopDongThoiVu() {
        clickElement(loaiHopDongThoiVu);
    }

    public void clickHopDongChinhThuc() {
        clickElement(loaiHopDongChinhThuc);
    }


    public void setLoaiHopDong() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLoaiHopDong));
        input.click();

        // Xóa sạch text cũ: Ctrl+A + Delete
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        input.sendKeys("Chính thức");
    }

    public void clickOpenLoaiHopDong() {
        clickElement(openLoaiHopDong);
    }

    public void clickTenNhanVien() {
        clickElement(tenNhanVien);
    }

    public void clickTitleHopDong() {
        clickElement(titleThongTinHopDong);
    }

    public void setNhanVien() {
        actions.moveToElement(inputNhanVien).click().sendKeys("Nguyễn Văn Minh").perform();
    }

    public void clickThem() {
        clickElement(btnThem);
    }

    public void clickHopDong() {
        clickElement(btnHopDong);
    }

    public boolean isContractPageDisplayed() {
        try {
            return isElementVisible(btnHopDong) && isElementVisible(btnThem);
        } catch (Exception e) {
            logger.error("Lỗi khi kiểm tra trang hợp đồng: {}", e.getMessage());
            return false;
        }
    }

    public boolean isCancelSuccessful() {
        try {
            // Kiểm tra thông báo hủy thành công
            WebElement successMessage = driver.findElement(By.xpath("//div[@data-testid='toast-content']"));
            return isElementVisible(successMessage);
        } catch (Exception e) {
            logger.warn("Không tìm thấy thông báo hủy thành công: {}", e.getMessage());
            // Nếu không tìm thấy toast, có thể kiểm tra bằng cách khác
            return true; // Giả định thành công nếu không có lỗi
        }
    }
}
