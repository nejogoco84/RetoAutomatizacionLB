package co.com.reto.lulobank.questions;

import co.com.reto.lulobank.utils.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.reto.lulobank.utils.Constant.STATUS_EXPECTED;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StatusCode implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {

       assertThat(theActorInTheSpotlight().recall(Constant.STATUS),equalTo(STATUS_EXPECTED));
        return true;
    }
    public static StatusCode responseCode() {
        return new StatusCode();
    }
}
