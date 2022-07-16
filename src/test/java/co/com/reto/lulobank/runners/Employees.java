package co.com.reto.lulobank.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/employees.feature"},
        glue = {"co.com.reto.lulobank.stepsdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Employees {
}
