package com.yourserveradmin.wilsonart.appmanager.Page.ProductPortal;


import com.yourserveradmin.wilsonart.appmanager.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "UserName")
    private WebElement usernameField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(css = "input[type='submit']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputUsername(String usernameValue){

        type(usernameField, usernameValue);
        return new LoginPage(driver);
    }

    public LoginPage inputPassword(String passwordValue){
        type(passwordField, passwordValue);
        return new LoginPage(driver);
    }

    public WelcomeLoggedInPage clickByLoginBtn(){
        click(loginBtn);
        return new WelcomeLoggedInPage(driver);
    }
}
