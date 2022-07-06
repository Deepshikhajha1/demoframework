package script;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.*;

public class BaseScript {

	private static WebDriver wd;
	private static String CHROME = "chrome";
	private static String FIREFOX = "firefox";
	File file = new File("shoppingsiteimage.jpeg");

	private static WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		wd = new FirefoxDriver();
		return wd;
	}

	private static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().version("2.26").setup();
		wd = new ChromeDriver();
		return wd;
	}

	public static WebDriver getDriverObject() {
		if (PropertyReader.getInstance().getProperty("browser").equalsIgnoreCase(CHROME)) {
			System.out.println("Initiating Chrome Driver");
			
			//System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
			getChromeDriver();
		}
		if (PropertyReader.getInstance().getProperty("browser").equalsIgnoreCase(FIREFOX)) {
			System.out.println("Initiating Firefox Driver");
			getFirefoxDriver();
		}
		return wd;
	}

	public static void maximizeWindow() {
		wd.manage().window().maximize();
	}

	public static void driverclose() {
		wd.close();
	}

	public static WebElement getElement(String xpathexp) {
		return wd.findElement(By.xpath(xpathexp));
	}

	public static void scrollmethod(WebElement Element) {

		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public static void hovermethod(WebElement Element) {
		Actions move = new Actions(wd);
		move.moveToElement(Element).build().perform();
	}

	public static String getScreenhot() throws Exception {
		String datetimesuffix = UtilityMethods.currentdatetime();
		TakesScreenshot ts = (TakesScreenshot) wd;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + datetimesuffix + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static void waitmethod(String xpathexpression) {
		WebDriverWait wait = new WebDriverWait(wd, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathexpression)));

	}

}
