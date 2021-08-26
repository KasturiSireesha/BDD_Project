package Utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

import BaseClass.baseUtils;

public class util extends baseUtils{

	public util(WebDriver driver) {
		baseUtils.driver = driver;
	}
	
	 public static void verifyLinks(String linkUrl)
	    {
	        try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	            	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a 404");
	            } else if(httpURLConnect.getResponseCode()>=302) {
	            	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" Moved Permanently");
	            }
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
	   }
	
	public void BrokenLinks() throws InterruptedException {
		  //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());  
      
        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
        }
		
	}
	
	public void ClickAndNavigate() throws InterruptedException {

		 Thread.sleep(10000);
	       
	        List<WebElement> alllink = driver.findElements(By.tagName("a"));

	        for(int i = 0 ;i<alllink.size();i++){
	            // printing links present on th egoogle home page.
	            if(alllink.get(i).isDisplayed() == true){
	                String urlp = alllink.get(i).getAttribute("href");
	                System.out.println("Links are : " + urlp );
	          
	                alllink.get(i).click();
	                 System.out.println(driver.getTitle());
	                 Assert.assertEquals(driver.getTitle(), driver.getTitle());
	                 driver.navigate().back();
	                 alllink = driver.findElements(By.tagName("a"));
	                 Thread.sleep(5000);
	            }
	        }
	}

	public void logEntries() {

		LogEntries logEntries = driver.manage().logs().get("browser");
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			String errorLogType = entry.getLevel().toString();
			String errorLog = entry.getMessage().toString();
			if (errorLog.contains("404")) {
				System.out.println("Error LogType: " + errorLogType + " Error Log message: " + errorLog);
			}
		}
	}
}
