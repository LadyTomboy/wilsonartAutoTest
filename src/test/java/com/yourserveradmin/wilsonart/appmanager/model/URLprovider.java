package com.yourserveradmin.wilsonart.appmanager.model;

import com.yourserveradmin.wilsonart.appmanager.ApplicationManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class URLprovider {

    protected static final ApplicationManager app = new ApplicationManager();

    public Object[][] getIndustries() {
        Object[][] industriesArray = null;
        File file = new File(app.getAllInd());

        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            industriesArray = new Object[(sheet.getLastRowNum() + 1) * 7][];
            int arrId = 0;
            for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                XSSFRow row = sheet.getRow(r);
                for (int c = 1; c <= 7; c++) {
                    String lang = row.getCell(0).getStringCellValue();
                    String ind = row.getCell(c).getStringCellValue();
                    Object[] industries = {lang, ind, c - 1};
                    industriesArray[arrId] = industries;
                    arrId++;
                    if (lang.matches(".* Server") || lang.matches("http://.*") || lang.matches("https://.*")) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return industriesArray;
    }

    public Object[] getUrls() {

        String[] allUrls = null;
        String url = "";
        File file = new File(app.getAllUrls());

        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            String[] allUrlsInner = new String[sheet.getLastRowNum()+1];
            for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                XSSFRow row = sheet.getRow(r);
                    url = row.getCell(0).getStringCellValue();
                allUrlsInner[r] = url;
                allUrls = allUrlsInner;
                }
            }
         catch (Exception e) {
            e.printStackTrace();
        }
        return allUrls;
    }
}
