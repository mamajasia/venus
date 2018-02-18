package framework.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.pageObjects.HomePage;
import org.junit.Assert;

public class HomePageStepDefs {
    @Given("^Aliexpress home page is loaded$")
    public void loadHomePage() {
        new HomePage().loadPage();
    }

    @When("^\"(.*)\" phrase is entered in search field$")
    public void searchWithPhrase(String text) {
        new HomePage().typeInSearchField(text);
    }

    @And("^enter key is pressed$")
    public void pressEnter() {
        new HomePage().pressEnterOnSearchField();
    }


    @Then("^search result list is displayed$")
    public void isSearchResultListDisplayed() {
        Assert.assertTrue(new HomePage().isResultAreaDisplayed());
    }

    @And("^all results on page contain \"(.+)\" phrase$")
    public void isSearchedPhrasePresentInAllResults(String text) {Assert.assertTrue(new HomePage().isTextPresentInResult(text));}
}
