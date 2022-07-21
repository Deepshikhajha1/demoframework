package Definitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import screen.SearchResultPage;
import screen.SelectDressCategory;
import script.BaseScript;

public class DressCategoryFlow {
	SearchResultPage sp = new SearchResultPage();
	private Logger loggers = Logger.getLogger(SelectDressCategory.class);

	
	@Given("user clicks dresses option from menu bar and moves to sub menu")
	public void DressCategoryView() throws InterruptedException{

		WebElement SelectDressCategory_menu = BaseScript.getElement(BackgroundCode.dr,"//ul[contains(@class,'menu-content sf-js-enabled')]/child::li[2]");
		BaseScript.hovermethod(BackgroundCode.dr,SelectDressCategory_menu);
		Thread.sleep(3000);
		WebElement SelectDressCategory_casual = BaseScript.getElement(BackgroundCode.dr,"//li[contains(@class,'sfHover')]//ul[contains(@class,'submenu-container')]//a[@title='Casual Dresses']");		
		if (SelectDressCategory_casual.isDisplayed())
		SelectDressCategory_casual.click();
	}
	@Then("user moves to casual dress results and clicks more option")
	public void DressCategoryResults() throws InterruptedException, IOException {

		//WebElement SelectDressCategory_resultimage = BaseScript.getElement(dr, "//div[@class='content_scene_cat_bg']");
		WebElement SelectDressCategory_result = BaseScript.getElement(BackgroundCode.dr,"//div[@class='product-container']");
		Thread.sleep(3000);
		BaseScript.scrollmethod(BackgroundCode.dr,SelectDressCategory_result);
		WebElement Searchresult_morebutton = BaseScript.getElement(BackgroundCode.dr,"//span[text()='More']");

		if (SelectDressCategory_result.isDisplayed()) {
			BaseScript.hovermethod(BackgroundCode.dr,SelectDressCategory_result);
			BaseScript.waitmethod(BackgroundCode.dr,"//span[text()='More']");
			//BaseScript.screenshotmethod();
		    Searchresult_morebutton.click();

		} else {
			loggers.error("element is not displayed on the page");
		}
	}
	
	@And("user navigates to another window using google plus option and enters email")
	public void DressCategoryMovetoOtherwindow() throws InterruptedException, IOException {

		//WebElement SelectDressCategory_resultimage = BaseScript.getElement(dr, "//div[@class='content_scene_cat_bg']");
		WebElement SelectDressCategory_gotogoogle = BaseScript.getElement(BackgroundCode.dr,"//button[contains(@class,'btn-google-plus')]");
		Thread.sleep(3000);
		String parentwindow = BackgroundCode.dr.getWindowHandle();
		System.out.println(parentwindow);
		String titlewindow = BackgroundCode.dr.getTitle();
		System.out.println(titlewindow);
		SelectDressCategory_gotogoogle.click();
		Set<String> setofwindows = BackgroundCode.dr.getWindowHandles();
		Iterator<String> i1 = setofwindows.iterator();
		while(i1.hasNext())
		{
			String childwindow = i1.next();
			if(!childwindow.equals(parentwindow))
			{
		    BackgroundCode.dr.switchTo().window(childwindow);
			BaseScript.maximizeWindow(BackgroundCode.dr);
			WebElement SelectDressCategory_gmail = BaseScript.getElement(BackgroundCode.dr,"//input[contains(@type,'email')]");
			SelectDressCategory_gmail.sendKeys("mytrialemail@gmail.com");
			Thread.sleep(5000);
			BackgroundCode.dr.close();
			}
			
		}
		 
		BackgroundCode.dr.switchTo().window(parentwindow);
		
	}
	
	@After
    public void afterclass() throws InterruptedException {
		System.out.println("inside afterclass dresscategory");
		Thread.sleep(5000);
		BaseScript.driverclose(BackgroundCode.dr);
	}
}
