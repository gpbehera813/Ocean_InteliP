package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/test/resources/featurefile"},
        glue = {"stepdefination"},
        tags = "@RegessionTest",
        plugin = {"pretty",
        "html:target/test-outputt/sample.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)

public class FeatureRunner {
}
