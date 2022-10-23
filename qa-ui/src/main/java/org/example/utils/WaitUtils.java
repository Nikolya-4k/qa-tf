package org.example.utils;

import org.awaitility.Awaitility;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUtils {

    public static void waitElementToDisappear(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProvider.DRIVER_WAIT_TIMEOUT));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(TimeoutException.class);
        wait.withMessage("Element is not visible");
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void waitUntilElementIsDisplayed(WebElement element) {
        Awaitility.await()
                .atMost(ConfigProvider.DRIVER_WAIT_TIMEOUT, TimeUnit.SECONDS)
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(element::isDisplayed);
    }
}
