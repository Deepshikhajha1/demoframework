package test.functional.sanity;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import screen.*;
import script.BaseScript;

public class SmokeTest {
	ExtentReports extent;
	ExtentTest logger;
	// WebDriver driver;
//	private Logger logger = Logger.getLogger(ExtentReportsClass.class);
	BaseScreen bs = new BaseScreen();
	HomePage hp = new HomePage();
	SearchResultPage sp = new SearchResultPage();
	AddtoCart ac = new AddtoCart();
	SelectDressCategory sd = new SelectDressCategory();
	private WebDriver dr;

	@BeforeClass

	public void beforeClass() {
//		logger.info("Started executing Smoke test");
		System.out.println("inside beforeclass");

	}

	@BeforeTest
	@Parameters("browser")
	public void startReport(@Optional String browser) {
		dr = BaseScript.getDriverObject(browser);
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.loadConfig(new File("src\\main\\resources\\reportconfig\\extent-config.xml"));		
		bs.launchHome(dr);
		BaseScript.maximizeWindow(dr);
	}

	
	@Test
	public void DressCategoryFlow() throws IOException, InterruptedException {
		logger = extent.startTest("DressCategoryFlow");
		sd.DressCategoryView(dr);
		sd.DressCategoryResults(dr);
		sd.DressCategoryMovetoOtherwindow(dr);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

			String screenshotPath = BaseScript.getScreenhot(dr);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case passed is " + result.getName());
			// logger.log(LogStatus.PASS, "Test Case passed is " + result.getThrowable());

			String screenshotPath = BaseScript.getScreenhot(dr);
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
		System.out.println("inside chrome afterclass");
		Thread.sleep(5000);
		BaseScript.driverclose(dr);
		
	}
}