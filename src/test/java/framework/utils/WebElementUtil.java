package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementUtil {
    private static final int ELEMENT_VISIBLE_TIMEOUT_IN_S = 5;
    private static final int VERIFICATION_INTERVAL_IN_MS = 200;

    public static WebElement getElementByLocator(By locator) {
        return WebdriverManager.getWebDriver().findElement(locator);
    }

    public static List<WebElement> getElementsByLocator(By locator) {
        return WebdriverManager.getWebDriver().findElements(locator);
    }

    public static void waitForElementToBeVisible(By locator) {
        new WebDriverWait(WebdriverManager.getWebDriver(), ELEMENT_VISIBLE_TIMEOUT_IN_S, VERIFICATION_INTERVAL_IN_MS).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
