package org.example;

import org.example.browser.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//Test fraemwork
public class BaseTest {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new WebDriverFactory().getDriver();
        setWebDriver(driver);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().quit();
    }

    private void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getWebDriver() {
        return driverThreadLocal.get();
    }
}
