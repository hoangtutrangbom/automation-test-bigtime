package page;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BangLuongPage extends BasePage {

    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BangLuongPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Bảng lương')]")
    WebElement BangLuong_Button;

    @FindBy(xpath = "//i[@class='mdi mdi-plus mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default']")
    WebElement ThemBangLuong_Button;

    @FindBy(xpath = "//div[@class='v-input v-input--horizontal v-input--center-affix v-input--density-compact v-theme--lightColor7 v-locale--is-ltr v-text-field custom-input']")
    WebElement TenBangLuong_Input;

    @FindBy(xpath = "//form/div[1]/div[1]/div/div[1]/div/div[3]/div/input")
    WebElement TenBangLuong_Input_2;

    @FindBy(xpath = "//input[@type='radio' and @aria-label='Hàng tháng']") //div[@class='v-col-md-4 v-col-12']//div[@class='v-selection-control__wrapper']
    WebElement Radio_CheckBox_HangThang;

    @FindBy(xpath = "//form/div[1]/div[3]/div/div/div/div[3]/div/input")
    WebElement ChonThang_DropDown;

    @FindBy(xpath = "//div[@class='v-list-item-title'][normalize-space()='1/4/2025 - 30/4/2025']")
    WebElement ChonThang_Option;

    @FindBy(xpath = "//div[@class='v-field v-field--appended v-field--center-affix v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//div[@class='v-field__input']")
    WebElement NhanVien_DropDown;

    @FindBy(xpath = "//div[@role='option']//div[@class='v-list-item-title']")
    WebElement NhanVien_Option;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    WebElement Luu_Button;

    @FindBy(xpath = "//button[@type='button']//div[1]")
    WebElement Logout_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    WebElement Logout_Co_Button;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//td[normalize-space()='BL000001']")
    WebElement bangLuongID;

    @FindBy(xpath = "//button[@class='v-btn v-theme--lightColor7 bg-success v-btn--density-default rounded-lg v-btn--size-small v-btn--variant-flat mr-2']//span[@class='v-btn__content']")
    WebElement XemBangLuong_Button;

    @FindBy(xpath = "//button[@class='v-btn v-theme--lightColor7 bg-purple v-btn--density-default rounded-lg v-btn--size-small v-btn--variant-flat ml-1 text-end']//span[@class='v-btn__content']")
    WebElement GuiTatCa_Button;

    @FindBy(xpath = "//span[.='Xác nhận']")
    WebElement XacNhan_Button;

    @FindBy(xpath = "//textarea[@class='v-field__input']")
    WebElement GhiChu_Input;


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

        js.executeScript("arguments[0].click();", Radio_CheckBox_HangThang);

    }

    public void clickDropDownChonThang() {

        js.executeScript("arguments[0].click();", ChonThang_DropDown);

        actions.moveToElement(ChonThang_DropDown).click().perform();
    }

    public void clickChonThangOption() {
        clickElement(ChonThang_Option);
    }

    public void click_sendkeys_DropDownNhanVien() {
        actions.moveToElement(NhanVien_DropDown).click().sendKeys("Nguyễn Văn Minh").build().perform();
    }

    public void clickNhanVienOption() {
        actions.moveToElement(NhanVien_Option).click().build().perform();
    }

    public void clickLuu() {
        clickElement(Luu_Button);
    }

    public void clickLogout() {
        clickElement(Logout_Button);
    }

    public void clickLogoutCo() {
        clickElement(Logout_Co_Button);
    }

    public void clickBangLuongID() {
        clickElement(bangLuongID);
    }

    public void clickXemBangLuong() {
        js.executeScript("arguments[0].click();", XemBangLuong_Button);
    }

    public void clickGuiTatCa() {
        clickElement(GuiTatCa_Button);
    }

    public void clickXacNhan() {
        js.executeScript("arguments[0].click();", XacNhan_Button);
    }
    public void setGhiChu() {
        actions.moveToElement(GhiChu_Input).click().sendKeys("Automation test").build().perform();
    }
}
