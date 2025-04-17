package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoaiPhuCapPage extends BasePage {

    public LoaiPhuCapPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Loại phụ cấp')]")
    WebElement LoaiPhuCap_Button;

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    WebElement Them_Button;      //input[@id='input-182']

    @FindBy(xpath = "//form[@class = 'v-form mt-2']/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]")
    WebElement TenPhuCap_Input;

    @FindBy(xpath = "/html/body/div[2]/div[24]/div[2]/div/div[3]/form/div[1]/div[2]/div/div/div/div[4]/input")
    WebElement TienPhuCap_Input;

    @FindBy(xpath = "//body/div[2]/div[18]/div[2]/div[1]/div[3]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[3]/i[1]")
    WebElement Icon_GhiChu_Input;

    @FindBy(xpath = "//form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[4]/textarea[1]")
    WebElement GhiChu_Input;

    @FindBy(xpath = "//button[@type='submit']//span[@class='v-btn__content']")
    WebElement Luu_Button;

    @FindBy(xpath = "//tr[@id='row-0']//span[contains(text(),'Sửa')]")
    WebElement Sua_Button;

    @FindBy(xpath = "/html/body/div[2]/div[24]/div[2]/div/div[3]/form/div[1]/div[1]/div/div/div/div[4]/div/input")
    WebElement CapNhat_TenPhuCap_Input;

    @FindBy(xpath = "/html/body/div[2]/div[24]/div[2]/div/div[3]/form/div[1]/div[2]/div/div/div/div[4]/input")
    WebElement CapNhat_TienPhuCap_Input;

    @FindBy(xpath = "//*[@id=\"row-0\"]/td[7]/button[2]/span[3]/span")
    WebElement Xoa_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    WebElement Co_Button;


    public void clickLoaiPhuCap() {
        clickElement(LoaiPhuCap_Button);
    }

    public void clickThem() {
        clickElement(Them_Button);
    }

    public void clickTenPhuCap() {
        clickElement(TenPhuCap_Input);
    }

    public void sendKeysTenPhuCap() {
        setText(TenPhuCap_Input, "Testing tiền phụ cấp", false);
    }

    public void sendKeysTienPhuCap() {
        setText(TienPhuCap_Input, "300.000", false);
    }

    public void clickGhiChu() {
        clickElement(Icon_GhiChu_Input);
    }

    public void sendKeysGhiChu() {
        setText(GhiChu_Input, "This is automation test", false);
    }

    public void clickLuu() {
        clickElement(Luu_Button);
    }

    public void clickXoa() {
        clickElement(Xoa_Button);
    }

    public void clickCo() {
        clickElement(Co_Button);
    }

    public void clickSua() {
        clickElement(Sua_Button);
    }

    public void sendKeysCapNhatTenPhuCap() throws InterruptedException {
        clickElement(CapNhat_TenPhuCap_Input);
        Thread.sleep(2000);
        CapNhat_TenPhuCap_Input.clear();
        setText(CapNhat_TenPhuCap_Input, "Automation Update Ten Phu Cap", false);
    }

    public void sendKeysCapNhatTienPhuCap() {
        clickElement(CapNhat_TienPhuCap_Input);
        CapNhat_TienPhuCap_Input.clear();
        setText(CapNhat_TienPhuCap_Input, "300.000", false);
    }

    public void sendKeysCapNhatGhiChu() {
        setText(GhiChu_Input, "Automation Update Ghi Chu", false);
    }

}
