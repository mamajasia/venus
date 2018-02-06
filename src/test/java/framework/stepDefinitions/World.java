package framework.stepDefinitions;


import cucumber.api.java.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class World {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new NullPointerException("WebDriver has not been initiated");
        }
        else
            return webDriver;

    }

    @Test(expected = NullPointerException.class)
    public void testGetWebDriver(){
       World world = new World();
       world.getWebDriver();
    }

    @Test
    public void testGetWebDriverBasic(){
        World world = new World();
        world.browserSetup();
        WebDriver testWebDriver = world.getWebDriver();
        assert testWebDriver != null;
        testWebDriver.close();

    }

    @Before
    public void browserSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();
    }


}
