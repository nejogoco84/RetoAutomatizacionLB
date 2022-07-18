package co.com.reto.lulobank.utils;

import co.com.reto.lulobank.models.CreateEmployee;
import com.google.gson.Gson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;

import java.lang.reflect.Type;
import java.util.Map;

import static co.com.reto.lulobank.utils.Constant.JSON_RESPONSE;
import static co.com.reto.lulobank.utils.Constant.STATUS;

public class HelpFunctions{

    CreateEmployee createEmployee= new CreateEmployee();


       public CreateEmployee loadInfoCreateEmployee(Map<String, String> dataTable) {
           createEmployee.setName(dataTable.get("name"));
           createEmployee.setSalary(Float.valueOf(dataTable.get("salary")));
           createEmployee.setAge(Integer.valueOf(dataTable.get("age")));
        return createEmployee;
    }

    public <T> T loadJsonToObject(String jsonResponse, Type nameClass) {
        Gson gson = new Gson();
       return gson.fromJson(jsonResponse, nameClass);
    }

    public  <T extends Actor> void saveInfoResponse(T actor) {
        actor.remember(STATUS, SerenityRest.lastResponse().statusCode());
        actor.remember(JSON_RESPONSE, SerenityRest.lastResponse().jsonPath().prettify());
    }
}