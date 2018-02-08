package framework.stepDefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.utils.WebdriverManager;

public class World {

    @Before
    public void browserSetup() {
        WebdriverManager.init();
    }

    @After
    public void browserCleanup() {
        WebdriverManager.dispose();
    }
}
