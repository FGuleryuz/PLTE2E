package pages;

import helper.ConfigurationReader;
import helper.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static helper.Utility.*;


public class CheckoutPage extends BasePage {

    public WebDriver driver;

    @FindBy(id = "customer-email")
    public WebElement emailField;

    @FindBy(id = "customer-password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[contains(text(),'Clothes Size')]")
    public WebElement checkoutBagSize;

    @FindBy(className = "bag-item__name")
    public WebElement checkoutBagName;

    @FindBy(xpath = "//*[contains(text(),'Subtotal')]")
    public WebElement checkoutBagSubTotal;

    @FindBy(xpath = "//*[contains(text(),'Saver Delivery')]")
    public WebElement checkoutBagDeliveryTotal;

    @FindBy(xpath = "//*[contains(text(),'Grand total')]")
    public WebElement checkoutBagGrandTotal;

    @FindBy(id = "worldpay-container")
    public WebElement paymentCard;

    @FindBy(xpath = "//span[.='<< Back'] ")
    public WebElement backLink;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

    }

    public void checkoutPageIsDisplayed() {
        verifyURLContains("https://checkout.prettylittlething.com/");
        waitFor(4);
        this.assertBagSubTotalIsDisplayed();
    }

    public void assertBagSubTotalIsDisplayed() {
        waitFor(4);
        Assert.assertTrue(checkoutBagSubTotal.isDisplayed());
        this.assertGrandTotalIsDisplayed();
    }
//
    public void assertGrandTotalIsDisplayed() {
        waitFor(4);
        Assert.assertTrue(checkoutBagGrandTotal.isDisplayed());
        this.login();
    }

    public void login() {
        Utility utility = new Utility(driver);
        waitFor(3);
        utility.clickWithJS(emailField);
        emailField.sendKeys(ConfigurationReader.getProperty("email"));
        utility.waitForClickability(continueBtn, 4).click();
        waitFor(5);
        Assert.assertTrue(passwordField.isDisplayed());
        utility.clickWithJS(passwordField);
        passwordField.sendKeys(ConfigurationReader.getProperty("password"));
        utility.waitForClickability(continueBtn, 5).click();
        waitFor(8);
        this.assertProductNameIsDisplayed();
    }

    public void assertProductNameIsDisplayed() {
        Assert.assertTrue(checkoutBagName.isDisplayed());
        this.assertProductSizeIsDisplayed();
    }

    public void assertProductSizeIsDisplayed() {
        Assert.assertTrue(checkoutBagSize.isDisplayed());
        this.assertDeliveryTotalIsDisplayed();
    }

    public void assertDeliveryTotalIsDisplayed() {
        Assert.assertTrue(checkoutBagDeliveryTotal.isDisplayed());
        this.scrollToPaymentSection();
    }

    public void scrollToPaymentSection() {
        Utility utility =new Utility(driver);
        waitFor(4);
        utility.scrollDown(backLink);
        this.selectCardPaymentMethod();

    }

    public void selectCardPaymentMethod() {
        paymentCard.click();
        Assert.assertTrue(paymentCard.isDisplayed());

    }


}
