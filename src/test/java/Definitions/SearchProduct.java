package Definitions;
import script.BaseScript;
import java.io.IOException;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import screen.AddtoCart;
import screen.BaseScreen;
import screen.HomePage;
import screen.SearchResultPage;
 
public class SearchProduct {
 
    WebDriver driver;
    ExtentReports extent;
	ExtentTest logger;
	BaseScreen bs = new BaseScreen();
	BackgroundCode bc = new BackgroundCode();
	HomePage hp = new HomePage();
	SearchResultPage sp = new SearchResultPage();
	LaunchHome lh = new LaunchHome();
	AddtoCart ac = new AddtoCart();
	private WebDriver dr;
	String browser = "";
	

	
	/*
	 * @Before
	 * 
	 * public void setUpOne() { Object[] paramNames =
	 * Reporter.getCurrentTestResult().getParameters(); String featureName =
	 * paramNames[1].toString().replaceAll("^\"+|\"+$", "");
	 * System.out.println("Feature file name: " + featureName);
	 * if(featureName.equals("Search Product")) { dr =
	 * BaseScript.getDriverObject(browser); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	 
 
	/*
	 * @Given("user clicks global search") public void userClicksGlobalsearch()
	 * throws InterruptedException, IOException {
	 * 
	 * lh.userOnHomePage(); lh.userFindGlobalsearch(); }
	 */
	/*
	 * public void setUp() {
	 * 
	 * WebDriverManager.chromedriver().setup(); dr = new ChromeDriver();
	 * 
	 * 
	 * 
	 * }
	 */

/*
 * @Given("user launches home page") public void userOnHomePageOne() {
 * 
 * bs.launchHome(dr); BaseScript.maximizeWindow(dr); }
 * 
 * 
 * @Then("user should click global search") public void
 * userFindGlobalsearchOne() throws InterruptedException, IOException { logger =
 * extent.startTest("userFindGlobalsearch"); Thread.sleep(1000);
 * hp.globalSearch(dr, "faded short sleeve");
 * 
 * 
 * }
 */
    @And("user views search results and clicks more")
    public void userViewsSearchresultClicksMoreButton() throws InterruptedException, IOException {
		//logger = extent.startTest("userViewsSearchresultClicksMoreButton");
    	
		Thread.sleep(1000);
		sp.searchresultview(BackgroundCode.dr);
		

	}
  
    @Then("user should view cart and add details to it")
    public void userAddsDetailstoCart() throws InterruptedException, IOException {
		//logger = extent.startTest("userAddsDetailstoCart");
		Thread.sleep(5000);
		ac.addquantitytocart(BackgroundCode.dr, "3");
		ac.addsizetocart(BackgroundCode.dr, "M");
		ac.addcolortocart(BackgroundCode.dr, "Blue");
	} 
        
    @And("user should go to checkout screen")
    public void userGoestoCheckout() throws InterruptedException, IOException {
		//logger = extent.startTest("userAddsDetailstoCart");
		Thread.sleep(5000);
		ac.addtocartbutton(BackgroundCode.dr);
	} 
 
	/*
	 * @After public void afterclass() throws InterruptedException {
	 * System.out.println("inside afterclass"); Thread.sleep(5000);
	 * BaseScript.driverclose(BackgroundCode.dr); }
	 */
 
}