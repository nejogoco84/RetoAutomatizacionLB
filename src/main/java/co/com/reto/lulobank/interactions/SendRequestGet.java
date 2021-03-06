package co.com.reto.lulobank.interactions;

import co.com.reto.lulobank.exceptions.MyBusinessException;
import co.com.reto.lulobank.utils.ExceptionMessages;
import co.com.reto.lulobank.utils.HelpFunctions;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestGet implements Interaction {
    HelpFunctions helpFunctions = new HelpFunctions();
    public final String endpoint;
    public final String service;

    public SendRequestGet(String endpoint, String service) {
        this.endpoint = endpoint;
        this.service = service;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.given()
                    .baseUri(endpoint)
                    .basePath(service)
                    .when()
                    .get();
            helpFunctions.saveInfoResponse(actor);

        } catch (Exception ex) {
            throw new MyBusinessException(String.format(ExceptionMessages.JSON_NOT_RESPONSE.getMessage(), service, ex));
        }
    }

    public static SendRequestGet toService(String endpoint, String service) {
        return Tasks.instrumented(SendRequestGet.class, endpoint, service);
    }
}