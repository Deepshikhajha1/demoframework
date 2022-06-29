package test.functional.sanity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import screen.AddtoCart;
import screen.BaseScreen;
import screen.HomePage;
import screen.SearchResultPage;
import script.BaseScript;
import util.PropertyReader;
import util.UtilityMethods;

//It is possible to attach screenshots. To add a screen-shot, simply call addScreenCapture. 
//This method returns the HTML with  tag which can be used anywhere in the log details.

public class ExtentReportsClass {
	ExtentReports extent;
	ExtentTest logger;
	//WebDriver driver;
//	private Logger logger = Logger.getLogger(ExtentReportsClass.class);
	BaseScreen bs = new BaseScreen();
	HomePage hp = new HomePage();
	SearchResultPage sp = new SearchResultPage();
	AddtoCart ac = new AddtoCart();

	@BeforeClass
	public void beforeClass() {
//		logger.info("Started executing Smoke test");
	}

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.loadConfig(new File("src\\main\\resources\\reportconfig\\extent-config.xml"));
	}

	@Test
	public void Smoke01() {
		logger = extent.startTest("Smoke01");
		bs.launchHome();
		BaseScript.maximizeWindow();

	}

	@Test
	public void Smoke02() throws InterruptedException, IOException {
		logger = extent.startTest("Smoke02");
		Thread.sleep(1000);
		hp.globalSearch("faded short sleeve");

	}

	@Test
	public void Smoke03() throws InterruptedException, IOException {
		logger = extent.startTest("Smoke03");
		Thread.sleep(5000);
		sp.searchresultview();
	}

	@Test
	public void Smoke04() throws IOException {
		logger = extent.startTest("Smoke04");
		ac.addquantitytocart("3");
		ac.addsizetocart("M");
		ac.addtocartbutton();

	}

	

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			//logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			
			String screenshotPath = BaseScript.getScreenhot();
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case passed is " + result.getName());
			//logger.log(LogStatus.PASS, "Test Case passed is " + result.getThrowable());
			
			String screenshotPath = BaseScript.getScreenhot();
			// To add it in the extent report
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {

		extent.flush();
		extent.close();
	}

	@AfterClass
	public void afterclass() throws InterruptedException {
		Thread.sleep(5000);
		BaseScript.driverclose();
	}
}