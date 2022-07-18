package co.com.reto.lulobank.taks;

import co.com.reto.lulobank.interactions.SendRequestPost;
import co.com.reto.lulobank.models.CreateEmployee;
import com.google.gson.Gson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.reto.lulobank.utils.Constant.SERVICE_ENDPOINT;
import static co.com.reto.lulobank.utils.Constant.SERVICE_POST;

public class CreateANewEmployee implements Task {

    private final CreateEmployee createEmployee;

    public CreateANewEmployee(CreateEmployee createEmployee) {
        this.createEmployee = createEmployee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        String request = gson.toJson(createEmployee);
        actor.attemptsTo(
                SendRequestPost.toService(SERVICE_ENDPOINT
                        , SERVICE_POST
                        , request));
    }

    public static CreateANewEmployee withNextInfo(CreateEmployee createEmployee) {
        return Tasks.instrumented(CreateANewEmployee.class, createEmployee);
    }
}
