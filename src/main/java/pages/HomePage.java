package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    /* Element Locators */
    By successMessage = By.xpath("//*[@class='flash success' and contains(.,'You logged into a secure area!')]");
    By invalidUsernameMessage = By.xpath("//*[@class='flash error' and contains(.,'Your username is invalid!')]");
    By invalidPasswordMessage = By.xpath("//*[@class='flash error' and contains(.,'Your password is invalid!')]");
    By logoutButton = By.xpath("//*[contains(@class, 'button') and contains(., 'Logout')]");


    public By getSuccessMessage() {
        return successMessage;
    }

    public By getInvalidUsernameMessage() {
        return invalidUsernameMessage;
    }

    public By getInvalidPasswordMessage() {
        return invalidPasswordMessage;
    }
}
