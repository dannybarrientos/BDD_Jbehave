package com.viajala.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import java.util.Map;

@DefaultUrl("https://viajala.com.co/")
public class ViajalaHomePage extends PageObject {

    @FindBy(id = "origin-city")
    private WebElementFacade originField;

    @FindBy(id = "destination-city")
    private  WebElementFacade destinyField;

    @FindBy(id = "departure-date-show")
    private WebElementFacade departureDateField;

    @FindBy(id = "return-date-show")
    private WebElementFacade returnDateField;

    @FindBy(id = "buscar-button")
    private WebElementFacade searchButton;

    @FindBy(className = "tooltip")
    private WebElementFacade errorTooltip;

    public ViajalaHomePage (WebDriver driver){
        super(driver);
    }

    @WhenPageOpens
    public void waitUntilMainElementsAppears() {getDriver().manage().window().maximize();}

    public void fillSearchFields(ExamplesTable searchDataTable){
        Map<String, String> searchData = searchDataTable.getRow(0);
        clearFields();
        originField.waitUntilVisible().sendKeys(searchData.get("from"));
        destinyField.sendKeys(searchData.get("to"));
        departureDateField.click();
    }

    public void searchFlight(){
        searchButton.click();
    }

    public void verifySameCity(){
        String sameCityText = errorTooltip.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("El destino debe ser diferente del origen."));
    }

    public void verifyOnlyDestiny(){
        String sameCityText = errorTooltip.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("Ingrese un aeropuerto de origen."));
    }

    public void verifyOnlyOrigin(){
        String sameCityText = errorTooltip.getText();
        MatcherAssert.assertThat("User can't continue with the same city on origin and destiny fields",sameCityText.equals("Ingrese un aeropuerto de destino."));
    }

    private void clearFields(){
        originField.clear();
        destinyField.clear();
    }
}
