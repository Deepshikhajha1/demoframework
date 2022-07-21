package screen;

import org.openqa.selenium.WebDriver;

import script.BaseScript;
import util.PropertyReader;

public class BaseScreen extends BaseScript {

	public void launchHome(WebDriver dr) {
		
		dr.get(PropertyReader.getInstance().getProperty("url"));
		
		
	}

}
