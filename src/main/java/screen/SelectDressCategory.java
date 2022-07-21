package screen;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import script.*;

public class SelectDressCategory {
	SearchResultPage sp = new SearchResultPage();
	private Logger loggers = Logger.getLogger(SelectDressCategory.class);

	public void DressCategoryView(WebDriver dr) throws InterruptedException{

		WebElement SelectDressCategory_menu = BaseScript.getElement(dr,"//ul[contains(@class,'menu-content sf-js-enabled')]/child::li[2]");
		BaseScript.hovermethod(dr,SelectDressCategory_menu);
		Thread.sleep(3000);
		WebElement SelectDressCategory_casual = BaseScript.getElement(dr,"//li[contains(@class,'sfHover')]//ul[contains(@class,'submenu-container')]//a[@title='Casual Dresses']");		
		if (SelectDressCategory_casual.isDisplayed())
		SelectDressCategory_casual.click();
	}

	public void DressCategoryResults(WebDriver dr) throws InterruptedException, IOException {

		//WebElement SelectDressCategory_resultimage = BaseScript.getElement(dr, "//div[@class='content_scene_cat_bg']");
		WebElement SelectDressCategory_result = BaseScript.getElement(dr,"//div[@class='product-container']");
		Thread.sleep(3000);
		BaseScript.scrollmethod(dr,SelectDressCategory_result);
		WebElement Searchresult_morebutton = BaseScript.getElement(dr,"//span[text()='More']");

		if (SelectDressCategory_result.isDisplayed()) {
			BaseScript.hovermethod(dr,SelectDressCategory_result);
			BaseScript.waitmethod(dr,"//span[text()='More']");
			//BaseScript.screenshotmethod();
		    Searchresult_morebutton.click();

		} else {
			loggers.error("element is not displayed on the page");
		}
	}
	
	public void DressCategoryMovetoOtherwindow(WebDriver dr) throws InterruptedException, IOException {

		//WebElement SelectDressCategory_resultimage = BaseScript.getElement(dr, "//div[@class='content_scene_cat_bg']");
		WebElement SelectDressCategory_gotogoogle = BaseScript.getElement(dr,"//button[contains(@class,'btn-google-plus')]");
		Thread.sleep(3000);
		String parentwindow = dr.getWindowHandle();
		System.out.println(parentwindow);
		String titlewindow = dr.getTitle();
		System.out.println(titlewindow);
		SelectDressCategory_gotogoogle.click();
		Set<String> setofwindows = dr.getWindowHandles();
		Iterator<String> i1 = setofwindows.iterator();
		while(i1.hasNext())
		{
			String childwindow = i1.next();
			if(!childwindow.equals(parentwindow))
			{
			dr.switchTo().window(childwindow);
			BaseScript.maximizeWindow(dr);
			WebElement SelectDressCategory_gmail = BaseScript.getElement(dr,"//input[contains(@type,'email')]");
			SelectDressCategory_gmail.sendKeys("mytrialemail@gmail.com");
			dr.close();
			}
			
		}
		 Thread.sleep(5000);
		 dr.switchTo().window(parentwindow);
		
	}
}
