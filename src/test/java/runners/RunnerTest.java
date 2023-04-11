package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(
	
	features = {
		"src/test/resources/features/form-submit.feature"
	}, 	
	glue = {
		"steps", 
	},
	plugin = { 
		"pretty"
	},
	snippets = SnippetType.UNDERSCORE,
	monochrome = true,
	dryRun = false,	
	strict = true
)

@RunWith(Cucumber.class)
public class RunnerTest {
	
}