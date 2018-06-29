package com.yourserveradmin.wilsonart.appmanager.helper;

import com.yourserveradmin.wilsonart.appmanager.Page.Visualiser.HomePage;
import com.yourserveradmin.wilsonart.appmanager.model.IndustryLinksData;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VisualiserHelper {


    private WebDriver driver;
    private List<String> existingIndustryCache = null;
    private String langCache = "";

    private boolean isSettings = true;
    IndustryLinksData indData = new IndustryLinksData();

    public VisualiserHelper(WebDriver driver) {
        this.driver = driver;
    }



    public void settingUpDefaultsForIndustries(String lang, String ind, int id) {
        indData.setLang(lang);
        indData.setID(id);
        if (lang.equalsIgnoreCase("Default")) {
            indData.addToDefaultIndustries(ind);
            isSettings = true;
        }  else if (lang.matches(".* Server")) {
            indData.serverSwitch(lang);
            isSettings = true;
        } else if (lang.matches("http://.*") || lang.matches("https://.*")) {
            indData.setBaseUrl(lang);
            isSettings = true;
        } else {
            if(isDifferentBU()){
                indData.addToDefIndustriesDiffBU(ind);}
            indData.setIndustry(ind);
            isSettings = false;
        }
    }

    public boolean isNotSettings() {
        return !isSettings;
    }

    public void settingUpUrls(String url) {
        if (url.matches(".* Server")) {
            indData.serverSwitch(url);
            isSettings = true;
        } else if (url.matches("http://.*") || url.matches("https://.*")) {
            indData.setBaseUrl(url);
            isSettings = false;
        }
    }

    public boolean couldBeTested() {
        return (!isSettings && isExistingIndustry());
    }

    public boolean isExistingIndustry (){
        if (existIndustries().contains(industryInTest())){
            return true;
        } else {
            return false;
        }
    }

    private List<String> existIndustries(){

        if (!langCache.equals(language()) || isAnotherUrl()){
            existingIndustryCache = null;
            langCache = language();
        }
        if (existingIndustryCache != null)
            return existingIndustryCache;

        existingIndustryCache = new HomePage(driver)
                .goToSiteWithLang(url(), language())
                .getDisplayedIndustries();
        blackScreenRemove();
        return existingIndustryCache;
    }

    public void blackScreenRemove() {
        if (isAnotherUrl()) {
            indData.setPreviousUrlForScreen(indData.getBaseUrl());
            new HomePage(driver)
                    .clickByBlackHelpScreen();
        }
    }

    public boolean isAnotherUrl(){
        if (indData.getPreviousUrlForScreen().equalsIgnoreCase(indData.getBaseUrl())){
         return false;
        } else {
            return true;
        }

    }

    public void openSiteWithParamsDefault() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), industryInTest());
    }

    public void openSiteWithParamsInUpperCase() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), industryInTestInUpperCase());
    }

    public void openSiteWithParamsInLowerCase() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), industryInTestInLowerCase());
    }

    public void openSiteWithParamsNoSpaces() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeSpacesFrom(industryInTest()));
    }

    public void openSiteWithParamsInUpperCaseNoSpaces() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeSpacesFrom(industryInTestInUpperCase()));
    }

    public void openSiteWithParamsInLowerCaseNoSpaces() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeSpacesFrom(industryInTestInLowerCase()));
    }

    public void openSiteWithParamsNoDiacritic() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeDiacriticsFrom(industryInTest()));
    }

    public void openSiteWithParamsInUpperCaseNoDiacritic() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeDiacriticsFrom(industryInTestInUpperCase()));
    }

    public void openSiteWithParamsInLowerCaseNoDiacritic() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeDiacriticsFrom(industryInTestInLowerCase()));
    }

    public void openSiteWithParamsNoDiacriticNoSpaces() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeSpacesFrom(removeDiacriticsFrom(industryInTest())));
    }

    public void openSiteWithParamsInUpperCaseNoDiacriticNoSpaces() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeSpacesFrom(removeDiacriticsFrom(industryInTestInUpperCase())));
    }

    public void openSiteWithParamsInLowerCaseNoDiacriticNoSpaces() {
        new HomePage(driver)
                .goToSiteWithParams(url(), language(), removeSpacesFrom(removeDiacriticsFrom(industryInTestInLowerCase())));
    }




    public void openSiteWithParamsDefaultNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), industryInTest());
    }

    public void openSiteWithParamsInUpperCaseNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), industryInTestInUpperCase());
    }

    public void openSiteWithParamsInLowerCaseNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), industryInTestInLowerCase());
    }

    public void openSiteWithParamsNoSpacesNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeSpacesFrom(industryInTest()));
    }

    public void openSiteWithParamsInUpperCaseNoSpacesNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeSpacesFrom(industryInTestInUpperCase()));
    }

    public void openSiteWithParamsInLowerCaseNoSpacesNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeSpacesFrom(industryInTestInLowerCase()));
    }

    public void openSiteWithParamsNoDiacriticNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeDiacriticsFrom(industryInTest()));
    }

    public void openSiteWithParamsInUpperCaseNoDiacriticNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeDiacriticsFrom(industryInTestInUpperCase()));
    }

    public void openSiteWithParamsInLowerCaseNoDiacriticNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeDiacriticsFrom(industryInTestInLowerCase()));
    }

    public void openSiteWithParamsNoDiacriticNoSpacesNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeSpacesFrom(removeDiacriticsFrom(industryInTest())));
    }

    public void openSiteWithParamsInUpperCaseNoDiacriticNoSpacesNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeSpacesFrom(removeDiacriticsFrom(industryInTestInUpperCase())));
    }

    public void openSiteWithParamsInLowerCaseNoDiacriticNoSpacesNoLang() {
        new HomePage(driver)
                .goToSiteWithParams(url(), removeSpacesFrom(removeDiacriticsFrom(industryInTestInLowerCase())));
    }



    public void compareLinkWithSelectedInd() {
        assertThat(selectedIndustryOnSiteInUpperCase(), equalTo(industryInTestInUpperCase()));
    }

    public void compareLinkWithSelectedIndNoSpaces() {
        assertThat(removeSpacesFrom(selectedIndustryOnSiteInUpperCase()),
                equalTo(removeSpacesFrom(industryInTestInUpperCase())));
    }

    public void compareLinkWithSelectedIndNoDiacritic() {
        assertThat(removeDiacriticsFrom(selectedIndustryOnSiteInUpperCase()),
                equalTo(removeDiacriticsFrom(industryInTestInUpperCase())));
    }

    public void compareLinkWithSelectedIndNoDiacriticNoSpaces() {
        assertThat(removeSpacesFrom(removeDiacriticsFrom(selectedIndustryOnSiteInUpperCase())),
                equalTo(removeSpacesFrom(removeDiacriticsFrom(industryInTestInUpperCase()))));
    }



    public void compareLinkWithSelectedIndNoLang() {
        if (isDifferentBU()) {
            assertThat(selectedIndustryOnSiteInUpperCase(), equalTo(industryInTestInUpperCase(indData.getDiffDefaultIndustry())));
        } else {
            assertThat(selectedIndustryOnSiteInUpperCase(), equalTo(industryInTestInUpperCase(defIndustry())));
        }
    }

    public void compareLinkWithSelectedIndNoSpacesNoLang() {
        if (isDifferentBU()) {
            assertThat(removeSpacesFrom(selectedIndustryOnSiteInUpperCase()),
                    equalTo(removeSpacesFrom(industryInTestInUpperCase(indData.getDiffDefaultIndustry()))));
        } else {
            assertThat(removeSpacesFrom(selectedIndustryOnSiteInUpperCase()),
                    equalTo(removeSpacesFrom(industryInTestInUpperCase(defIndustry()))));
        }
    }

    public void compareLinkWithSelectedIndNoDiacriticNoLang() {
        if (isDifferentBU()) {
        assertThat(removeDiacriticsFrom(selectedIndustryOnSiteInUpperCase()),
                equalTo(removeDiacriticsFrom(industryInTestInUpperCase(indData.getDiffDefaultIndustry()))));
        } else {
            assertThat(removeDiacriticsFrom(selectedIndustryOnSiteInUpperCase()),
                    equalTo(removeDiacriticsFrom(industryInTestInUpperCase(defIndustry()))));
        }
    }

    public void compareLinkWithSelectedIndNoDiacriticNoSpacesNoLang() {
        if (isDifferentBU()) {
            assertThat(removeSpacesFrom(removeDiacriticsFrom(selectedIndustryOnSiteInUpperCase())),
                    equalTo(removeSpacesFrom(removeDiacriticsFrom(industryInTestInUpperCase(indData.getDiffDefaultIndustry())))));
        } else {
            assertThat(removeSpacesFrom(removeDiacriticsFrom(selectedIndustryOnSiteInUpperCase())),
                    equalTo(removeSpacesFrom(removeDiacriticsFrom(industryInTestInUpperCase(defIndustry())))));
        }
    }




    public String selectedIndustryOnSiteInUpperCase() {
        return new HomePage(driver)
                .getSelectedIndustryText()
                .trim()
                .toUpperCase();
    }


    public String industryInTestInUpperCase() {
        return industryInTest()
                .trim()
                .toUpperCase();
    }
    public String industryInTestInUpperCase(String ind) {
        return ind
                .trim()
                .toUpperCase();
    }
    public String industryInTestInLowerCase() {
        return industryInTest()
                .trim()
                .toLowerCase();
    }
//    public String industryInTestInLowerCase(String ind) {
//        return ind
//                .trim()
//                .toLowerCase();
//    }


    public boolean containsDiacritics() {
        return !industryInTest().equals(removeDiacriticsFrom(industryInTest()));
    }

    public String removeSpacesFrom(String ind) {
        return ind.replace(" ", "");
    }

    public String removeDiacriticsFrom(String ind) {
        return indData
                .diacriticConvert(ind);
    }

//    public boolean isDefaultLang() {
//       if (language().equalsIgnoreCase(defLanguage())) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean isDifferentBU(){
        if (indData.isResopalBU() || indData.isPolyreyBU() || indData.isThailandBU() || indData.isMexicoBU()){
            return true;
        } else {
            return false;
        }
    }


    public String url() {
        return indData.getBaseUrl();
    }

    public String language() {
        return indData.getLanguage();
    }

//    public String defLanguage() {
//        return indData.getDefLang();
//    }

    public String industryInTest() {
        return indData.getIndustry();
    }

    public String defIndustry() {
        return indData.getDefIndustry();
    }

    public void openSite() {
        new HomePage(driver)
                .openSite(url());
    }

    public void checkOpening(){
        new HomePage(driver)
                .waitForLogo();
    }
}
