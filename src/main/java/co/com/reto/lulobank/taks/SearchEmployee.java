package co.com.reto.lulobank.taks;

import co.com.reto.lulobank.interactions.SendRequestGetWithParam;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.reto.lulobank.utils.Constant.SERVICE_ENDPOINT;
import static co.com.reto.lulobank.utils.Constant.SERVICE_GET_WITH_PARAM;

public class SearchEmployee implements Task {

    private final String id;

    public SearchEmployee(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendRequestGetWithParam.toService(
                        SERVICE_ENDPOINT
                        , SERVICE_GET_WITH_PARAM
                        , id));
    }

    public static SearchEmployee byId(String id) {
        return Tasks.instrumented(SearchEmployee.class, id);
    }
}
