package co.com.reto.lulobank.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class SuccessfullListOfEmployees implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath jsonResponse = actor.recall(JSON_RESPONSE);
        String obtainedValue = jsonResponse.get(MESSAGE).toString();
        assertThat(jsonResponse.get(DATA), is(not(empty())));
        assertThat(obtainedValue,equalTo(MESSAGE_EXPECTED));
        return true;
    }
    public static SuccessfullListOfEmployees jsonResponse() {
        return new SuccessfullListOfEmployees();
    }
}