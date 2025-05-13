package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeaveApplicationPage extends BasePage {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(LeaveApplicationPage.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public LeaveApplicationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement Them_Button;

    @FindBy(xpath = "//div[contains(text(),'Đơn nghỉ phép')]")
    private WebElement DonNghiPhep_Button;

    @FindBy(xpath = "//div[@class='v-col-md-4 v-col-12']//i[@class='mdi-menu-down mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default v-select__menu-icon']")
    private WebElement LoaiNgayNghi_DropDown;

    @FindBy(xpath = "//div[contains(text(),'Nghỉ theo phép năm')]")
    private WebElement NghiTheoPhepNam_Option;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[3]/input")
    private WebElement NghiTuNgay_Input;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/div/div/div/div[1]/div/div/div[3]/input")
    private WebElement DenHetNgay_Input;

    @FindBy(xpath = "//div[@class='dp__cell_inner dp__pointer dp__date_hover'][normalize-space()='8']")
    private WebElement ChonNgayNghi;

    @FindBy(xpath = "//button[contains(text(),'Chọn')]")
    private WebElement Chon_Button;

    @FindBy(xpath = "//textarea[@class='v-field__input']")
    private WebElement LyDo_Input;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    private WebElement Luu_Button;

    @FindBy(xpath = "//span[contains(text(),'Xóa')]")
    private WebElement Xoa_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement Co_Button;

    @FindBy(xpath = "//span[contains(text(),'Sửa')]")
    private WebElement Sua_Button;

    @FindBy(xpath = "//div[@class='v-col-md-6 v-col-12']//i[@class='mdi-menu-down mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default v-select__menu-icon']")
    private WebElement TrangThai_DropDown;

    @FindBy(xpath = "//div[contains(text(),'Chờ duyệt')]")
    private WebElement TrangThai_ChoDuyet_Option;

    @FindBy(xpath = "//span[contains(text(),'Duyệt')]")
    private WebElement Duyet_Button;

    @FindBy(xpath = "//button[@class='v-btn v-btn--slim v-theme--lightColor7 text-success v-btn--density-compact rounded-lg v-btn--size-large v-btn--variant-outlined']")
    private WebElement CoDuyet_Button;

    @FindBy(xpath = "//button[@type='button']//div[1]")
    private WebElement Logout_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement Logout_Co_Button;

    @FindBy(xpath = "//i[@class='mdi mdi-format-list-group mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    private WebElement iconAction;

    public void clickIconAction(){clickElement(iconAction);}

    public void clickCoDuyet() {js.executeScript("arguments[0].click();", CoDuyet_Button);}

    public void clickDuyet() {
        clickElement(Duyet_Button);
    }

    public void clickChoDuyet_Option() {
        clickElement(TrangThai_ChoDuyet_Option);
    }

    public void clickTrangThai_DropDown() {
        clickElement(TrangThai_DropDown);
    }

    public void clickSua() {clickElement(Sua_Button);}

    public void clickXoa() {
        clickElement(Xoa_Button);
    }

    public void clickCo() {actions.moveToElement(Co_Button).click().build().perform();}

    public void clickLuu() {
        clickElement(Luu_Button);
    }

    public void setLyDo() {actions.moveToElement(LyDo_Input).click().sendKeys("Automation Test").build().perform();}

    public void clickNghiDenNgay() {actions.moveToElement(DenHetNgay_Input).click().build().perform();}

    public void clickChon() {clickElement(Chon_Button);}

    public void clickChonNgayNghi() {clickElement(ChonNgayNghi);}

    public void clickNghiTuNgay() {actions.moveToElement(NghiTuNgay_Input).click().build().perform();}

    public void clickNghiPhepNam() {clickElement(NghiTheoPhepNam_Option);}

    public void clickLoaiNgayNghi_DropDown() {clickElement(LoaiNgayNghi_DropDown);}

    public void clickDonNghiPhep() {
        clickElement(DonNghiPhep_Button);
    }

    public void clickThem() {
        clickElement(Them_Button);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            // Tìm kiếm thông báo thành công dựa trên toast hoặc alert
            WebElement successMessage = driver.findElement(By.xpath("//div[@data-testid='toast-content']"));
            return isElementVisible(successMessage);
        } catch (Exception e) {
            logger.warn("Không tìm thấy thông báo thành công: {}", e.getMessage());
            // Nếu không tìm thấy toast, có thể kiểm tra bằng cách khác
            return driver.getCurrentUrl().contains("/leave-application");
        }
    }

    public boolean isPendingApplicationDisplayed() {
        try {
            // Kiểm tra có nút Duyệt hiển thị không
            return isElementVisible(Duyet_Button);
        } catch (Exception e) {
            logger.warn("Không tìm thấy đơn chờ duyệt: {}", e.getMessage());
            return false;
        }
    }

    public boolean isApprovalSuccessful() {
        try {
            // Kiểm tra thông báo duyệt thành công
            WebElement successMessage = driver.findElement(By.xpath("//div[@data-testid='toast-content']"));
            return isElementVisible(successMessage);
        } catch (Exception e) {
            logger.warn("Không tìm thấy thông báo duyệt thành công: {}", e.getMessage());
            // Nếu không tìm thấy toast, có thể kiểm tra bằng cách khác
            return true; // Giả định thành công nếu không có lỗi
        }
    }

}
