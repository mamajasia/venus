package framework.pageObjects;

import framework.utils.WebElementUtil;
import framework.utils.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.utils.WebElementUtil.getElementByLocator;
import static framework.utils.WebElementUtil.waitForElementToBeVisible;

public class HomePage {

    private String URL = "https://www.aliexpress.com/";

    private final By SEARCH_FIELD_LOCATOR = By.id("search-key");
    private final By RESULT_AREA_LOCATOR = By.id("main-wrap");

    public void loadPage(){
        WebDriver WD = WebdriverManager.getWebDriver();
        WD.get(URL);
    }

    public void typeInSearchFieldAndEnter(String text) {
        WebElement searchField = getElementByLocator(SEARCH_FIELD_LOCATOR);
        searchField.sendKeys(text + Keys.ENTER);
    }

    public boolean isResultAreaDisplayed() {
        waitForElementToBeVisible(RESULT_AREA_LOCATOR);
        WebElement resultArea = getElementByLocator(RESULT_AREA_LOCATOR);
        return resultArea.isDisplayed();
    }
}
