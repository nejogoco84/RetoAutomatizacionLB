package co.com.reto.lulobank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.reto.lulobank.utils.Constant.STATUS;
import static co.com.reto.lulobank.utils.Constant.STATUS_EXPECTED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StatusCode implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {

        assertThat(actor.recall(STATUS), equalTo(STATUS_EXPECTED));
        return true;
    }

    public static StatusCode responseCode() {
        return new StatusCode();
    }
}
