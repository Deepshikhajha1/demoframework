package script;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.*;

public class BaseScript {

	private static WebDriver wdchrome;
	private static WebDriver wdfirefox;
	private static WebDriver wdedge;
	private static String CHROME = "chrome";
	private static String FIREFOX = "firefox";
	private static String EDGE = "edge";
	static String selectedbrowser = "";
	private static String chromeBrowser = null;
	private static String edgeBrowser = null;
	File file = new File("shoppingsiteimage.jpeg");

	public static WebDriver getDriverObject(String browser) {

		if (browser == null || browser == "") {
			selectedbrowser = PropertyReader.getInstance().getProperty("browser");
		} else
			selectedbrowser = browser;
		if (selectedbrowser.equalsIgnoreCase(CHROME)) {
			System.out.println("Initiating Chrome Driver");
			WebDriverManager.chromedriver().setup();
			// WebDriverManager.chromedriver().version("2.26").setup();
			wdchrome = new ChromeDriver();
			wdchrome.manage().deleteAllCookies();
			System.out.println("Chrome session id" + ((RemoteWebDriver) wdchrome).getSessionId().toString());
			chromeBrowser = ((RemoteWebDriver) wdchrome).getSessionId().toString();
			return wdchrome;
		}
		if (selectedbrowser.equalsIgnoreCase(EDGE)) {
			System.out.println("Initiating edge Driver");
			WebDriverManager.edgedriver().setup();
			wdedge = new EdgeDriver();
			wdedge.manage().deleteAllCookies();
			System.out.println("Edge session id" + ((RemoteWebDriver) wdedge).getSessionId().toString());
			edgeBrowser = ((RemoteWebDriver) wdedge).getSessionId().toString();
			return wdedge;
		} else
			return null;

	}

	public static void maximizeWindow(WebDriver dr) {

		dr.manage().window().maximize();

	}

	public static void driverclose(WebDriver dr) {

		dr.quit();

	}

	public static WebElement getElement(WebDriver dr, String xpathexp) {

		return dr.findElement(By.xpath(xpathexp));

	}

	public static void scrollmethod(WebDriver dr, WebElement Element) {

		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView();", Element);

	}

	public static void hovermethod(WebDriver dr, WebElement Element) {

		Actions move = new Actions(dr);
		move.moveToElement(Element).build().perform();

	}

	public static String getScreenhot(WebDriver dr) throws Exception {
		String destination = "";
		String datetimesuffix = UtilityMethods.currentdatetime();
		TakesScreenshot ts = (TakesScreenshot) dr;
		File source = ts.getScreenshotAs(OutputType.FILE);
		if (dr.equals(wdedge))
			destination = System.getProperty("user.dir") + "/Screenshots/" + datetimesuffix + ".png";
		if (dr.equals(wdchrome))
			destination = System.getProperty("user.dir") + "/Screenshotsone/" + datetimesuffix + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

	public static void waitmethod(WebDriver dr, String xpathexpression) {

		WebDriverWait wait = new WebDriverWait(dr, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathexpression)));

	}

}
