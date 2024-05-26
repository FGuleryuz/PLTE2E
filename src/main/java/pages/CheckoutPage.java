package pages;

import utils.ConfigurationReader;
import utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static utils.Helper.*;

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
        //I planed to use configuration reader to avoid hard coding but It is not working
        //Assert.assertTrue(driver.getCurrentUrl(ConfigurationReader.getProperty("checkoutVerification")));
        verifyURLContains("https://checkout.prettylittlething.com/");
        implicitWait(3);
        this.assertBagSubTotalIsDisplayed();
    }

    public void assertBagSubTotalIsDisplayed() {
        Assert.assertTrue(checkoutBagSubTotal.isDisplayed());
        this.assertGrandTotalIsDisplayed();
    }

    public void assertGrandTotalIsDisplayed() {
        Assert.assertTrue(checkoutBagGrandTotal.isDisplayed());
        this.login();
    }

    public void login() {
        Helper helper = new Helper(driver);
        helper.clickWithJS(emailField);
        //emailField.sendKeys(ConfigurationReader.getProperty("email"));Conf.reader is not working
        emailField.sendKeys("fatmaboohoo@gmail.com");
        helper.waitForClickability(continueBtn, 4);
        continueBtn.click();
        waitForVisibility(passwordField,3);
        Assert.assertTrue(passwordField.isDisplayed());
        //emailField.sendKeys(ConfigurationReader.getProperty("password"));Conf.reader is not working
        passwordField.sendKeys("BFg123456@");
        continueBtn.click();
        waitFor(7);
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
        Helper helper = new Helper(driver);
        waitFor(4);
        helper.scrollDown(backLink);
        this.selectCardPaymentMethod();

    }

    public void selectCardPaymentMethod() {
        paymentCard.click();
        Assert.assertTrue(paymentCard.isDisplayed());

    }


}