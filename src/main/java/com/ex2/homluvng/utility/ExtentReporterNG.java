package com.ex2.homluvng.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReporterNG {
	private ExtentReports extent;
	private int fileNumber = 0;

	
	
	/*public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
		Date date = new Date();
		String formattedDate = dateFormat.format(date);
		String fileName = "HomeLuvReporthappyflow" + formattedDate + ".html";
		String outputFolder = "Reports";
		extent = new ExtentReports(outputDirectory + File.separator + outputFolder + File.separator + fileName, false);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
		try {
			String content = outputDirectory + File.separator + outputFolder + File.separator + fileName;
			System.out.print(content);
			Email.SendEmail(new String[] { "rverma@ex2india.com", "rverma@builderhomesite.com" }, content,
					"Homluv happyflow Testing Report!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getName());

				test.getTest().setStartedTime(getTime(result.getStartMillis()));
				test.getTest().setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test " + status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();

				test.log(status, message);

				extent.endTest(test);

			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}*/
}