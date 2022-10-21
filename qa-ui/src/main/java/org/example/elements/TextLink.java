package org.example.elements;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextLink extends UIElement {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextLink.class);

    public TextLink(WebDriver driver, By by) {
        super(driver, by);
    }

    public TextLink(WebDriver driver, By by, String labelName) {
        super(driver, by, labelName);
    }

    public void click() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        getWebElement().click();
        LOGGER.info("Click on {} text link", labelName);
    }

    public String getValue() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        return getWebElement().getAttribute("textContent");
    }
}
