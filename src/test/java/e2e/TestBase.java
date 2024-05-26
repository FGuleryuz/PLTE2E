package e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.Driver.driver;

public class TestBase {

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        //I planed to use configuration reader to avoid hard coding but It is not working
        //driver.get(ConfigurationReader.getProperty("url"));
        driver.get("https://www.prettylittlething.com/");
    }


//   @AfterMethod
//    public void tearDown(){
//        if(driver != null){
//            driver.quit();
//        }
   // }
}
