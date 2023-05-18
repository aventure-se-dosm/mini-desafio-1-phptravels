package steps;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.context.TestContext;
import core.utils.ExcelUtils;
import io.cucumber.core.api.Scenario;
import model.dtos.UserFormDTO;

public abstract class Step {

	
	protected static String userId;
	protected static TestContext testContext;
	protected static List<UserFormDTO> userFormList;
	public static Boolean status;

	public static void setId(String idFromFeatureTag) {
		userId = idFromFeatureTag;
	}

	public static void startApplication(Scenario scenario) {

		testContext = new TestContext();
		
		//vamos diminuir depois com um 'dsl' ou com o próprio UTILS, e tirar esse 0 hardão
		userFormList = ExcelUtils.getAllUsersList(testContext.getExcelReader().getWorkBook().getSheetAt(0));
	}

	public static void closeDriver() {

		testContext.getDriverManager().closeDriver();
	}
	
	public static void KillDriver() {

		testContext.getDriverManager().KillDriver();
	}


	private static XSSFWorkbook getWorkBook() {
		return testContext.getExcelReader().getWorkBook();
	}

	public static void closeWorkBook() {

		try {
			getWorkBook().close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void closeApplication() {
		closeWorkBook();
		KillDriver();
	}

}
