package br.dev.marcelodeoliveira.steps;

import java.util.List;

import br.dev.marcelodeoliveira.core.context.TestContext;
import br.dev.marcelodeoliveira.model.formsubmit.UserFormDTO;

public abstract class Steps {

    protected static TestContext testContext = new TestContext();
    public static Boolean status;

    public Steps() {
    }

    public static TestContext getTestContext() {
	return testContext;
    }

    public static void killDriver() {

	testContext.getDriverManager().killDriver();
    }

    public static void closeApplication() {
	killDriver();
    }

}
