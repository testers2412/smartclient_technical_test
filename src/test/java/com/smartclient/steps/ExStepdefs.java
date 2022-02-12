package com.smartclient.steps;

import com.smartclient.pages.FeaturedTileFilterPage;
import com.smartclient.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExStepdefs {
    @Given("^User is on the featured tile filtering page$")
    public void userIsOnTheFeaturedTileFilteringPage() {
        new HomePage().clickOnFeaturedTileFilter();
    }

    @When("^User set animal using letter \"([^\"]*)\"$")
    public void userSetAnimalUsingLetter(String letter)  {
        new FeaturedTileFilterPage().setAnimal(letter);

    }

    @And("^set max life span to 40")
    public void setMaxLifeSpanTo40() {
        new FeaturedTileFilterPage().moveMaxLifeSpanSlider(30,0);


    }

    @And("^sort order by \"([^\"]*)\"$")
    public void sortOrderBy(String sortBy)  {
        new FeaturedTileFilterPage().sortOrder(sortBy);

    }

    @And("^select checkbox to ascending$")
    public void selectCheckboxToAscending() {
        new FeaturedTileFilterPage().clickOnAscending();
    }

    @Then("^User assert that results contain more than (\\d+) items$")
    public void userAssertThatResultsContainMoreThanItems(int results) {
    }
}
