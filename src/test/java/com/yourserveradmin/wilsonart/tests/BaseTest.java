package com.yourserveradmin.wilsonart.tests;

import com.yourserveradmin.wilsonart.appmanager.ApplicationManager;
import com.yourserveradmin.wilsonart.appmanager.model.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BaseTest {
    private static Logger LOGGER = LogManager.getLogger(BaseTest.class.getName());
    protected static final ApplicationManager app = new ApplicationManager();

    Credentials credentials = new Credentials();

    @BeforeSuite
    @Parameters("browser")
    public void setUp(@Optional(CHROME) String browser) throws Exception {
                app.init(browser);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        LOGGER.info("Start test '" + m.getName() + "' with params " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        LOGGER.info("Stop test " + m.getName());
    }

    public void skippedTest() {
        LOGGER.info("Test skipped as redundant.");
        throw new SkipException("Test skipped as redundant.");
    }
}
