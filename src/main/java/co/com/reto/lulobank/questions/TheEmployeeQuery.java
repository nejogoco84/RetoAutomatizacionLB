package co.com.reto.lulobank.questions;

import co.com.reto.lulobank.models.ResponseEmployeeId;
import co.com.reto.lulobank.utils.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TheEmployeeQuery implements Question<Boolean> {

    private final int id;
    private final ResponseEmployeeId responseEmployeeId;

    public TheEmployeeQuery(int id, ResponseEmployeeId responseEmployeeId) {
        this.id = id;
        this.responseEmployeeId = responseEmployeeId;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        assertThat(responseEmployeeId.getData().getId(), equalTo(id));
        assertThat(responseEmployeeId.getData(), is(notNullValue()));
        assertThat(responseEmployeeId.getMessage(), containsString(Constant.MESSAGE));
        assertThat(responseEmployeeId.getStatus(), equalToIgnoringCase(Constant.MESSAGE_STATUS));
        return true;
    }

    public static TheEmployeeQuery withId(int id, ResponseEmployeeId responseEmployeeId) {
        return new TheEmployeeQuery(id, responseEmployeeId);
    }
}
