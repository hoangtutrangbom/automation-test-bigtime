package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DebtPage extends BasePage {

    public DebtPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[starts-with(text(),'Tạm ứng')]")
    private WebElement TamUng_Button;


    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement Them_Button;

    @FindBy(xpath = "(//div[@class='v-field__input'])[4]")
    private WebElement ChonNhanVien_Input;

    @FindBy(xpath = "//input[@type='text' and contains(@class, 'v-field__input') and @inputmode='decimal']")
    private  WebElement TienTamUng_Input;

    @FindBy(xpath = "//textarea[@class='v-field__input']")
    private WebElement GhiChu_Input;

    @FindBy(xpath ="//button[@type='submit']")
    private WebElement Luu_Button;


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
