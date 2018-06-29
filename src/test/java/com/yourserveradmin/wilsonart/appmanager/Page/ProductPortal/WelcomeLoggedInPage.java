package com.yourserveradmin.wilsonart.appmanager.Page.ProductPortal;

import com.yourserveradmin.wilsonart.appmanager.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeLoggedInPage extends BasePage {

    @FindBy(css = "body > div > div > div:nth-child(1) > div > div.col-sm-6.col-lg-8.text-right.hidden-xs > div > span:nth-child(1) > a")
    private WebElement accountLink;

    public WelcomeLoggedInPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountLinkText() {
        final Wait<WebDriver> wait = new WebDriverWait(driver, 20, 1000);
        wait.until(ExpectedConditions.visibilityOf(accountLink));
        return accountLink.getText();
    }
}
