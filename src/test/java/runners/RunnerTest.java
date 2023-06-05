package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import steps.SetupStep;

@CucumberOptions(
	features = { "src/test/resources/features/form-submit.feature" },
	glue = { "steps" },
	plugin = {"pretty" },
	tags = {"@ID_0001,@ID_0002,@ID_0003,@ID_0004,@ID_0005,@ID_0006"},
	snippets = SnippetType.CAMELCASE,
	monochrome = true,
	dryRun = false,
	strict = true
)

@RunWith(Cucumber.class)
public class RunnerTest {

    @AfterClass
    public static void finishApplication() {
	SetupStep.closeApplication();
    }

}