package Definitions;

import script.BaseScript;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import screen.BaseScreen;
import screen.HomePage;

public class LaunchHome {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	BaseScreen bs = new BaseScreen();
	static WebDriver dr;
	HomePage hp = new HomePage();
	String browser = "";

	
	/*
	 * @Before
	 * 
	 * 
	 * public void setUp() {
	 * 
	 * 
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * dr = BaseScript.getDriverObject(browser);
	 * 
	 * 
	 * }
	 */
	 
  
	/*
	 * @Given("user launches home page") public void userOnHomePage() {
	 * 
	 * bs.launchHome(dr); BaseScript.maximizeWindow(dr); }
	 */
    
	@Then("user should click global search")
	public void userFindGlobalsearch() throws InterruptedException, IOException {
		// logger = extent.startTest("userFindGlobalsearch");
		Thread.sleep(1000);
		hp.globalSearch(BackgroundCode.dr, "faded short sleeve");

	}

	@After
	
	public void afterclass() throws InterruptedException {
		Object[] paramNames = Reporter.getCurrentTestResult().getParameters();          
	    String featureName = paramNames[1].toString().replaceAll("^\"+|\"+$", "");
	    
		if(featureName.equals("Launch Home"))
		{
	    System.out.println("Feature file name: " + featureName);
		Thread.sleep(5000);
		BaseScript.driverclose(dr);
		}
	}

}