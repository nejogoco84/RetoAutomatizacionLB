package co.com.reto.lulobank.questions;

import co.com.reto.lulobank.models.ResponseAllEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.reto.lulobank.utils.Constant.MESSAGE;
import static co.com.reto.lulobank.utils.Constant.MESSAGE_STATUS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AllEmployees implements Question<Boolean> {

    private final ResponseAllEmployee responseAllEmployee;

    public AllEmployees(ResponseAllEmployee responseAllEmployee) {
        this.responseAllEmployee = responseAllEmployee;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        assertThat(responseAllEmployee.getData().size(), equalTo(24));
        assertThat(responseAllEmployee.getData(), is(notNullValue()));
        assertThat(responseAllEmployee.getMessage(), containsString(MESSAGE));
        assertThat(responseAllEmployee.getStatus(), equalToIgnoringCase(MESSAGE_STATUS));
        return true;
    }

    public static AllEmployees listedCorrectly(ResponseAllEmployee responseAllEmployee) {
        return new AllEmployees(responseAllEmployee);
    }
}