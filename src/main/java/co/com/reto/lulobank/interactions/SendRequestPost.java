package co.com.reto.lulobank.interactions;

import co.com.reto.lulobank.exceptions.MyBusinessException;
import co.com.reto.lulobank.utils.Constant;
import co.com.reto.lulobank.utils.ExceptionMessages;
import co.com.reto.lulobank.utils.HelpFunctions;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestPost extends SendRequestGet implements Interaction {
    HelpFunctions helpFunctions = new HelpFunctions();

    private final String information;

    public SendRequestPost(String endpoint, String service, String information) {
        super(endpoint, service);
        this.information = information;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            SerenityRest.given().contentType(Constant.APPLICATION_JSON)
                    .baseUri(endpoint)
                    .basePath(service)
                    .body(information)
                    .when().post();
            helpFunctions.saveInfoResponse(actor);

        } catch (Exception ex) {
            throw new MyBusinessException(String.format(ExceptionMessages.JSON_NOT_RESPONSE.getMessage(), service, ex));
        }
    }

    public static SendRequestPost toService(String endpoint, String service, String information) {
        return Tasks.instrumented(SendRequestPost.class, endpoint, service, information);
    }
}
