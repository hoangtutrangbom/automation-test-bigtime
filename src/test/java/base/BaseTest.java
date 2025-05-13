package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setupChrome(@Optional("chrome") String browser) {
        logger.info("Khởi tạo WebDriver cho trình duyệt: {}", browser);
        driver = DriverFactory.getDriver(browser);
        logger.info("WebDriver đã được khởi tạo thành công cho: {}", browser);
    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        logger.info("Đóng WebDriver");
//        DriverFactory.quitDriver();
    }
}
