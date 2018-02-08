package framework.utils;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new NullPointerException("WebDriver has not been initiated");
        }
        else
            return webDriver;
    }

    @SuppressWarnings("all")
    @Test(expected = NullPointerException.class)
    public void testGetWebDriver(){
      WebdriverManager world = new WebdriverManager();
        world.getWebDriver();
    }

    @Test
    @SuppressWarnings("all")
    public void testGetWebDriverBasic(){
        WebdriverManager webdriverManager = new WebdriverManager();
        webdriverManager.init();
        WebDriver testWebDriver = webdriverManager.getWebDriver();
        Assert.assertNotNull(testWebDriver);
        testWebDriver.close();

    }
    public static void init(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    public static void dispose(){
        webDriver.quit();
    }
}
