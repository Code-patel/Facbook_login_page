package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
