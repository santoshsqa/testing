package com.ex2.homluvng.base;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ex2.homluvng.utility.ActionCapture;
import com.ex2.homluvng.utility.PropertyFileReader;

import io.restassured.RestAssured;

public class BaseClass{

	public  static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static   ExtentTest parent;
	public static ExtentTest testlog;
	public String browserName = "chrome";
	public String parentWindow;
	public PropertyFileReader prop;
	EventFiringWebDriver event;
	ActionCapture action;


	
	public void launchingBrowser() {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Browser_Exe\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("mozilla")) {

		} else if (browserName.equalsIgnoreCase("ie")) {

		}
		event=new EventFiringWebDriver(driver);
		action=new ActionCapture();
		event.register(action);
		event.get(openApplication());
		event.manage().timeouts().implicitlyWait(Integer.valueOf(PropertyFileReader.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		event.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
	//	waitForPageLoad();

	}
	
	public void getBaseURI() {
		String baseAPI = null;
		if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("production")) {
			baseAPI = PropertyFileReader.getProperty("production_api");
		} else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("staging")) {
			baseAPI = PropertyFileReader.getProperty("staging_api");
		} else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("qa")) {
			baseAPI = PropertyFileReader.getProperty("prod_url");
		} 	 else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("dev")) {
			baseAPI = PropertyFileReader.getProperty("dev_api");
		}else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("beta")) {
			baseAPI = PropertyFileReader.getProperty("staging_api");
		}
		RestAssured.baseURI=baseAPI;
	}

	protected void compareTheList(ArrayList expectedList, ArrayList actual) {
		Assert.assertEquals(actual, expectedList, "");
		Reporter.log("Assertion Passed :-Expected List :-"+expectedList+"and Actual List :-"+actual, true);
		
	}
	

	protected String openApplication() {
		String url = null;
		if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("production")) {
			url = PropertyFileReader.getProperty("prod_url");
		} else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("staging")) {
			url = PropertyFileReader.getProperty("staging_url");
		} else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("qa")) {
			url = PropertyFileReader.getProperty("qa_url");
		} else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("dev")) {
			url = PropertyFileReader.getProperty("dev_url");
		}else if (PropertyFileReader.getProperty("tier").equalsIgnoreCase("beta")) {
			url = PropertyFileReader.getProperty("staging_url");
		}

		return url;
	}



	protected void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	//	wait.until(ExpectedConditions.elementToBeClickable(element));
		click(element);
	}

	protected void click(WebElement element) {
		waitForClickable(element);
		testlog.debug("Trying to click on element "+element.toString());
		element.click();
		waitForPageLoad();

	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	protected boolean isElementPresentwithLog(WebElement element) {
		try {

			element.isDisplayed();
			Reporter.log(element.getText() + " is present", true);
			return true;
		} catch (NoSuchElementException e) {
			Reporter.log("Element is not present", true);
			return false;
		}
	}

	protected boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
//			Reporter.log("Element is not present", true);
			return false;
		}

	}

	public void turnOffImplicitwait(int timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * 
	 */
	public void turnOnImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(PropertyFileReader.getProperty("implicitWait")),
				TimeUnit.SECONDS);
	}

	protected List<WebElement> waitAndFindElements(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) element));
	}

	protected WebElement waitAndFindElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	protected String getText(WebElement element) {
		return waitAndFindElement(element).getText();
	}

	protected void sendText(WebElement element, String valuetoSearch) {
		waitAndFindElement(element);
		element.clear();
		element.sendKeys(valuetoSearch);
		Reporter.log("Entered -->" + valuetoSearch, true);

	}

	protected void verifyUrl(String page) {
		Assert.assertEquals(driver.getCurrentUrl(), openApplication() + page);
		Reporter.log("Assertion Passed :-Url matched", true);
	}

	protected void goBack() {
		driver.navigate().back();
		waitForPageLoad();
	}

	protected void assertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected,
				"Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
	}

	protected void waitVisibility(WebElement element) {
//    	System.out.println(element);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	protected void sleep(long timeInSeconds) {
		try {

			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToChildWindow() {
		parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		    	   sleep(2);
		          driver.switchTo().window(windowHandle);
		          }
		       }
	}
	
	public void switchToParentWindow() {
        driver.switchTo().window(parentWindow); //cntrl to parent window
	}

	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 25; i++) {
			sleep(1);
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public String getTitleOfpage() {
		return driver.getTitle();
	}
	
	public void navigateTo(String url) {
		
	}

}
