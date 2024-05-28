package e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import helper.ConfigurationReader;

import static helper.Driver.driver;

public class TestBase {

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }


   @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
