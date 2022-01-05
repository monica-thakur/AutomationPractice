package com.automationpractice.web.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import static com.automationpractice.web.constants.BrowserConstants.*;

public class DriverProvider {

    private static WebDriver driver;

    public void initDriver(){
        if(driver == null){
            driver = createDriver(com.automationpractice.web.helper.PropertiesProvider.getProperties().getProperty("browser"));
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private WebDriver createDriver(String browserName) {
        switch (browserName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chOption = new ChromeOptions();
                driver = new ChromeDriver(chOption);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fxOption = new FirefoxOptions();
                driver = new FirefoxDriver(fxOption);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                throw new IllegalStateException("UNEXPECTED_VALUE" + browserName);
        }
        return driver;
    }
}
