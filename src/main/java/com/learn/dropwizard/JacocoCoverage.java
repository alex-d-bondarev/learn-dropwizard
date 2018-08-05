package com.learn.dropwizard;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Compare previous minimum jacoco coverage value with this build value.
 * Update minimum coverage value in case it was increased.
 *
 * This process is done in order to ensure that code test coverage is always increasing,
 * but not stuck on hardcoded level. For example:
 * 1. At project start code test coverage can be 10%;
 * 2. Once new tests are added it may be increased to 15%;
 * 3. When new feature is added it can miss new tests but still meet 10% level;
 * 4. Increasing minimum limit after step#2 will result in new tests within step#3.
 *
 */
public class JacocoCoverage {

    private String buildPropertiesPath = "./build.properties";
    private String buildPropertiesTemplate = "jacoco.test.instruction=%.2f";
    private String pathToJacocoHTML = "./target/jacoco-ut/index.html";
    private String totalCoverageTagCSSSelector = "tfoot > tr:first-child > td:first-child + td + td";

    private Optional<String> totalCoverage;

    public static void main(String args[]) {
       JacocoCoverage jc = new JacocoCoverage();
       jc.run();
    }

    private void run(){
        totalCoverage = getTotalCoverage();
        totalCoverage.ifPresent(this::saveNewProperty);
    }

    private void saveNewProperty(String total){
        String newProperty = prepareCoverageValue(total);

        try {
            FileOutputStream out = new FileOutputStream(buildPropertiesPath);
            out.write(newProperty.getBytes());
            out.close();
        }
        catch (IOException ex){
            System.out.println("Failed to save new property to " + buildPropertiesPath);
            ex.printStackTrace();
        }
    }

    private double convertCoverage(String totalCoverage){
        String onlyDigits = totalCoverage.replace("%", "");
        return Double.parseDouble(onlyDigits) / 100;
    }

    private String generateNewProperty(double coverage){
        return String.format(buildPropertiesTemplate, coverage);
    }

    private String prepareCoverageValue(String totalCoverage){
        String onlyDigits = totalCoverage.replace("%", "");
        double coverage = Double.parseDouble(onlyDigits) / 100;
        return String.format(buildPropertiesTemplate, coverage);
    }

    private Optional<String> getTotalCoverage(){
        try{
            String html = new String(Files.readAllBytes(Paths.get(pathToJacocoHTML)));
            Document doc = Jsoup.parse(html);
            Element tdWithTotal = doc.body().select(totalCoverageTagCSSSelector).first();
            return Optional.of(tdWithTotal.text());

        }
        catch(IOException ex) {
            System.out.println("Failed to open " + pathToJacocoHTML);
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
