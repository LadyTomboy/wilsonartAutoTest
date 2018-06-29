package com.yourserveradmin.wilsonart.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test (enabled = false)
    public void loginCheck(){

        app.session()
                .loginToProductPortal(credentials.userNameProductPortal(), credentials.passwordProductPortal());
        app.session().checkUserName();
    }
}
