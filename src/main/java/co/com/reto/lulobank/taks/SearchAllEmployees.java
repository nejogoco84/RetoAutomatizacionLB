package co.com.reto.lulobank.taks;

import co.com.reto.lulobank.interactions.SendRequestGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.reto.lulobank.utils.Constant.SERVICE_ENDPOINT;
import static co.com.reto.lulobank.utils.Constant.SERVICE_GET;

public class SearchAllEmployees implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SendRequestGet.toService(SERVICE_ENDPOINT, SERVICE_GET)
        );
    }
    public static SearchAllEmployees ofTheList() {
        return Tasks.instrumented(SearchAllEmployees.class);
    }

}
