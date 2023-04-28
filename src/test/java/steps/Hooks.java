package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import io.cucumber.core.api.Scenario;

public class Hooks {

	protected static WebDriver driver;
//	private static String mimeType;
//	private static String name;
//	private static byte[] data;

	@BeforeClass
	public void prepararLeituraDeDados(Scenario s) {
		
	}

	@AfterClass
	public static void closeAllBrowsers() {

		driver.close();
	}
}

// @AfterStep()
//	public static void usingScenarioClass(ScenarioDefinition s) {
//		// lista de STEPS - começou a ficar bom :D
//		List<Step> steps = s.getSteps();
//		String scenarioDefinitionName = s.getName();
//
//		Step firstScenario = steps.get(0);
//		String firstScenarioText = firstScenario.getText();
//		Node firstScenarioArgument = firstScenario.getArgument();
//
//		String nodeString = firstScenarioArgument.toString();
//	}

//	@AfterStep()
//	public static void usingScenarioDefinitionClass(Scenario s) {

/**
 * Like Scenario.embed(byte [], String), but with name for the embedding.
 * 
 * @Parameters: parameters, mimeType, name
 * 
 * @parameters:data what to embed, for example an image.
 * @mimeType what is the data?
 * @name embedding name
 */

//		s.embed(data, mimeType, name);
//
//		String scenarioId = s.getId();
//
//		Collection<String> tagNames = s.getSourceTagNames();
//
//		String uri = s.getUri();
//
//		Status status = s.getStatus();
//
//		s.write("This is just a DEMO text");
//
//	}

//	
//	@AfterStep ()
//	public static void someActionAfterEachStep(ScenarioOutline scenarioOutline) {
//
//		// pega os exemplos do scenarioOutline :D
//		List<Examples> exampleList = scenarioOutline.getExamples();
//		Examples firstExample = exampleList.get(0);
//		List<TableRow> tableBody = firstExample.getTableBody();
//		TableRow firstTableRow = tableBody.get(0);
//		List<TableCell> cellList = firstTableRow.getCells();
//	}
//
//	
//	
////	@AfterStep ()
//	public static void someActionAfterEachStep(ScenarioDefinition s) {
//
//	}
//}
//	
//	
//	
//	@Before (order = 1)
//	public static void inicializaSmthng2() {}
//	
//	
//	
//	
//	@After (order = 1)
//	public static void finalizaSmthng() {}
//	
//	
//	
//	@After (order = 2)
//	public static void finalizaSmthng2() {}
//	
//	
//	
//	
//	@AfterAll
//	public static void setup1() {}
