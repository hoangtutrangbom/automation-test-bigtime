package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;

    // Constructor để khởi tạo driver, wait, actions, jsExecutor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // ==== Selenium thường ====

    public void sendKeys(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public void setText(WebElement element, String value, boolean pressEnter) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        el.sendKeys(value);
        if (pressEnter) {
            el.sendKeys(Keys.ENTER);
        }
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean verifyUrl(String url) {
        return driver.getCurrentUrl().contains(url);
    }

    public boolean isElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    // ==== JavaScriptExecutor ====

    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementByJS(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void setInputValueByJS(WebElement element, String value) {
        jsExecutor.executeScript("arguments[0].value='" + value + "';", element);
    }


    public static void dismissChangePasswordPopup(WebDriver driver) {
        try {
            // Chờ popup hiển thị (tối đa 5 giây)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Tìm nút OK trong popup "Change your password"
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(), 'Change your password')]/ancestor::div[@role='dialog']//button[.='OK']")
            ));

            // Nhấn vào nút OK
            okButton.click();
            System.out.println("Popup 'Change your password' đã được xử lý.");
        } catch (TimeoutException e) {
            System.out.println("Không thấy popup 'Change your password'. Bỏ qua.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // ==== Actions ====

    public void hoverToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    public void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }
}
