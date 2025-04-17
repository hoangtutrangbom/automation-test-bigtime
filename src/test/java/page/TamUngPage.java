package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TamUngPage extends BasePage {

    public TamUngPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[starts-with(text(),'Tạm ứng')]")
    WebElement TamUng_Button;


    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    WebElement Them_Button;

    @FindBy(xpath = "(//div[@class='v-field__input'])[4]")
    WebElement ChonNhanVien_Input;

    @FindBy(xpath = "//input[@type='text' and contains(@class, 'v-field__input') and @inputmode='decimal']")
    WebElement TienTamUng_Input;

    @FindBy(xpath = "//textarea[@class='v-field__input']")
    WebElement GhiChu_Input;

    @FindBy(xpath ="//button[@type='submit']")
    WebElement Luu_Button;


    public void clickTamUng() {
        clickElement(TamUng_Button);
    }
    public void clickThem() {
        clickElement(Them_Button);
    }

    public void clickChonNhanVien() {
        clickElement(ChonNhanVien_Input);
    }
    public void sendKeysChonNhanVien() {
        setText(ChonNhanVien_Input, "Nguyễn Văn Minh",false);
    }
    public void clickTienTamUng() {
        clickElement(TienTamUng_Input);
    }
    public void sendKeysTienTamUng() {
        setText(TienTamUng_Input, "1000000",false);
    }
    public void clickLuu() {
        clickElement(Luu_Button);
    }
    public void clickGhiChu() {
      clickElement(GhiChu_Input);
    }
    public void sendKeysGhiChu() {
        setText(GhiChu_Input, "Ghi chú",false);
    }
}
