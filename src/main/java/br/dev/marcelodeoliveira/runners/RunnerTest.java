package br.dev.marcelodeoliveira.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(
	features = { "src/test/resources/features/form-submit.feature" },
	glue = {
		"br.dev.marcelodeoliveira.business.form_submit",
		"br.dev.marcelodeoliveira.hooks" 
	},
	plugin = {
				"summary",
				"pretty" },
	tags = "@ID_0001 or @ID_0002 or @ID_0003 or @ID_0004 or @ID_0005 or @ID_0006",
	snippets = SnippetType.CAMELCASE,
	monochrome = true,
	dryRun = false
	)

@RunWith(Cucumber.class)
public class RunnerTest {

}