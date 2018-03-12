package framework.stepDefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.utils.WebdriverManager;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

public class World {
    private Map<String, Object> savedAssets = new HashMap<>();

    @Before
    public void browserSetup() {
        WebdriverManager.init();
    }

    @After
    public void browserCleanup() {
        WebdriverManager.dispose();
    }

    protected Object getAsset(String key) {
        if (key == null || key.equals("")) {
            fail("The asset's key can't be empty!");
        }
        return savedAssets.get(key);
    }

    protected void saveAsset(String key, Object asset) {
        validateAssetKey(key);
        savedAssets.put(key, asset);
    }

    private void validateAssetKey(String key) {
        if (key == null || key.equals("")) {
            Assert.fail("The asset's key can't be empty");
        }
    }
}