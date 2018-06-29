package com.yourserveradmin.wilsonart.appmanager.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private static Logger LOGGER = LogManager.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void type(WebElement inputField, String value) {
        inputField.click();
        inputField.clear();
        inputField.sendKeys(value);
    }

    protected  void click(WebElement button) {
        button.click();
    }

    protected void selectByValue(WebElement select, String value) {
        new Select(select).selectByValue(value);
    }

    protected void selectByText(WebElement select, String text) {
        new Select(select).selectByVisibleText(text);
    }

    protected void allertAccept() {
        driver.switchTo().alert().accept();
    }

    protected List<String> extractTextFromElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>(elements.size());
        for(WebElement el : elements)
            textList.add(el.getText().trim());
        return textList;
    }

    protected void waitForElement(WebElement element) throws TimeoutException{
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void siteCantBeReached(String url){
        LOGGER.error("Site " + url + " is not responding");
    }

    protected void elementNotFound(String element){
        LOGGER.error("Element " + element + " is not found");
    }
}
