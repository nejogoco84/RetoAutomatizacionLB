package co.com.reto.lulobank.taks;

import co.com.reto.lulobank.interactions.SendRequestDeleteWithParam;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.reto.lulobank.utils.Constant.SERVICE_DELETE;
import static co.com.reto.lulobank.utils.Constant.SERVICE_ENDPOINT;

public class DeleteEmploye implements Task {
    private final String id;

    public DeleteEmploye(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendRequestDeleteWithParam.toService(
                        SERVICE_ENDPOINT
                        , SERVICE_DELETE
                        , id)
        );
    }

    public static DeleteEmploye byId(String id) {
        return Tasks.instrumented(DeleteEmploye.class, id);
    }
}
