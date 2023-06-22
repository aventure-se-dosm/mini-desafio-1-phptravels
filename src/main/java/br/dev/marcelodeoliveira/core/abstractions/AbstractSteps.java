package br.dev.marcelodeoliveira.core.abstractions;

import br.dev.marcelodeoliveira.core.context.TestContext;

public abstract class AbstractSteps {

    protected static TestContext testContext = new TestContext();
    public static Boolean status;

    public AbstractSteps() {
    }

    public static TestContext getTestContext() {
	return testContext;
    }

    public static void killDriver() {

		TestContext.getDriverManager().killDriver();
    }

    public static void closeApplication() {
	killDriver();
    }

}
