package framework.pageObjects;

import framework.utils.WebdriverManager;
import org.openqa.selenium.WebDriver;

public class HomePage {

    String URL = "https://www.aliexpress.com/";
    public void loadPage(){

        WebDriver WD = WebdriverManager.getWebDriver();
        WD.get(URL);
    }



}
