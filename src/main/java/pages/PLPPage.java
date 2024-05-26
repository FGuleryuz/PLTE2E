package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;


public class PLPPage extends BasePage {

    public WebDriver driver;

    @FindBy(className = "PLPCategory_plpPageContainer__YdR_v")
    public WebElement plpList;

    @FindBy(xpath = "//div[@id=\"products-list1\"]/a")
    public List<WebElement> products;


    public PLPPage(WebDriver driver) {
        this.driver = driver;

    }

    public void plpPageIsDisplayed() {
        Assert.assertTrue(plpList.isDisplayed());

    }
}




