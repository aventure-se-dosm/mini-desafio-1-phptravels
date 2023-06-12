package steps;

import java.util.List;

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

    public static void closeApplication() {
	KillDriver();
    }

}
