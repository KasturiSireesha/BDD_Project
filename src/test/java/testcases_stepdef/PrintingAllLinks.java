package testcases_stepdef;

import BaseClass.baseUtils;
import Utilities.util;
import cucumber.api.java.en.Then;

public class PrintingAllLinks  extends baseUtils{
	
	
	@Then("^I verify printing all the links$")
	public void i_verify_printing_all_the_links() throws Throwable {
		Thread.sleep(7500);
		util ut = new util(driver);
		ut.ClickAndNavigate();
	}

}
