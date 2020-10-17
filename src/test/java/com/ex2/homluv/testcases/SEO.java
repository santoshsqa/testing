package com.ex2.homluv.testcases;

import org.testng.annotations.Test;

import com.ex2.homluvng.base.ObjectInitialization;
//import com.ex2.homluvng.utility.PropertyFileReader;

//import com.ex2.homluvng.utility.PropertyFileReader;
import static com.ex2.homluvng.utility.JsonUtility.getData;
public class SEO extends ObjectInitialization{
	
	
	
	@Test
	public void validaSEOTagsOn_Homepage() {
		driver.navigate().to(openApplication());
	//	seometa.validateTitleOfPage();
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("home", "seo", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("home", "seo", "title"), getData("home", "seo", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("home", "seo", "url"), getData("home", "seo", "title"), getData("home", "seo", "description"));
		seometa.validateConanicalTag(openApplication()+getData("home", "seo", "url"));
	}
	
	@Test
	public void validateSEOTagsOn_SearchPage() {
		
	}

	@Test
	public void validateSEOTagsOn_ViewAllArticlesSection() {
		driver.navigate().to(openApplication()+"/design-guide");
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("seo_nlc", "ViewAllArticle", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("seo_nlc", "ViewAllArticle", "title"), getData("seo_nlc", "ViewAllArticle", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("seo_nlc", "ViewAllArticle", "url"), getData("seo_nlc", "ViewAllArticle", "title"), getData("seo_nlc", "ViewAllArticle", "description"));
		seometa.validateConanicalTag(openApplication()+getData("seo_nlc", "ViewAllArticle", "url"));
		
	}
	
	
	@Test
	public void validaSEOTagsOn_Trends() {
		driver.navigate().to(openApplication()+"/design-guide/trends");
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("seo_nlc", "Trends", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("seo_nlc", "Trends", "title"), getData("seo_nlc", "Trends", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("seo_nlc", "Trends", "url"), getData("seo_nlc", "Trends", "title"), getData("seo_nlc", "Trends", "description"));
		seometa.validateConanicalTag(openApplication()+getData("seo_nlc", "Trends", "url"));
	}
	
	@Test
	public void validaSEOTagsOn_Advice() {
		driver.navigate().to(openApplication()+"/design-guide/advice");
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("seo_nlc", "Advice", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("seo_nlc", "Advice", "title"), getData("seo_nlc", "Advice", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("seo_nlc", "Advice", "url"), getData("seo_nlc", "Advice", "title"), getData("seo_nlc", "Advice", "description"));
		seometa.validateConanicalTag(openApplication()+getData("seo_nlc", "Advice", "url"));
	}
	
	@Test
	public void validaSEOTagsOn_Relationships() {
		driver.navigate().to(openApplication()+"/design-guide/relationships");
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("seo_nlc", "Relationship", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("seo_nlc", "Relationship", "title"), getData("seo_nlc", "Relationship", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("seo_nlc", "Relationship", "url"), getData("seo_nlc", "Relationship", "title"), getData("seo_nlc", "Relationship", "description"));
		seometa.validateConanicalTag(openApplication()+getData("seo_nlc", "Relationship", "url"));
	}
	
	@Test
	public void validaSEOTagsOn_Inspiration() {
		driver.navigate().to(openApplication()+"/design-guide/inspiration");
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("seo_nlc", "Inspiration", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("seo_nlc", "Inspiration", "title"), getData("seo_nlc", "Inspiration", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("seo_nlc", "Inspiration", "url"), getData("seo_nlc", "Inspiration", "title"), getData("seo_nlc", "Inspiration", "description"));
		seometa.validateConanicalTag(openApplication()+getData("seo_nlc", "Inspiration", "url"));
	}
	
	@Test
	public void validaSEOTagsOn_Lifestyle() {
		driver.navigate().to(openApplication()+"/design-guide/lifestyle");
		seometa.validateExistenceOfNoOfMetaTags();
		seometa.validateExistenceOfCharset();
		seometa.validateExistenceOfHttpEquivTag();
		seometa.validateExistenceOfViewPort();
		seometa.validateExistenceOfDescriptionTag(getData("seo_nlc", "Lifestyle", "description"));
		seometa.validateExistenceOfFbId();
		seometa.validateGoogleSiteVerification();
		seometa.validateMsapplicationTag();
		seometa.validateThemecolor();
		seometa.validateExistenceOfTwitterTag(getData("seo_nlc", "Lifestyle", "title"), getData("seo_nlc", "Lifestyle", "description"));
		seometa.validateExistenceOfOgTag(openApplication()+getData("seo_nlc", "Lifestyle", "url"), getData("seo_nlc", "Lifestyle", "title"), getData("seo_nlc", "Lifestyle", "description"));
		seometa.validateConanicalTag(openApplication()+getData("seo_nlc", "Lifestyle", "url"));
	}
}
