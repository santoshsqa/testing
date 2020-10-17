package com.ex2.homluvng.base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ex2.homluvng.or.HomePage_OR;
import com.ex2.homluvng.or.NLC_or;
import com.ex2.homluvng.or.SEOMetaTags_or;
import com.ex2.homluvng.utility.ExtentManager;
import com.ex2.homluvng.utility.Screenshot;

public class ObjectInitialization extends BaseClass {

	public HomePage_OR home;
	/*
	 * public Search_Headers_OR header; public Search_Listing_OR listing; public
	 * Footer_OR footer; public SignUp_OR signUp; public Login_OR login; public
	 * NLCSection_OR nlc; public DetailsPage_OR detail;; public MyCollectionPage_OR
	 * mycollection; public ViewAllArticles_OR articles; public Global_OR global;
	 * public SideMenu_OR sideMenu;
	 */
	public SEOMetaTags_or seometa;
	public NLC_or nlc;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("OS name", System.getProperty("os.name"));
		extent.setSystemInfo("OS version", System.getProperty("os.version"));
		extent.setSystemInfo("OS architecture", System.getProperty("os.arch"));

	}

	@BeforeClass
	public void startInstance() {
		parent = extent.createTest(getClass().getSimpleName());
		// System.out.println(getClass().getSimpleName());
		launchingBrowser();
		home = new HomePage_OR();
		/*
		 * signUp = new SignUp_OR(); login = new Login_OR(); header = new
		 * Search_Headers_OR(); listing = new Search_Listing_OR(); footer = new
		 * Footer_OR();
		 * 
		 * sideMenu = new SideMenu_OR(); global = new Global_OR(); detail = new
		 * DetailsPage_OR(); mycollection = new MyCollectionPage_OR(); articles = new
		 * ViewAllArticles_OR();
		 */
		seometa = new SEOMetaTags_or();
		nlc = new NLC_or();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@BeforeMethod
	public void beofreEveryTestcase(Method method) {
		testlog = parent.createNode(method.getName());

		Reporter.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Execute:-- " + method.getName()
				+ " %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", true);
	}

	@AfterMethod
	public void afterEveryTestcase(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = Screenshot.getScreenshot(driver, result.getName());
			testlog.log(Status.FAIL, MarkupHelper
					.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			testlog.fail(result.getThrowable());
			try {
				testlog.fail("Snapshot below: " + testlog.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.SKIP)
			testlog.log(Status.SKIP, "This is skip");
		else
			testlog.log(Status.PASS, MarkupHelper
					.createLabel(result.getName() + " Test case Passed with all validation:", ExtentColor.GREEN));
		extent.flush();

		System.out.println();
		try {
			WebElement logo = driver.findElement(By.xpath("//div[@class='pull-left']//img"));
			wait.until(ExpectedConditions.elementToBeClickable(logo));
			logo.click(); // click on logo to go homePage
			sleep(2);
		} catch (Exception e) {
			driver.navigate().to(openApplication());
			sleep(2);
		}
		Reporter.log("--------------------End :- " + result.getName() + "-----------------------------------", true);
		System.out.println();
	}

}
