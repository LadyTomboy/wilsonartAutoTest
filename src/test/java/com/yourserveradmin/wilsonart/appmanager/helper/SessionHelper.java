package com.yourserveradmin.wilsonart.appmanager.helper;

import com.yourserveradmin.wilsonart.appmanager.Page.ProductPortal.WelcomeLoggedInPage;
import com.yourserveradmin.wilsonart.appmanager.Page.ProductPortal.WelcomePage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver){
        this.driver = driver;
    }

    public void loginToProductPortal(String username, String password) {
        new WelcomePage(driver)
                .clickBySignInLink()
                .inputUsername(username)
                .inputPassword(password)
                .clickByLoginBtn();
    }

    public void checkUserName() {
        assertThat(new WelcomeLoggedInPage(driver)
                .getAccountLinkText(), equalTo("Hello Admin"));
    }
}
