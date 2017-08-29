package com.viajala.definitions;

import com.viajala.steps.ViajalasFlightSearchSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class ViajalasFlightSearchDefinitions {

    @Steps
    private ViajalasFlightSearchSteps viajalasFlightSearchSteps;

    @Given("I am on viajala.com.co home's page")
    public void openPage(){
        viajalasFlightSearchSteps.openPage();
    }

    @When("I fill search fields $searchDataTable")
    public void fillSearchFields(ExamplesTable searchDataTable){
        viajalasFlightSearchSteps.fillSearchFields(searchDataTable);
    }

    @When("click on search button")
    public void searchFlight(){
        viajalasFlightSearchSteps.searchFlight();
    }

    @Then("system show a same city error notification below destiny field")
    public void verifySameCity(){
        viajalasFlightSearchSteps.verifySameCity();
    }

    @Then("system show a origin is empty error notification below origin field")
    public void verifyOnlyDestiny(){
        viajalasFlightSearchSteps.verifyOnlyDestiny();
    }

    @Then("system show a destiny is empty error notification below origin field")
    public void verifyOnlyOrigin(){
        viajalasFlightSearchSteps.verifyOnlyOrigin();
    }

}
