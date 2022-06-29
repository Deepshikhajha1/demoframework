package test.functional.sanity;

import org.testng.annotations.Test;

import screen.*;
import script.BaseScript;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SmokeTest {

	private Logger logger = Logger.getLogger(SmokeTest.class);
	BaseScreen bs = new BaseScreen();
	HomePage hp = new HomePage();
	SearchResultPage sp = new SearchResultPage();
	AddtoCart ac = new AddtoCart();

	@BeforeClass
	public void beforeClass() {
		logger.info("Started executing Smoke test");
	}

	@Test
	public void Smoke01() {

		bs.launchHome();
		BaseScript.maximizeWindow();

	}

	@Test
	public void Smoke02() throws InterruptedException, IOException {
		Thread.sleep(1000);
		hp.globalSearch("faded short sleeve");

	}

	@Test
	public void Smoke03() throws InterruptedException, IOException {
		Thread.sleep(5000);
		sp.searchresultview();
	}

	@Test
	public void Smoke04() throws IOException {
		ac.addquantitytocart("3");
		ac.addsizetocart("M");
		ac.addtocartbutton();

	}

	@AfterClass
	public void afterclass() throws InterruptedException {
		Thread.sleep(5000);
		BaseScript.driverclose();
	}
}
