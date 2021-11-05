package co.com.client.webproject.test.runners.register;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = {"src\\main\\resources\\features\\register\\register.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.register"},
        plugin = {
                "pretty",
                "html:target/cucumber"
        },
        tags = {""}
)
public class RegisterCucumberTest {
}
