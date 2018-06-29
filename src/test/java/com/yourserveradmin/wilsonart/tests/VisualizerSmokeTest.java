package com.yourserveradmin.wilsonart.tests;

import com.yourserveradmin.wilsonart.appmanager.model.URLprovider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VisualizerSmokeTest extends BaseTest {

    @Test(dataProvider = "sites")
    public void sitesRespondingTest(String url) {
        app.visualiser().settingUpUrls(url);
        if (app.visualiser().isNotSettings()) {
            app.visualiser().openSite();
            app.visualiser().blackScreenRemove();
            app.visualiser().checkOpening();
        }
    }

    @DataProvider(name = "sites")
    public Object[] Industries() {
        Object[] urls = new URLprovider().getUrls();
        return urls;
    }

}
