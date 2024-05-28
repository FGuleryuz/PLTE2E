package e2e;


import helper.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helper.Utility.getRandomProduct;
import static helper.Utility.waitFor;
import static helper.Driver.driver;

public class e2eTesting extends TestBase {


    private HomePage homePage;
    private PLPPage plpPage;
    private PDPPage pdpPage;
    private BagPage bagPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
        plpPage = new PLPPage(driver);
        pdpPage = new PDPPage(driver);
        bagPage = new BagPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test()
    public void purchaseItem() {
        homePage.assertUrl();
        getRandomProduct(homePage.navigateBarProducts).click();
        waitFor(3);
        plpPage.plpPageIsDisplayed();
        getRandomProduct(plpPage.products).click();
        waitFor(3);
        pdpPage.pdpPageIsDisplayed();
        getRandomProduct(pdpPage.selectSizeBtn).click();
        waitFor(5);
        pdpPage.assertProduct();
        bagPage.proceedToCheckout();
        waitFor(10);
        checkoutPage.checkoutPageIsDisplayed();

    }


}


