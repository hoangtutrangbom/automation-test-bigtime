package page;
import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy(id = "input-0")
    private WebElement emailInput;

    @FindBy(id = "input-2")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void login(String email, String password) {
        try {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            submitButton.click();
            logger.info("Đăng nhập thành công với email: {}", email);
        } catch (Exception e) {
            logger.error("Lỗi khi đăng nhập: {}", e.getMessage());
            throw e;
        }
    }
}
