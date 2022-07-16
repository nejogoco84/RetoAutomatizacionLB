package co.com.reto.lulobank.stepsdefinitions;

import co.com.reto.lulobank.questions.AllEmployees;
import co.com.reto.lulobank.questions.StatusCode;
import co.com.reto.lulobank.taks.SearchAllEmployees;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeesStepDefinitions {

    @When("the user search all employees")
    public void theUserSearchAllEmployees() {
        theActorInTheSpotlight().attemptsTo(SearchAllEmployees.ofTheList());
    }

  @Then("the list of employees is presented successfully")
    public void theListOfEmployeesIsSuccessfully() {
      theActorInTheSpotlight().should(
              seeThat(StatusCode.responseCode()),
                seeThat(AllEmployees.listedCorrectly()));
    }
}


