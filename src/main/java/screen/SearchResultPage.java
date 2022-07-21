package screen;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import script.*;

public class SearchResultPage {

	private Logger loggers = Logger.getLogger(SearchResultPage.class);

	public void searchresultview(WebDriver dr) throws InterruptedException, IOException {

		WebElement Searchresult_item = BaseScript.getElement(dr,"//div[@class='product-container']");
		WebElement Searchresult_morebutton = BaseScript.getElement(dr,"//span[text()='More']");
		Thread.sleep(5000);
		BaseScript.scrollmethod(dr,Searchresult_item);
		if (Searchresult_item.isDisplayed()) {
			BaseScript.hovermethod(dr,Searchresult_item);
			BaseScript.waitmethod(dr,"//span[text()='More']");
			//BaseScript.screenshotmethod();
			Searchresult_morebutton.click();

		} else {
			loggers.error("element is not displayed on the page");
		}

	}

}
