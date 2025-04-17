package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DonNghiPhepPage extends BasePage {

    public DonNghiPhepPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    WebElement Them_Button;

    @FindBy(xpath = "//div[contains(text(),'Đơn nghỉ phép')]")
    WebElement DonNghiPhep_Button;

    public void clickDonNghiPhep() {
        clickElement(DonNghiPhep_Button);
    }

}
