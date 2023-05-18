package steps;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.context.TestContext;
import io.cucumber.core.api.Scenario;
import model.dtos.UserFormDTO;

public abstract class Steps {

	protected static String userId;
	protected static TestContext testContext;
	protected static List<UserFormDTO> userFormList;

	public static Boolean status;

	public static void setId(String idFromFeatureTag) {
		userId = idFromFeatureTag;
	}

	public static void startApplication(Scenario scenario) {

		testContext = new TestContext();
		userFormList = testContext.getExcelReader().getAllUsersList();
	}

	public static void closeDriver() {

		testContext.getDriverManager().closeDriver();
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
		closeDriver();
	}

}
