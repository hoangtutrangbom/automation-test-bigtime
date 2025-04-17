package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;


    @Parameters("browser")
    @BeforeMethod
    public void setupChrome(@Optional("chrome") String browser) {
        driver = DriverFactory.getDriver(browser);

    }

    @AfterMethod
    public void teardown() {
//        DriverFactory.quitDriver();
    }
}