package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    /* APP Base URL */
    final static String loginUrl = "http://the-internet.herokuapp.com/login";

    /* Element Locators */
    By userNameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[contains(.,\"Login\")]");

    /**
     * Login Page constructor
     *
     * @param webDriver
     */
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Navigates to Login Page
     *
     * @return LoginPage
     */
    @Step("Navigate to login page.")
    public LoginPage goTo() {
        webDriver.get(loginUrl);
        return new LoginPage(webDriver);
    }

    /**
     * Set userName and Password fields then clicks on the login button
     *
     * @param userName
     * @param password
     */
    @Step("Login using specified credentials.")
    public void login(String userName, String password) {
        webDriver.findElement(userNameField).sendKeys(userName);
        webDriver.findElement(passwordField).sendKeys(password);
        webDriver.findElement(loginButton).click();
    }
}
