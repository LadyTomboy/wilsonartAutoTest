package com.yourserveradmin.wilsonart.appmanager.Page.ProductPortal;

import com.yourserveradmin.wilsonart.appmanager.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(linkText = "Sign-in")
    private WebElement signInLink;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickBySignInLink() {
        click(signInLink);
        return new LoginPage(driver);
    }

}
