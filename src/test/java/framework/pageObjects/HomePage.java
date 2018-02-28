package framework.pageObjects;

import framework.utils.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static framework.utils.WebElementUtil.*;

public class HomePage {

    private String URL = "https://www.aliexpress.com/";

    private final By SEARCH_FIELD_LOCATOR = By.id("search-key");
    private final By RESULT_AREA_LOCATOR = By.id("main-wrap");
    private final By SEARCH_RESULT_LOCATOR = By.cssSelector("li.list-item a.product");

    public void loadPage() {
        WebDriver WD = WebdriverManager.getWebDriver();
        WD.get(URL);
    }

    public void typeInSearchField(String text) {
        WebElement searchField = getElementByLocator(SEARCH_FIELD_LOCATOR);
        searchField.sendKeys(text);
    }

    public void pressEnterOnSearchField() {
        WebElement searchField = getElementByLocator(SEARCH_FIELD_LOCATOR);
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isResultAreaDisplayed() {
        waitForElementToBeVisible(RESULT_AREA_LOCATOR);
        WebElement resultArea = getElementByLocator(RESULT_AREA_LOCATOR);
        return resultArea.isDisplayed();
    }

    public boolean isTextPresentInResult(String TextToBePresent) {
        TextToBePresent = TextToBePresent.toLowerCase();
        List<WebElement> searchResultLinksElementsList = getElementsByLocator(SEARCH_RESULT_LOCATOR);
        for (WebElement webElement : searchResultLinksElementsList) {
            boolean isTextPresentInLink = webElement.getAttribute("title").toLowerCase().contains(TextToBePresent);
            if (!isTextPresentInLink) {
                return false;
            }
        }
        return true;
    }
}
