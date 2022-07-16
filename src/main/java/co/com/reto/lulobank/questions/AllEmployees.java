package co.com.reto.lulobank.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.reto.lulobank.utils.Constant.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

public class AllEmployees implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath jsonResponse = actor.recall(JSON_RESPONSE);
        assertThat(jsonResponse.get(DATA), is(not(empty())));
        assertThat(jsonResponse.get(MESSAGE).toString(),equalTo(MESSAGE_EXPECTED));
        return true;
    }
    public static AllEmployees listedCorrectly() {
        return new AllEmployees();
    }
}