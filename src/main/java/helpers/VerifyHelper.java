package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyHelper {





    /**
     * Hàm verify nội dung và trạng thái hiển thị của thông báo thành công (toast)
     *
     * @param driver       WebDriver đang sử dụng
     * @param element      WebElement chứa thông báo (ví dụ //div[@data-testid='toast-content'])
     * @param expectedText Nội dung mong đợi, ví dụ "Xóa thành công"
     * @return true nếu toast hiển thị và đúng text, false nếu timeout hoặc text khác
     */
    public static boolean verifySuccessMessageDisplayed(WebDriver driver,
                                                        WebElement element,
                                                        String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            String actualText = element.getText().trim();
            return actualText.equals(expectedText);
        } catch (Exception e) {
            return false;
        }
    }

    // Hàm verify nội dung và trạng thái hiển thị của thông báo lỗi
    public static boolean verifyErrorMessageDisplayed(WebDriver driver, WebElement element, String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            String actualText = element.getText().trim();
            return actualText.equals(expectedText);
        } catch (Exception e) {
            return false;
        }
    }
}
