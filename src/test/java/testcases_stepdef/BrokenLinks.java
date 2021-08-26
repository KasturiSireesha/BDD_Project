package testcases_stepdef;

import BaseClass.baseUtils;
import Utilities.util;
import cucumber.api.java.en.Then;

public class BrokenLinks extends baseUtils{
	
	
	@Then("^I verify BrokenLinks$")
	public void i_verify_BrokenLinks() throws Throwable {
		Thread.sleep(7500);
		util ut = new util(driver);
		ut.BrokenLinks();
	}


}
