package com.automationpractice.web.base;

import org.openqa.selenium.WebDriver;

public class BasePage extends BaseActions {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}