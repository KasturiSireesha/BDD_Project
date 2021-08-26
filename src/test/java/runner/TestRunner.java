package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.File;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", 
glue="testcases_stepdef",
plugin = {"pretty","com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtendedReport.html","junit:target/cucumber-reports/Cucumber.xml","html:target/cucumber-html-reports","json:target/cucumber-reports/cucumber.json","html:target/Cucumber-JVM-report"},
monochrome =true //display the console output in a proper readable format
,strict=true //it will check if any step is not defined in step definition file
,dryRun = false // true: generating step definitions  false: execution test cases
,tags = {"@BrokenLinks"}
)
        
public class TestRunner extends AbstractTestNGCucumberTests{
    @AfterClass
    public static void writeExtentReport() {
    	String reportConfigPath = System.getProperty("user.dir")+"\\config\\extent-config.xml";
        Reporter.loadXMLConfig(new File(reportConfigPath));
        Reporter.setSystemInfo("User Name", "KASTURI");
        Reporter.setSystemInfo("Machine", "Windows 10 " + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }
}



