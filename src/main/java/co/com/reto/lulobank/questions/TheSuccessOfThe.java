package co.com.reto.lulobank.questions;

import co.com.reto.lulobank.models.CreateEmployee;
import co.com.reto.lulobank.models.ResponseEmployeeCreate;
import co.com.reto.lulobank.utils.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TheSuccessOfThe implements Question<Boolean> {
    private final CreateEmployee createEmployee;
    private final ResponseEmployeeCreate responseEmployeeCreate;

    public TheSuccessOfThe(CreateEmployee createEmployee, ResponseEmployeeCreate responseEmployeeCreate) {
        this.createEmployee = createEmployee;
        this.responseEmployeeCreate = responseEmployeeCreate;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        assertThat(createEmployee.getAge(), equalTo(responseEmployeeCreate.getData().getAge()));
        assertThat(createEmployee.getSalary(), equalTo(responseEmployeeCreate.getData().getSalary()));
        assertThat(createEmployee.getName(), equalTo(responseEmployeeCreate.getData().getName()));
        assertThat(responseEmployeeCreate.getMessage(), containsString(Constant.MESSAGE));
        assertThat(responseEmployeeCreate.getStatus(), equalToIgnoringCase(Constant.MESSAGE_STATUS));

        return true;
    }

    public static TheSuccessOfThe creationEmployee(CreateEmployee createEmployee, ResponseEmployeeCreate responseEmployeeCreate) {
        return new TheSuccessOfThe(createEmployee, responseEmployeeCreate);
    }
}
