package com.yourserveradmin.wilsonart.appmanager.model;

import java.util.ArrayList;
import java.util.List;

public class IndustryLinksData  {

    private List defIndustries = new ArrayList();
    private List defIndustriesResopal = new ArrayList();
    private List defIndustriesPolyrey = new ArrayList();
    private List defIndustriesThailand = new ArrayList();
    private List defIndustriesRalfWilson = new ArrayList();

    private final String defLang = "en";
    private final String resopalRegex = ".*resopal.*";
    private final String polyreyRegex = ".*polyrey.*";
    private final String thailandRegex = ".*thailand.*";
    private final String ralfWilsonRegex = ".*ralph-wilson.*";

    private final String defLangResopal = "de";
    private final String defLangPolyrey = "fr";
    private final String defLangThailand = "th";
    private final String defLangRalfWilson = "es-MX";


    private String previousUrlForScreen = "";
    private String baseUrl;
    private String language;
    private String industry;

    private int id;

    public String diacriticConvert(String word) {

        word = word.replaceAll("[\\xC0-\\xC6]", "A");
        word = word.replaceAll("[\\xE0-\\xE6]", "a");
        word = word.replaceAll("[\\xC8-\\xCB]", "E");
        word = word.replaceAll("[\\xE8-\\xEB]", "e");
        word = word.replaceAll("[\\xCC-\\xCF]", "I");
        word = word.replaceAll("[\\xEC-\\xEF]", "i");
        word = word.replaceAll("[\\xD2-\\xD6]", "O");
        word = word.replaceAll("[\\xF2-\\xF6]", "o");
        word = word.replaceAll("[\\xD9-\\xDC]", "U");
        word = word.replaceAll("[\\xF9-\\xFC]", "u");
        word = word.replaceAll("[\\xD1]", "N");
        word = word.replaceAll("[\\xF1]", "n");
        word = word.replaceAll("[\\xC7]", "C");
        word = word.replaceAll("[\\xE7]", "c");
        word = word.replaceAll("[\\xDD]", "Y");
        word = word.replaceAll("[\\xFD-\\xFF]", "y");
        return word;
    }

    public void addToDefaultIndustries(String industry){
        defIndustries.add(industry);
        System.out.println("Set default industryInTest: " + industry);
    }

    public void addToDefIndustriesDiffBU(String industry) {
        if (isResopalBU() && language.equalsIgnoreCase(defLangResopal)) {
            defIndustriesResopal.add(industry);
        } else if (isPolyreyBU() && language.equalsIgnoreCase(defLangPolyrey)) {
            defIndustriesPolyrey.add(industry);
        } else if (isThailandBU() && language.equalsIgnoreCase(defLangThailand)) {
            defIndustriesThailand.add(industry);
        } else if (isMexicoBU() && language.equalsIgnoreCase(defLangRalfWilson)) {
            defIndustriesRalfWilson.add(industry);
        }
    }

    public void serverSwitch (String server){
        System.out.println("Forwarding to " + server);
    }

    public String getDefIndustry() {
        return (String)defIndustries.get(id);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getIndustry() {
        return industry;
    }

    public int getId() {
        return id;
    }

    public String getDefLang(){return defLang;}

    public String getPreviousUrlForScreen() {
        return previousUrlForScreen;
    }

    public String getDefLangResopal() {
        return defLangResopal;
    }

    public String getDefLangPolyrey() {
        return defLangPolyrey;
    }

    public String getDefLangThailand() {
        return defLangThailand;
    }

    public String getDefLangRalfWilson() {
        return defLangRalfWilson;
    }


    public void setPreviousUrlForScreen( String industry) {
        previousUrlForScreen = industry;
    }

    public void setBaseUrl(String lang) {
        baseUrl = lang;
        System.out.println("Forwarding to " + lang);
    }

    public void setLang(String lang) {
        language = lang;
    }

    public void setIndustry (String industry) {
        this.industry = industry;
    }

    public void setID(int id) {
        this.id = id;
    }

    public boolean isResopalBU(){
        return baseUrl.matches(resopalRegex);
    }

    public boolean isPolyreyBU(){
        return baseUrl.matches(polyreyRegex);
    }

    public boolean isMexicoBU(){
        return baseUrl.matches(ralfWilsonRegex);
    }

    public boolean isThailandBU(){
        return baseUrl.matches(thailandRegex);
    }
    public String getDiffDefaultIndustry(){
        if (isResopalBU()){
            return (String) defIndustriesResopal.get(id);
        } else if (isPolyreyBU()){
            return (String) defIndustriesPolyrey.get(id);
        } else if (isThailandBU()) {
            return (String) defIndustriesThailand.get(id);
        } else{
            return (String) defIndustriesRalfWilson.get(id);
        }
    }

}
