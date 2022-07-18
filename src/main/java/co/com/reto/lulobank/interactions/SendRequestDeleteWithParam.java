package co.com.reto.lulobank.interactions;

import co.com.reto.lulobank.exceptions.MyBusinessException;
import co.com.reto.lulobank.utils.ExceptionMessages;
import co.com.reto.lulobank.utils.HelpFunctions;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static co.com.reto.lulobank.utils.Constant.EMPLOYEE_ID;

public class SendRequestDeleteWithParam extends SendRequestGet implements Interaction {
    HelpFunctions helpFunctions = new HelpFunctions();

    private final String param;

    public SendRequestDeleteWithParam(String endpoint, String service, String param) {
        super(endpoint, service);
        this.param = param;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.given()
                    .baseUri(endpoint)
                    .basePath(service)
                    .pathParam(EMPLOYEE_ID, param)
                    .when().delete();
            helpFunctions.saveInfoResponse(actor);
        } catch (Exception ex) {
            throw new MyBusinessException(String.format(ExceptionMessages.JSON_NOT_RESPONSE.getMessage(), service, ex));
        }

    }

    public static SendRequestDeleteWithParam toService(String endpoint, String service, String param) {
        return Tasks.instrumented(SendRequestDeleteWithParam.class, endpoint, service, param);
    }
}
