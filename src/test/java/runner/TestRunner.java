package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by Satish on 10/26/2018@.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"} , format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "steps", tags ="@search")
public class TestRunner extends AbstractTestNGCucumberTests{

}
