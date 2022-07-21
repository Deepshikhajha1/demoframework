package screen;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import script.*;

public class AddtoCart {

	public void addquantitytocart(WebDriver dr, String quantity) throws InterruptedException {

		WebElement Addtocart_quantity = BaseScript.getElement(dr,"//input[@id='quantity_wanted']");
		Addtocart_quantity.clear();
		Addtocart_quantity.sendKeys(quantity);

	}

	public void addsizetocart(WebDriver dr,String visibletextvalue) throws IOException, InterruptedException {

		WebElement Addtocart_size = BaseScript.getElement(dr,"//select[@id='group_1']");
		Select selectlist = new Select(Addtocart_size);
		// PageElementList.Addtocart_size.click();
		selectlist.selectByVisibleText(visibletextvalue);
		//BaseScript.screenshotmethod();
	}
	
	public void addcolortocart(WebDriver dr,String color) throws InterruptedException{

		WebElement Addtocart_color = BaseScript.getElement(dr,"//ul[@id='color_to_pick_list']//child::li//a[@title='"+color+"']");
		Addtocart_color.click();
	}

	public void addtocartbutton(WebDriver dr) throws IOException, InterruptedException {
		WebElement Addtocart_addtocartbutton = BaseScript.getElement(dr,"//button[@name='Submit']");
		
		Addtocart_addtocartbutton.click();
		
		BaseScript.waitmethod(dr,"//i[@class='icon-ok']");
		//BaseScript.screenshotmethod();

	}
}
