package steps;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import core.context.TestContext;
import model.dtos.UserFormDTO;

public abstract class Steps {

    protected static TestContext testContext = new TestContext();
    protected static List<UserFormDTO> userFormList;
    public static Boolean status;

    public Steps() {
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
