package co.com.reto.lulobank.stepsdefinitions;

import co.com.reto.lulobank.models.*;
import co.com.reto.lulobank.questions.*;
import co.com.reto.lulobank.taks.CreateANewEmployee;
import co.com.reto.lulobank.taks.DeleteEmploye;
import co.com.reto.lulobank.taks.SearchAllEmployees;
import co.com.reto.lulobank.taks.SearchEmployee;
import co.com.reto.lulobank.utils.HelpFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static co.com.reto.lulobank.utils.Constant.JSON_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeesStepDefinitions {
    ResponseAllEmployee responseAllEmployee= new ResponseAllEmployee();
    ResponseEmployeeId responseEmployeeId= new ResponseEmployeeId();
    HelpFunctions helpFunctions= new HelpFunctions();
    CreateEmployee createEmployee= new CreateEmployee();
    DeleteEmployeeResponse delete= new DeleteEmployeeResponse();

    ResponseEmployeeCreate responseEmployeeCreate= new ResponseEmployeeCreate();


    @When("the user search all employees")
    public void theUserSearchAllEmployees() {
        theActorInTheSpotlight().attemptsTo(SearchAllEmployees.ofTheList());
        responseAllEmployee = helpFunctions.loadJsonToObject(theActorInTheSpotlight().recall(JSON_RESPONSE),ResponseAllEmployee.class);
    }

  @Then("the list of employees is presented successfully")
    public void theListOfEmployeesIsSuccessfully() {
      theActorInTheSpotlight().should(
              seeThat(StatusCode.responseCode()),
                seeThat(AllEmployees.listedCorrectly(responseAllEmployee)));
    }

    @When("^the user searches the employee with (.*)$")
    public void theUserSearchesTheEmployeeWith(String id) {
       theActorInTheSpotlight().attemptsTo(SearchEmployee.byId(id));
       responseEmployeeId = helpFunctions.loadJsonToObject(theActorInTheSpotlight().recall(JSON_RESPONSE),ResponseEmployeeId.class);
    }

    @Then("^employee with (.*) is queried successfully$")
    public void employeeWithIdIsQueriedSuccessfully(int id) {
        theActorInTheSpotlight().should(
                seeThat(StatusCode.responseCode()),
                seeThat(TheEmployeeQuery.withId(id, responseEmployeeId)));
    }

    @When("^the user delete the employee with Id (.*)$")
    public void theUserDeleteTheEmployeeWithId(String employeeId) {
        theActorInTheSpotlight().attemptsTo(DeleteEmploye.byId(employeeId));
        delete = helpFunctions.loadJsonToObject(theActorInTheSpotlight().recall(JSON_RESPONSE), DeleteEmployeeResponse.class);
    }

    @Then("^the employee with id (.*) was successfully deleted$")
    public void informationDeleteReturnedBySystemSuccessfully(String id) {
        theActorInTheSpotlight().should(
                seeThat(StatusCode.responseCode()),
                seeThat(SuccessfullyDeleted.byId(id,delete)));
    }

    @When("the user creates a new employee")
    public void theUserCreatesNewEmployee(Map<String, String> dataTable) {
        createEmployee = helpFunctions.loadInfoCreateEmployee(dataTable);
        theActorInTheSpotlight().attemptsTo(
                CreateANewEmployee.withNextInfo(createEmployee));
        responseEmployeeCreate = helpFunctions.loadJsonToObject(theActorInTheSpotlight().recall(JSON_RESPONSE),ResponseEmployeeCreate.class);

    }

    @Then("^the creation of the new employee is successful$")
    public void theCreationOfTheNewEmployeeIsSuccessful() {
        theActorInTheSpotlight().should(
                seeThat(StatusCode.responseCode()),
                seeThat(TheSuccessOfThe.creationEmployee(createEmployee,responseEmployeeCreate)));
    }

}


