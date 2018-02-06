package framework.stepDefinitions;

import cucumber.api.java.en.Given;
import framework.pageObjects.HomePage;

public class HomePageStepDefs {
    @Given("^Aliexpress home page is loaded$")
    public void loadHomePage(){
        new HomePage().loadPage();


    }


}
