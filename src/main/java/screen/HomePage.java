package screen;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import script.*;

public class HomePage {

	public void globalSearch(WebDriver dr,String productname) throws IOException, InterruptedException{
		WebElement Homepage_globalsearch = BaseScript.getElement(dr,"//*[@id='search_query_top']");
		WebElement Homepage_searchIcon = BaseScript.getElement(dr,"//button[@name='submit_search']");
		Homepage_globalsearch.clear();
		Homepage_globalsearch.sendKeys(productname);
		Homepage_searchIcon.click();
		//Thread.sleep(5000);
		//BaseScript.screenshotmethod();
		

	}

}
