package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[normalize-space()='Quản lý']")
    private WebElement Admin_Button;

    @FindBy(xpath = "//h3[contains(text(),'Quản lý chấm công')]")
    private WebElement TimeKeepingManagement_Button;

    @FindBy(xpath = "//h3[contains(text(),'Lương')]")
    private  WebElement Salary_Button;

    @FindBy(xpath = "//h3[contains(text(),'Cài đặt')]")
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
