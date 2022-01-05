package com.automationpractice.web;

import com.automationpractice.web.helper.DriverProvider;
import com.automationpractice.web.helper.PropertiesProvider;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import java.io.IOException;


@CucumberOptions(features = {"src/test/java/com/automationpractice/web/features"})
public class TestRunner extends AbstractTestNGCucumberTests {
    private DriverProvider driverProvider;
    private PropertiesProvider propertiesProvider;
    @Before
    public void before(Scenario scenario) throws IOException {
        propertiesProvider = new PropertiesProvider();
        propertiesProvider.loadProperties();

        driverProvider = new DriverProvider();
        driverProvider.initDriver();
        DriverProvider.getDriver().manage().window().maximize();
    }

    @After
    public void after(Scenario scenario) {
        DriverProvider.getDriver().quit();
    }
}