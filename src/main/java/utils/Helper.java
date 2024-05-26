package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Helper {


    public static String selectedItem;

    private static WebDriver driver;
    private WebDriverWait wait;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public static void implicitWait(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    public static void explicitWait(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);

    }

    public static WebElement waitForVisibility(WebElement element, int timeoutInSecond) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeoutInSecond);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(expectedInURL));
    }

    public WebElement waitForClickability(WebElement element, int timeoutInSecond) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeoutInSecond);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitFor(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public void scrollDown(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static WebElement getRandomProduct(List<WebElement> product) {

        List<String> textList = new ArrayList<>();
        for (WebElement element : product) {
            textList.add(element.getText());
        }

        textList.removeIf(text -> text.equalsIgnoreCase("EDIT") ||
                text.equalsIgnoreCase("BEAUTY") || text.equalsIgnoreCase("ACCESSORIES & HOME")
                || text.equalsIgnoreCase("SHOES"));

        Random random = new Random();
        int index = random.nextInt(textList.size());
        selectedItem = product.get(index).getText();
        System.out.println(selectedItem);
        return product.get(index);
    }

}
