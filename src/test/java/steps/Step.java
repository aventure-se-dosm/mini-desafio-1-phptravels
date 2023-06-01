package steps;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import core.context.TestContext;
import model.dtos.UserFormDTO;

public abstract class Step {

    protected static TestContext testContext = new TestContext();
    protected static List<UserFormDTO> userFormList;
    public static Boolean status;

    public Step() {
    }

    public static void closeDriver() {

	testContext.getDriverManager().closeDriver();
    }

    public static void KillDriver() {

	testContext.getDriverManager().KillDriver();
    }

    private static Workbook getWorkBook() {
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
