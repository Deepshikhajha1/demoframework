package screen;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import script.*;

public class SearchResultPage {

	private Logger loggers = Logger.getLogger(SearchResultPage.class);

	public void searchresultview() throws InterruptedException, IOException {

		WebElement Searchresult_item = BaseScript.getElement("//div[@class='product-container']");
		WebElement Searchresult_morebutton = BaseScript.getElement("//span[text()='More']");
		Thread.sleep(5000);
		BaseScript.scrollmethod(Searchresult_item);
		if (Searchresult_item.isDisplayed()) {
			BaseScript.hovermethod(Searchresult_item);
			BaseScript.waitmethod("//span[text()='More']");
			//BaseScript.screenshotmethod();
			Searchresult_morebutton.click();

		} else {
			loggers.error("element is not displayed on the page");
		}

	}

}
