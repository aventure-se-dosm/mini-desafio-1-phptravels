package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(

		features = { 
				"src/test/resources/features/form-submit.feature",
				//"src/test/resources/features/form-submit-altogether.feature" 
		},
		
		glue = {
				"steps",
		},
		
		plugin = { 
				"pretty"
		},

		tags = {

		}, 
		
		snippets = SnippetType.CAMELCASE,
		
		monochrome = true,
		
		dryRun = false,
		
		strict = true
	)

@RunWith(Cucumber.class)
public class RunnerTest {

}