package Definitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import screen.*;
import script.BaseScript;

public class BackgroundCode {

	BaseScreen bs = new BaseScreen();
	static WebDriver dr;
	HomePage hp = new HomePage();
	String browser = "";

	
	
	@Given("user launches home page")
	public void userOnHomePage() {
		//WebDriverManager.chromedriver().setup();

		dr = BaseScript.getDriverObject(browser);

		bs.launchHome(dr);
		BaseScript.maximizeWindow(dr);
		
	}

}
