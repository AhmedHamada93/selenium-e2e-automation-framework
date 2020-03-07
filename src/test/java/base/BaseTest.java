package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static WebDriver webDriver;
    final static String baseUrl = "http://the-internet.herokuapp.com/";

    public WebDriver getDriver() {
        return webDriver;
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser(){
        webDriver.quit();
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

}
