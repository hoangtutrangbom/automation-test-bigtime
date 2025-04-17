package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DanhSachNhanVienPage extends BasePage {

    public DanhSachNhanVienPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Danh sách nhân viên')]")
    WebElement danhSachNhanVien_Button;



    public void clickDanhSachNhanVien() {
        clickElement(danhSachNhanVien_Button);
    }

}
