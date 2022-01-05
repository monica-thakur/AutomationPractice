package com.automationpractice.web.pages;

import com.automationpractice.web.base.BasePage;
import com.automationpractice.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCataloguePage extends BasePage {

    @FindBy(xpath = "//a[@title='Proceed to checkout']//span")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span")
    WebElement proceedToCheckoutOnSummaryPage;

    @FindBy(xpath = "//div[@class='columns-container']//li[1]//span[1]")
    WebElement summaryTextHeader;

    @FindBy(xpath = "//button[@id='SubmitLogin']//span")
    WebElement signInButton;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    WebElement dressesTab;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]")
    WebElement summerDressesTab;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement sampleProduct;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]")
    WebElement sampleProductAddToCartButton;

    public ProductCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openProductsPage() {
        goToWeb(PropertiesProvider.getProperties().getProperty("url"));
        waitUntilUrlContains("index.php");
    }

    public void clickOnProceedToCheckoutOnHomePage() {
        waitUntilLocatorIsVisible(proceedToCheckout, 5);
        moveToElement(proceedToCheckout);
        clickOn(proceedToCheckout);
    }

    public void clickOnProceedToCheckoutOnSummaryPage() {
        waitUntilLocatorIsVisible(summaryTextHeader, 5);
        clickOn(proceedToCheckoutOnSummaryPage);
        waitUntilLocatorIsVisible(signInButton, 5);
    }

    public void navigateToSummerDresses() {
        moveToElement(dressesTab);
        clickOn(summerDressesTab);
        waitUntilUrlContains("id_category=11&controller=category");
    }

    public void addSampleItemToCart() {
        moveToElement(sampleProduct);
        waitUntilLocatorIsVisible(sampleProductAddToCartButton, 5);
        moveToElement(sampleProductAddToCartButton);
        clickOn(sampleProductAddToCartButton);
    }

    public void verifySignInPage() {

    }
}
