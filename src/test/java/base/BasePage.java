package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataGenerator;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    protected void waitForOverlayToDisappear() {
        try {
            WebElement overlay = driver.findElement(By.cssSelector(".v-overlay__scrim"));
            wait.until(ExpectedConditions.invisibilityOf(overlay));
        } catch (NoSuchElementException e) {
            // Overlay not present, can proceed
        }
    }

    // Cho phép tạo wait với timeout tuỳ chỉnh
    protected WebDriverWait getWait(int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // ========== Common Web Actions ==========

    public String getText(WebElement element) {
        String text = element.getText().trim();
        logger.info("Get text: \"{}\"", text);
        return text;
    }

    public void sendKeys(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public void sendKeys(WebElement element, String value, int timeout) {
        getWait(timeout).until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public void setText(WebElement element, String value, boolean pressEnter) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        el.sendKeys(value);
        if (pressEnter) {
            el.sendKeys(Keys.ENTER);
        }
    }

    public void clickElement(WebElement element) {
        try {
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            clickableElement.click();
            logger.info("Clicked on element successfully.");
        } catch (TimeoutException e) {
            logger.error("Timeout: Element not clickable within the wait time.", e);
            throw e;  // Thoát test và báo fail
        } catch (ElementClickInterceptedException e) {
            logger.error("Click intercepted: Element may be covered by another element.", e);
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error occurred while clicking element.", e);
            throw e;
        }
    }

    public boolean verifyUrl(String url) {
        boolean result = driver.getCurrentUrl().contains(url);
        logger.info("Verify URL contains '{}': {}", url, result);
        return result;
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            logger.warn("Element not visible: {}", e.getMessage());
            return false;
        }
    }

    public boolean safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            return true;
        } catch (Exception e) {
            logger.warn("Safe click failed: {}", e.getMessage());
            return false;
        }
    }

    protected String setRandomValue(WebElement element, String prefix) {
        // Sinh giá trị ngẫu nhiên
        String randomValue = DataGenerator.generateUniqueName(prefix);
        // Gán vào input
        setText(element, randomValue, false);
        return randomValue;
    }


    // ========== JavaScriptExecutor ==========

    public void scrollToElement(WebElement element, boolean center) {
        wait.until(ExpectedConditions.visibilityOf(element));
        if (center) {
            jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        } else {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    public void clickElementByJS(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            jsExecutor.executeScript("arguments[0].click();", element);
            logger.info("Clicked element using JS");
        } catch (Exception e) {
            logger.error("JS click failed: {}", e.getMessage());
            throw e;
        }
    }

    public void setInputValueByJS(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        jsExecutor.executeScript("arguments[0].value='" + value + "';", element);
        logger.info("Set input value by JS: {}", value);
    }

    public void scrollToElementAndClick(WebElement element) {
        try {
            scrollToElement(element, true);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Scrolled and clicked element");
        } catch (Exception e) {
            logger.error("Scroll & click failed: {}", e.getMessage());
            throw e;
        }
    }

    // ========== Actions ==========

    public void clickAction(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).click().build().perform();
        logger.info("Clicked using Actions");
    }

    public void clickAndSendKeysAction(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).click().sendKeys(value).build().perform();
        logger.info("Click and send keys using Actions: {}", value);
    }

    public void hoverToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
        logger.info("Hovered to element");
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
        logger.info("Dragged and dropped element");
    }

    public void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
        logger.info("Click and hold element");
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
        logger.info("Double-clicked element");
    }
}
