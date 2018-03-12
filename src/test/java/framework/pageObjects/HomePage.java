package framework.pageObjects;

import framework.utils.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.utils.WebElementUtil.getElementByLocator;
import static framework.utils.WebElementUtil.waitForElementToBeVisible;

public class HomePage {

    private String URL = "https://www.aliexpress.com/";

    @FindBy(id = "search-key")
    private WebElement searchField;

    private final String RESULT_AREA_ID = "main-wrap";
    private final By RESULT_AREA_LOCATOR = By.id(RESULT_AREA_ID);
    @FindBy(id = RESULT_AREA_ID)
    private WebElement resultArea;

    public void loadPage(){
        WebDriver webDriver = WebdriverManager.getWebDriver();
        webDriver.get(URL);
    }

    public void typeInSearchField(String text) {
        searchField.sendKeys(text/* + Keys.ENTER*/);
    }

    public void pressEnterOnSearchField(){
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isResultAreaDisplayed() {
        waitForElementToBeVisible(RESULT_AREA_LOCATOR);
        return resultArea.isDisplayed();
    }
}