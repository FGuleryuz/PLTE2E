package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static utils.Helper.*;

public class PDPPage extends BasePage {
    public WebDriver driver;


    @FindBy(className = "overflow-hidden")
    public WebElement pdpPage;

    @FindBys(@FindBy(xpath = "//*[@class='flex items-center mb-2']//button"))
    public List<WebElement> selectSizeBtn;

    @FindBy(xpath = "//button[@id='add-to-bag-button']")
    public WebElement addToBagBtn;

    @FindBy(xpath = "//*[@data-testid='BASKET_COUNT']")
    public WebElement basketIcon;

    @FindBy(xpath = "//*[@id=\"pdp-name\"]")
    public WebElement productName;

    @FindBy(xpath = "//p[contains(@class, 'product-name')]")
    public WebElement cartProductName;

    @FindBy(xpath = "(//*[@data-testid=\"additional-product-info\"])[1]")
    public WebElement cartProductSize;

    @FindBy(xpath = "//*[@aria-label=Close]")
    public WebElement closeBtn;


    public PDPPage(WebDriver driver) {
        this.driver = driver;
    }


    public void pdpPageIsDisplayed() {
        productName.isDisplayed();
        pdpPage.isDisplayed();

        this.assertSelectedSizeButtonIsGrey();
    }

    public void assertSelectedSizeButtonIsGrey() {
        String backgroundColor = addToBagBtn.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(81, 81, 81, 1)";
        Assert.assertEquals(backgroundColor, expectedBackgroundColor, "The 'select size' button background color should be grey.");
    }
    public void assertProduct() {
        HomePage homePage = new HomePage(driver);
        waitFor(3);
        addToBagBtn.click();
        explicitWait(4);
        String itemCount = basketIcon.getText();
        int count = Integer.parseInt(itemCount);
        Assert.assertNotEquals(count, 0, "Value should not be 0");
        String pdpPageName = productName.getText();
        waitFor(2);
        System.out.println("selectedItem = " + selectedItem);
        hover(basketIcon);
        String cartPageName = cartProductName.getText();
        String cartSizeNumber = cartProductSize.getText();
        System.out.println("cartSizeNumber = " + cartSizeNumber);
        String[] partsSize = cartSizeNumber.split(" ");
        System.out.println("partsSize = " + Arrays.toString(partsSize));
        String cartSizeArray = partsSize[partsSize.length - 1];

        Assert.assertEquals(pdpPageName, cartPageName, "Productsizedoesnotmatch");
        Assert.assertEquals(selectedItem, cartSizeArray, "Productsizedoesnotmatch");
        basketIcon.click();
    }


}




