package com.viajala.steps;

import com.viajala.pages.ViajalaHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import org.jbehave.core.model.ExamplesTable;

public class ViajalasFlightSearchSteps extends ScenarioSteps{

    @Page
    private ViajalaHomePage viajalaHomePage;

    @Step
    public void openPage(){
        viajalaHomePage.open();
    }

    @Step
    public void fillSearchFields(ExamplesTable searchDataTable){
        viajalaHomePage.fillSearchFields(searchDataTable);
    }

    @Step
    public void searchFlight(){
        viajalaHomePage.searchFlight();
    }

    @Step
    public void verifySameCity(){
        viajalaHomePage.verifySameCity();
    }

    @Step
    public void verifyOnlyDestiny(){
        viajalaHomePage.verifyOnlyDestiny();
    }

    @Step
    public void verifyOnlyOrigin(){
        viajalaHomePage.verifyOnlyOrigin();
    }
}
