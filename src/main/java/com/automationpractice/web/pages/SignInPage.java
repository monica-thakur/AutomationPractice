package com.automationpractice.web.pages;

import com.automationpractice.web.base.BasePage;
import com.automationpractice.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//button[@id='SubmitLogin']//span")
    WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifySignInPage() {
        checkIfTextIsExpected(signInButton, "Sign in");
        checkIfPageTitleContains(getPageTitle(),"Login - My Store");
    }
}
