package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utils.Helper.waitFor;



public class BagPage extends BasePage {

    public WebDriver driver;

    @FindBy(id = "checkout-button-top")
    public WebElement proceedToCheckoutBtn;

    @FindBy(xpath  =" (//*[@class='flex lg:justify-end']//p)[2]")
    public WebElement bagPageSubTotal;


    public BagPage(WebDriver driver) {
        this.driver = driver;

    }

    public void proceedToCheckout() {
        waitFor(7);
        bagPageSubTotal.isDisplayed();
        proceedToCheckoutBtn.click();
        waitFor(10);

    }

}
