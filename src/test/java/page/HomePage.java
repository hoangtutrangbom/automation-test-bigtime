package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Quản lý']")
    private WebElement Admin_Button;

    @FindBy(xpath = "//span[normalize-space()='Quản lý chấm công']")
    private WebElement TimeKeepingManagement_Button;

    @FindBy(xpath = "//span[normalize-space()='Lương']")
    private  WebElement Salary_Button;

    @FindBy(xpath = "//span[normalize-space()='Cài đặt']")
    private  WebElement Setting_Button;

    public void clickAdmin() {
        clickElementByJS(Admin_Button);
    }

    public void clickTimeKeepingManagement() {
        clickElement(TimeKeepingManagement_Button);
    }

    public void clickSalary() {
        clickElement(Salary_Button);
    }

    public void clickSetting() {
        clickElement(Setting_Button);
    }
}
