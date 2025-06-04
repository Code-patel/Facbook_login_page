package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("pass");
    private final By loginButton = By.name("login");

    public void setEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorPresent() {
        return driver.getPageSource().contains("The email or mobile number you entered isn’t connected");
    }

    public boolean isLoginPageLoaded() {
        return driver.findElement(loginButton).isDisplayed();
    }
}

