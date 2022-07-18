package co.com.reto.lulobank.questions;

import co.com.reto.lulobank.models.DeleteEmployeeResponse;
import co.com.reto.lulobank.utils.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SuccessfullyDeleted implements Question {

    private final String id;
    private final DeleteEmployeeResponse delete;

    public SuccessfullyDeleted(String id, DeleteEmployeeResponse delete) {
        this.id = id;
        this.delete = delete;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        assertThat(delete.getData(), equalTo(id));
        assertThat(delete.getMessage(), containsString(Constant.MESSAGE));
        assertThat(delete.getStatus(), equalToIgnoringCase(Constant.MESSAGE_STATUS));
        return true;
    }

    public static SuccessfullyDeleted byId(String id, DeleteEmployeeResponse delete) {
        return new SuccessfullyDeleted(id, delete);
    }
}
