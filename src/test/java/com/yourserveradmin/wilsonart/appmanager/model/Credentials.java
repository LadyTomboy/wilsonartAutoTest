package com.yourserveradmin.wilsonart.appmanager.model;

import com.yourserveradmin.wilsonart.appmanager.ApplicationManager;

public class Credentials {

    protected static final ApplicationManager app = new ApplicationManager();

    private String login;
    private String password;


    public String userNameProductPortal() {
        this.login = app.getProperties().getProperty("userNameProductPortal");
        return login;
    }

    public String passwordProductPortal() {
        this.password = app.getProperties().getProperty("passwordProductPortal");
        return password;
    }
}
