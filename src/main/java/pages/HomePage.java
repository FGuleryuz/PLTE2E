package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static utils.Helper.verifyURLContains;
import static utils.Helper.waitFor;

public class HomePage extends BasePage {
    public WebDriver driver;

    @FindBy(xpath = "//ul[@id=\"frame-header-nav\"]/li")
    public List<WebElement> navigateBarProducts;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement AcceptCookiesButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        //TestData testData = new TestData(driver);
    }
    public void assertUrl() {
        verifyURLContains("https://www.prettylittlething.com/");
        this.acceptAllButton();
    }

    public void acceptAllButton() {
        waitFor(4);
        AcceptCookiesButton.click();

    }

}






