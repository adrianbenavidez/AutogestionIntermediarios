package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions(features = "src/test/resources/Features", glue = {
 * "stepDefinitions" }, monochrome = true, plugin = { "pretty",
 * "html:target/HtmlReport", "json:target/JSONReport.json",
 * "junit:target/JUnitReport.xml" }, tags = "@debug") public class TestRunner {
 * 
 * }
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features" }, 
glue = { "stepDefinitions" }, 
//tags = "@debug", 
plugin = {"json:target/cucumber.json" })
public class TestRunner {
}

/*
 * Ubicarse en el directorio del proyecto cd [directorio] 
 * 1. mvn clean test 
 * 2. mvn verify -DskipTests ver el reporte en target }
 */

/*
 * para ejecutar solo un tag agregar @debug en el escenario y descomentar la linea 22 del runner
 */
