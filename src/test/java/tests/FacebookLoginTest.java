package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import utils.DriverFactory;

public class FacebookLoginTest extends BaseTest {

    @Test
    public void TC01_validEmailValidPassword() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("sp6757168@gmail.com");
        page.setPassword("Smit@2004");
        page.clickLogin();
        Assert.assertFalse(page.isLoginErrorPresent());
    }

    @Test
    public void TC02_validEmailInvalidPassword() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("sp6757168@gmail.com");
        page.setPassword("Smit");
        page.clickLogin();
        Assert.assertTrue(page.isLoginErrorPresent());
    }

    @Test
    public void TC03_invalidEmailValidPassword() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("sp67.com");
        page.setPassword("smit@2004");
        page.clickLogin();
        Assert.assertTrue(page.isLoginErrorPresent());
    }

    @Test
    public void TC04_invalidEmailInvalidPassword() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("123@gggg");
        page.setPassword("svsvvhjs");
        page.clickLogin();
        Assert.assertTrue(page.isLoginErrorPresent());
    }

    @Test
    public void TC05_emptyEmailAndPassword() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("");
        page.setPassword("");
        page.clickLogin();
        Assert.assertTrue(page.isLoginErrorPresent());
    }

    @Test
    public void TC06_emptyEmail() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("");
        page.setPassword("somePassword");
        page.clickLogin();
        Assert.assertTrue(page.isLoginErrorPresent());
    }

    @Test
    public void TC07_emptyPassword() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        page.setEmail("valid@example.com");
        page.setPassword("");
        page.clickLogin();
        Assert.assertTrue(page.isLoginErrorPresent());
    }

    @Test
    public void TC08_loginPageLoads() {
        var driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com");
        var page = new LoginPage(driver);
        Assert.assertTrue(page.isLoginPageLoaded());
    }
}

