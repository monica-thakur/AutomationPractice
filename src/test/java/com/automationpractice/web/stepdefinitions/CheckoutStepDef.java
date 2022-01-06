package com.automationpractice.web.stepdefinitions;

import com.automationpractice.web.helper.DriverProvider;
import com.automationpractice.web.pages.ProductCataloguePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CheckoutStepDef {

    private final ProductCataloguePage productCataloguePage;

    public CheckoutStepDef(){
        productCataloguePage = new ProductCataloguePage(DriverProvider.getDriver());
    }

    @Given("^user is at products page$")
    public void userIsAtProductsPage() {
        productCataloguePage.openProductsPage();
    }

    @Given("^verify user is at \"([^\"]*)\" page$")
    public void verifyUserIsAtPage(String page) throws Throwable {
        switch (page){
            case "sign-in":
                //verify current url is sign in
                productCataloguePage.verifySignInPage();
                break;
            default:
                throw new IllegalArgumentException("Unidentified page name");
        }

    }

    @And("^user navigates to \"([^\"]*)\" home category$")
    public void userNavigatesToHomeCategory(String category) throws Throwable {
        switch (category){
            case "Summer Dresses":
                // Navigate to summer dresses page
                productCataloguePage.navigateToSummerDresses();
                break;
            default:
                throw new IllegalArgumentException("Unidentified category name");
        }
    }

    @And("^user adds first item to cart$")
    public void userAddsFirstItemToCart() {
        // Add first item to cart
        productCataloguePage.addSampleItemToCart();
    }

    @And("^user checks out from \"([^\"]*)\" page$")
    public void userChecksOutFromPage(String pageName) throws Throwable {
        switch (pageName){
            case "home":
                //find and click check-out at home page
                productCataloguePage.clickOnProceedToCheckoutOnHomePage();
                break;
            case "order-summary":
                //find and click check-out at order summary page
                productCataloguePage.clickOnProceedToCheckoutOnSummaryPage();
                break;
            default:
                throw new IllegalArgumentException("Unidentified page name");
        }
    }

}

