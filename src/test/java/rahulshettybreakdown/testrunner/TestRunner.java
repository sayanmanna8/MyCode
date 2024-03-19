package rahulshettybreakdown.testrunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src/test/resource/feature",glue="rahulshettybreakdown.stepdefinations",
monochrome=true, plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/MyReport/cucumber.html","json:target/MyReport/report.json","junit:target/MyReport/report.xml"})
public class TestRunner extends AbstractTestNGCucumberTests{

	
}
