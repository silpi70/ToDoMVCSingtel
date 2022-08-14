package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//import io.cucumber.core.api.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue={"StepDefination"})
public class RunnerTest 
{

}