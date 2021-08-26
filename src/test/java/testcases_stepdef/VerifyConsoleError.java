package testcases_stepdef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import BaseClass.baseUtils;
import BaseClass.browsersetup;
import Utilities.util;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VerifyConsoleError extends baseUtils{
	
	static String configfilepath = System.getProperty("user.dir") + "//config//file.properties";
	static Properties prop;
	static FileInputStream fileInput;

	public static void Configuration() {
		try {
			fileInput = new FileInputStream(configfilepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp(Scenario scenario) throws InterruptedException {
		Reporter.assignAuthor("Kasturi");
		System.out.println("Open browser");
		Configuration();
		Thread.sleep(1000);
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName();
			try {
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						System.getProperty("user.dir") + "//target//cucumber-reports//" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@After(order = 0)
	public void AfterSteps() {
		driver.quit();
	}



	
	@Given("^I hit the following urls \"([^\"]*)\"$")
	public void i_hit_the_following_urls(String urls) throws Throwable {
		System.out.println("Open browser");
		Configuration();
		driver = browsersetup.setup(prop.getProperty("Browsername"), urls);
		Thread.sleep(1000);
	}

	@Then("^I verify the logEntries$")
	public void i_verify_the_logEntries() throws Throwable {
		Thread.sleep(7500);
		util ut = new util(driver);
		ut.logEntries();
	}
}
