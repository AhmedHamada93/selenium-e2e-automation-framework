package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import listeners.TestListener;

@Listeners({TestListener.class})
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    final static String validUserName = "tomsmith";
    final static String validPassword = "SuperSecretPassword!";

    @Severity(SeverityLevel.CRITICAL)
    @Test (description="Valid Login Scenario with valid username and password.")
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.goTo();
        loginPage.login(validUserName, validPassword);
        By successMessage = new HomePage(getWebDriver()).getSuccessMessage();
        Assert.assertNotEquals(getWebDriver().findElements(successMessage).size(), 0);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test (description="Invalid Login Scenario with invalid username.")
    public void testLoginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.goTo();
        loginPage.login("thisIsNotValidUsername", validPassword);
        By invalidUsernameMessage = new HomePage(getWebDriver()).getInvalidUsernameMessage();
        Assert.assertNotEquals(getWebDriver().findElements(invalidUsernameMessage).size(), 0);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test (description="Invalid Login Scenario without username.")
    public void testLoginWithoutUsername() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.goTo();
        loginPage.login("", validPassword);
        By invalidUsernameMessage = new HomePage(getWebDriver()).getInvalidUsernameMessage();
        Assert.assertNotEquals(getWebDriver().findElements(invalidUsernameMessage).size(), 0);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test (description="Invalid Login Scenario with invalid password.")
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.goTo();
        loginPage.login(validUserName, "thisIsNotValidPassword");
        By invalidPasswordMessage = new HomePage(getWebDriver()).getInvalidPasswordMessage();
        Assert.assertNotEquals(getWebDriver().findElements(invalidPasswordMessage).size(), 0);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test (description="Invalid Login Scenario without password.")
    public void testLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.goTo();
        loginPage.login(validUserName, "");
        By invalidPasswordMessage = new HomePage(getWebDriver()).getInvalidPasswordMessage();
        Assert.assertNotEquals(getWebDriver().findElements(invalidPasswordMessage).size(), 0);
    }

}
