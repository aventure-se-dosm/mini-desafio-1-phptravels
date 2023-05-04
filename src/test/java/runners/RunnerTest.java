package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;



@CucumberOptions(

		features = { "src/test/resources/features/form-submit.feature" }, glue = { "steps", }, plugin = { "pretty" },

		tags = {

		}, snippets = SnippetType.CAMELCASE, monochrome = true, dryRun = false, strict = true)

@RunWith(cucumber.api.junit.Cucumber.class)
public class RunnerTest {

}