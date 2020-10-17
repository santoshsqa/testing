package com.ex2.homluv.testcases;

import org.testng.annotations.Test;

import com.ex2.homluvng.base.ObjectInitialization;
import com.ex2.homluvng.utility.CommonUtility;

public class Check extends ObjectInitialization{

	
	@Test
	public void checking() {
//		System.out.println(CommonUtility.getCorrectUrl("Custom or Produ#ction Home: Choos'in$g th%e Best Option f(or)! Y@ou"));
	//	System.out.println(CommonUtility.getCorrectUrl("six-k'itchens-that-you-can’t-help-but-love"));
		
//	System.out.println(nlc.getListOfExpectedUrls("viewall","1"));
	driver.navigate().to(openApplication()+"/design-guide");
//	System.out.println(nlc.getListOfActualUrls());
//	nlc.compareActualAndExpected("viewall","1");
	nlc.validateUrlOfThePage("viewall");
//	System.out.println(nlc.getListOfExpectedAuthors_from_api("viewall", "1"));
	}
}
