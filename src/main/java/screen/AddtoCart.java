package screen;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import script.*;

public class AddtoCart {

	public void addquantitytocart(String quantity) {

		WebElement Addtocart_quantity = BaseScript.getElement("//input[@id='quantity_wanted']");
		Addtocart_quantity.clear();
		Addtocart_quantity.sendKeys(quantity);

	}

	public void addsizetocart(String visibletextvalue) throws IOException {

		WebElement Addtocart_size = BaseScript.getElement("//select[@id='group_1']");
		Select selectlist = new Select(Addtocart_size);
		// PageElementList.Addtocart_size.click();
		selectlist.selectByVisibleText(visibletextvalue);
		//BaseScript.screenshotmethod();
	}

	public void addtocartbutton() throws IOException {
		WebElement Addtocart_addtocartbutton = BaseScript.getElement("//button[@name='Submit']");
		
		Addtocart_addtocartbutton.click();
		
		BaseScript.waitmethod("//i[@class='icon-ok']");
		//BaseScript.screenshotmethod();

	}
}
