package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(

        features = {"src/test/resources/features/form-submit.feature"},
        glue = {"steps"},
        plugin = {"pretty"},
        tags = {"@ID_0001"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = false,
        strict = true
        
)

@RunWith(Cucumber.class)
public class RunnerTest {
	
//	@AfterClass
//	public static void finishApplication() {
//		Step.closeApplication();
//	}
}