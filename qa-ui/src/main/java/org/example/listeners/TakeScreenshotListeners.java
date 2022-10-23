package org.example.listeners;

import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.util.logging.Logger;

public class TakeScreenshotListeners extends TestListenerAdapter {
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TakeScreenshotListeners.class);

    @Override
    public void onTestFailure(ITestResult tr) {

    }
}
