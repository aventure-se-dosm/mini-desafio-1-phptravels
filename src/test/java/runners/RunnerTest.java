package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import steps.Step;

@CucumberOptions(

        features = {"src/test/resources/features/form-submit.feature"},
        glue = {"steps"},
        plugin = {"pretty"},
        tags = {"@ID_0001,@ID_0002"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = false,
        strict = true
)

@RunWith(Cucumber.class)
public class RunnerTest {
	
	@AfterClass()
	public static void finishApplication() {
		Step.closeApplication();
	}
}