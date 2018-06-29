package com.yourserveradmin.wilsonart.tests;

import com.yourserveradmin.wilsonart.appmanager.model.URLprovider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkMeetsSelectedIndustryTest extends BaseTest {

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrl(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsDefault();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedInd();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCase(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCase();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedInd();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCase(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCase();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedInd();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoSpaces(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsNoSpaces();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoSpaces();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoSpaces(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoSpaces();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoSpaces();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoSpaces(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoSpaces();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoSpaces();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoDiacritic(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsNoDiacritic();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacritic();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoDiacritic(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoDiacritic();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacritic();
        } else {
            skippedTest();
        }
    }

    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoDiacritic(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoDiacritic();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacritic();
        } else {
            skippedTest();
        }
    }
    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoDiacriticNoSpace(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsNoDiacriticNoSpaces();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoSpaces();
        } else {
            skippedTest();
        }
    }
    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoDiacriticNoSpace(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoDiacriticNoSpaces();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoSpaces();
        } else {
            skippedTest();
        }
    }
    //++++
    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoDiacriticNoSpace(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoDiacriticNoSpaces();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoSpaces();
        } else {
            skippedTest();
        }
    }


    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsDefaultNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoLang (String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoSpacesNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsNoSpacesNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoSpacesNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoSpacesNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoSpacesNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoSpacesNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoSpacesNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoSpacesNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoSpacesNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoDiacriticNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsNoDiacriticNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoDiacriticNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoDiacriticNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoDiacriticNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoDiacriticNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlNoDiacriticNoSpaceNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsNoDiacriticNoSpacesNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoSpacesNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInUpperCaseNoDiacriticNoSpaceNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInUpperCaseNoDiacriticNoSpacesNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoSpacesNoLang();
        } else {
            skippedTest();
        }
    }

    @Test(dataProvider = "industries", enabled = false)
    public void selectedIndustryByUrlInLowerCaseNoDiacriticNoSpaceNoLang(String lang, String testIndustry, int id) {
        app.visualiser().settingUpDefaultsForIndustries(lang, testIndustry, id);
        if (app.visualiser().containsDiacritics() && testIndustry.contains(" ") && app.visualiser().couldBeTested()) {
            app.visualiser().openSiteWithParamsInLowerCaseNoDiacriticNoSpacesNoLang();
//            app.visualiser().blackScreenRemove();
            app.visualiser().compareLinkWithSelectedIndNoDiacriticNoSpacesNoLang();
        } else {
            skippedTest();
        }
    }


    @DataProvider(name = "industries")
    public Object[][] Industries() {
        Object[][] industries = new URLprovider().getIndustries();
        return industries;
    }
}