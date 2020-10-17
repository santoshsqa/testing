package com.ex2.homluv.testcases;

import org.testng.annotations.Test;

import com.ex2.homluvng.base.ObjectInitialization;

public class NLC_Validations extends ObjectInitialization{

	
	@Test
	public void nlcvalidationOnHomepage() {
		home.validateNLConHomePage();
	}
	
	@Test
	public void validation_On_ViewArticlePage() {
		driver.navigate().to(openApplication()+"/design-guide");
		nlc.validateUrlOfThePage("viewall");
	}
	
	@Test
	public void validation_On_TrendsPage() {
		driver.navigate().to(openApplication()+"/design-guide/trends");
		nlc.validateUrlOfThePage("trends");
	}
	
	@Test
	public void validation_On_AdvicePage() {
		driver.navigate().to(openApplication()+"/design-guide/advice");
		nlc.validateUrlOfThePage("advice");
	}
	
	@Test
	public void validation_On_RelationshipPage() {
		driver.navigate().to(openApplication()+"/design-guide/relationships");
		nlc.validateUrlOfThePage("relationship");
	}
	
	@Test
	public void validation_On_InspirationPage() {
		driver.navigate().to(openApplication()+"/design-guide/inspiration");
		nlc.validateUrlOfThePage("inspiration");
	}
	
	@Test
	public void validation_On_LifeStylePage() {
		driver.navigate().to(openApplication()+"/design-guide/lifestyle");
		nlc.validateUrlOfThePage("lifestyle");
	}
	
	
}
