package e2e;


import org.openqa.selenium.By;
import utils.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static utils.Helper.*;
import static utils.Driver.driver;

public class e2eTesting extends TestBase {


    private HomePage homePage;
    private PLPPage plpPage;
    private PDPPage pdpPage;
    private Helper helper;
    private BagPage bagPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
        plpPage = new PLPPage(driver);
        pdpPage = new PDPPage(driver);
        bagPage = new BagPage(driver);
        checkoutPage = new CheckoutPage(driver);
        helper = new Helper(driver);
    }

    @Test()
    public void selectRandomItem() {
        homePage.assertUrl();
        getRandomProduct(homePage.navigateBarProducts).click();
        waitFor(3);
        plpPage.plpPageIsDisplayed();
        getRandomProduct(plpPage.products).click();
        if(selectedItem.equals("https://www.prettylittlething.com/royalty")){
            pdpPage.closeBtn.click();
            waitFor(3);
            driver.navigate().back();
            getRandomProduct(plpPage.products).click();
       }
        waitFor(3);
        pdpPage.pdpPageIsDisplayed();
        getRandomProduct(pdpPage.selectSizeBtn).click();
        if (selectedItem.equals("One Size")) {
          pdpPage.closeBtn.click();
            driver.navigate().back();
            getRandomProduct(plpPage.products).click();
        }
        waitFor(5);
        pdpPage.assertProduct();
        bagPage.proceedToCheckout();
        waitFor(10);
        //checkoutPage.checkoutPageIsDisplayed();

    }
    @Test(dependsOnMethods ={"selectRandomItem"} )
    public void purchaseItem() {

        checkoutPage.checkoutPageIsDisplayed();
    }

}


