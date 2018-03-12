package framework.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.pageObjects.HomePage;
import framework.utils.WebdriverManager;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class HomePageStepDefs extends World{
    private final Class<HomePage> CURRENT_CLASS = HomePage.class;

    @Given("^Aliexpress home page is loaded$")
    public void loadHomePage() {
        HomePage page = PageFactory.initElements(WebdriverManager.getWebDriver(), CURRENT_CLASS);
        page.loadPage();
    }

    @When("^\"(.*)\" phrase is entered in search field$")
    public void searchWithPhrase(String text) {
        HomePage page = PageFactory.initElements(WebdriverManager.getWebDriver(), CURRENT_CLASS);
        page.typeInSearchField(text);
    }

    @And("^enter key is pressed$")
    public void pressEnter() {
        HomePage page = PageFactory.initElements(WebdriverManager.getWebDriver(), CURRENT_CLASS);
        page.pressEnterOnSearchField();
    }

    @Then("^search result list is displayed$")
    public void isSearchResultListDisplayed() {
        HomePage page = PageFactory.initElements(WebdriverManager.getWebDriver(), HomePage.class);
        Assert.assertTrue(page.isResultAreaDisplayed());
    }
}