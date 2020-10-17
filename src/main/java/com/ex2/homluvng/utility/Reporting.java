package com.ex2.homluvng.utility;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;





public class Reporting {

  
	private static ExtentReports extent;
 /* private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();*/
    ExtentTest parent;
    ExtentTest testlog;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}
	
	 
	 @BeforeClass
	    public synchronized void beforeClass() {
	        parent = extent.createTest(getClass().getName());
	   //     parentTest.set(parent);
	    }

	    @BeforeMethod
	    public synchronized void beforeMethod(Method method) {
	       
	    	testlog =  parent.createNode(method.getName());
	    //    test.set(child);
	    }

	    @AfterMethod
	    public synchronized void afterMethod(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE)
	        {
	        	testlog.log(Status.FAIL, "This is fail");
	        	testlog.log(Status.INFO, "");
	        	testlog.log(Status.DEBUG, "");
	        }
	//        	((ExtentTest) test.get()).fail(result.getThrowable());
	        else if (result.getStatus() == ITestResult.SKIP)
	        	testlog.log(Status.SKIP, "This is skip");
	  //          ((ExtentTest) test.get()).skip(result.getThrowable());
	        else
	        	testlog.log(Status.PASS, "This is passed");
	    //        ((ExtentTest) test.get()).pass("Test passed");

	        extent.flush();
	    }
	 
	 
	 
	 @Test
	 public void testing1() {
	//	 parent.log(Status.PASS, "Parent");
		 System.out.println("Test1");
		 testlog.log(Status.INFO, "Typed sucessfully");
		 testlog.log(Status.INFO, "Don't talk to me");
		 testlog.info("This is a info");

		 
	 }
	 
	 @Test
	 public void failing() {
		 Assert.assertTrue(false);
	 }
	 
	 @Test
	 public void checking() {
		  
		 System.out.println("checking");
	 }
	 
	 
//	 @AfterSuite
	 public void after() {
		 extent.flush();
	 }
	 public void afterLast(ITestResult result) {
		 if(result.getStatus()==ITestResult.FAILURE) {
			 
		 }
	 }
	 

}


