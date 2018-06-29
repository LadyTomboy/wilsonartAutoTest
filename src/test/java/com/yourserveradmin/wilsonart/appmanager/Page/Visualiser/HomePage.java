package com.yourserveradmin.wilsonart.appmanager.Page.Visualiser;

import com.yourserveradmin.wilsonart.appmanager.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".gallery-home > .ng-scope > .container-fluid > .row > .scene-category > .item > .content > .gallery-icon-text-selected")
    private WebElement selectedIndustry;
    @FindBy(id = "homescreen-help-overlay-content")
    private WebElement blackHelpScreen;
    @FindBy(css = "#VisualizerCarousel > div > div.gallery-home.ng-scope > div > div.container-fluid.scene-categories > div > div > div > div > div.gallery-icon-text.ng-binding")
    private List<WebElement> displayedIndustries;
    @FindBy(css = "#ib-top > div.other-options > div.login-options.text-button.icon-tooltip.login-text-buttons.login-text-button-wide")
    private WebElement loginRegisterButton;
    @FindBy(css = ".logo > img")
    private WebElement logoIcon;
    @FindBy(css = ".slick-track div:nth-child(1) .carousel-padded-image-container")
    private WebElement firstScene;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getDisplayedIndustries() {
        return extractTextFromElements(displayedIndustries);
    }

    public String getSelectedIndustryText() {
        waitForElement(selectedIndustry);
        return selectedIndustry.getAttribute("textContent").trim();
    }

    public HomePage clickByBlackHelpScreen() {
        try {
            waitForElement(blackHelpScreen);
            new Actions(driver).moveByOffset(500, 500).click().build().perform();
        } catch (Exception e) {
            elementNotFound("Black Screen");
            Assert.fail();
        }
        return new HomePage(driver);
    }

    public HomePage goToSiteWithParams(String baseUrl, String lang, String ind) {
        try {
            driver.get(baseUrl + "?lang=" + lang + "&ind=" + ind);
        } catch (Exception e) {
            siteCantBeReached(baseUrl);
            Assert.fail();
        }
        return new HomePage(driver);
    }

    public HomePage goToSiteWithParams(String baseUrl, String ind) {
        try {
            driver.get(baseUrl + "?ind=" + ind);
        } catch (Exception e) {
            siteCantBeReached(baseUrl);
            Assert.fail();
        }
        return new HomePage(driver);
    }

    public HomePage goToSiteWithLang(String baseUrl, String lang) {
        try {
            driver.get(baseUrl + "?lang=" + lang);
        } catch (Exception e) {
            siteCantBeReached(baseUrl);
            Assert.fail();
        }
        return new HomePage(driver);
    }

    public HomePage openSite(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            siteCantBeReached(url);
            Assert.fail();
        }
        return new HomePage(driver);
    }

    public HomePage clickByLoginRegisterButton() {
        this.click(loginRegisterButton);
        return new HomePage(driver);
    }

    public HomePage clickByFirstScene() {
        waitForElement(firstScene);
        firstScene.click();
//        this.click(firstScene);
        return new HomePage(driver);
    }

    public HomePage waitForLogo() {
        try {
            waitForElement(logoIcon);
        } catch (Exception e) {
            elementNotFound("Logo Icon");
            Assert.fail();
        }
        return new HomePage(driver);
    }


}
