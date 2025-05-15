package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            WebDriver newDriver;

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();

                    // --- Tắt Google Password Manager ---
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    options.setExperimentalOption("prefs", prefs);

                    // --- Các flag để tránh popup & cảnh báo ---
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-save-password-bubble");

                    // --- Chạy chế độ khách để tránh login Google ---
                    options.addArguments("--guest");

                    newDriver = new ChromeDriver(options);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    newDriver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    newDriver = new FirefoxDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Browser không hỗ trợ: " + browser);
            }
            newDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            newDriver.manage().window().maximize();

            driver.set(newDriver);
        }
        return driver.get();
    }

    public static void quitDriver() throws InterruptedException {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
