package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestData {
    private static WebDriver driver;
    private WebDriverWait wait;

    public TestData(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    String url="https://www.prettylittlething.com/";
    String checkoutVerification="https://checkout.prettylittlething.com/";
    String email="fatmaboohoo@gmail.com";
    String password="BFg123456@";




}