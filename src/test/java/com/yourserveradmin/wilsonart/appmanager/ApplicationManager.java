package com.yourserveradmin.wilsonart.appmanager;

import com.yourserveradmin.wilsonart.appmanager.helper.VisualiserHelper;
import com.yourserveradmin.wilsonart.appmanager.helper.SessionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {

    private SessionHelper sessionHelper;
    private VisualiserHelper visualiserHelper;
    protected WebDriver driver;
    protected String baseUrl;

    private final Properties properties;

    public ApplicationManager() {
        this.properties = new Properties();
        try {
            String propertyFile = System.getProperty("configFile", "src/main/resources/test.properties");
            properties.load(new FileReader(new File(propertyFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public SessionHelper session() {
        return sessionHelper;
    }

    public VisualiserHelper visualiser() {
        return visualiserHelper;
    }

    public void init(String browser) {

        if (browser.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
            driver = new ChromeDriver();
        } else if (browser.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
            driver = new FirefoxDriver();
        } else if (browser.equals(IE)) {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, System.getProperty("url"));
            caps.setCapability("ignoreZoomSetting", true);
            caps.setCapability("nativeEvents", false);
            caps.setCapability("unexpectedAlertBehaviour", "accept");
            caps.setCapability("ignoreProtectedModeSettings", true);
            caps.setCapability("disable-popup-blocking", true);
            caps.setCapability("enablePersistentHover", true);
            driver = new InternetExplorerDriver(caps);
        } else if (browser.equals(EDGE)) {
            System.setProperty("webdriver.edge.driver", properties.getProperty("edge.driver"));
            driver = new EdgeDriver();
        }

        baseUrl = properties.getProperty("url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        sessionHelper = new SessionHelper(driver);
        visualiserHelper = new VisualiserHelper(driver);
    }

    public String getAllInd() {
        return properties.getProperty("indLinksLive");
    }

    public String getAllUrls() {
        return properties.getProperty("urlsLive");
    }

    public void stop() {
        driver.quit();
    }

}
