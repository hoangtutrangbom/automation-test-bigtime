package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Đăng xuất')]")
    private WebElement Logout_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement Logout_Co_Button;


    private void clickLogout() {
        clickElement(Logout_Button);
    }

    private void clickLogoutCo() {
        clickElementByJS(Logout_Co_Button);
    }

    public void Logout() {
        clickLogout();
        clickLogoutCo();
    }
}
