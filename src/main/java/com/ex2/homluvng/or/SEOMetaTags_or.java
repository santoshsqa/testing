package com.ex2.homluvng.or;

import java.util.List;
import static com.ex2.homluvng.utility.JsonUtility.getData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ex2.homluvng.base.BaseClass;

public class SEOMetaTags_or extends BaseClass{

	public SEOMetaTags_or() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//meta")
	private List<WebElement> NoOfMetaTags;
	
	@FindBy(xpath="//meta[@http-equiv='x-dns-prefetch-control']")
	private WebElement HttpEquiv1;
	
	@FindBy(xpath="//meta[@http-equiv='X-UA-Compatible']")
	private WebElement Httpequiv2;
	
	@FindBy(xpath="//meta[@charset='utf-8']")
	private WebElement Charset;
	
	@FindBy(xpath="//meta[@name='viewport']")
	private WebElement viewPort;
	
	@FindBy(xpath="//meta[@name='description']")
	private WebElement descriptionTag;
	@FindBy(xpath="//meta[@name='twitter:card']")
	private WebElement Twitter_card;
	@FindBy(xpath="//meta[@name='twitter:type']")
	private WebElement Twitter_type;	
	@FindBy(xpath="//meta[@name='twitter:site']")
	private WebElement Twitter_site;
	@FindBy(xpath="//meta[@name='twitter:description']")
	private WebElement Twitter_description;	
	@FindBy(xpath="//meta[@name='twitter:title']")
	private WebElement Twitter_title;
	
	@FindBy(xpath="//meta[@name='twitter:image']")
	private WebElement Twitter_image;
	
	@FindBy(xpath="//meta[@name='twitter:image:width']")
	private WebElement Twitter_img_width;
	
	@FindBy(xpath="//meta[@name='twitter:image:height']")
	private WebElement Twitter_img_height;
	
	@FindBy(xpath="//meta[@property='og:url']")
	private WebElement og_url;
	
	@FindBy(xpath="//meta[@property='og:type']")
	private WebElement og_type;
	
	@FindBy(xpath="//meta[@property='og:title']")
	private WebElement og_title;
	
	@FindBy(xpath="//meta[@property='og:description']")
	private WebElement og_description;
	
	@FindBy(xpath="//meta[@property='og:image']")
	private WebElement og_image;
	
	@FindBy(xpath="//meta[@property='og:image:width']")
	private WebElement og_img_width;
	
	@FindBy(xpath="//meta[@property='og:image:height']")
	private WebElement og_img_height;
	
	@FindBy(xpath="//meta[@property='fb:app_id']")
	private WebElement fb_appId;
	
	@FindBy(xpath="//meta[@name='google-site-verification']")
	private WebElement google_site_verification;
	
	@FindBy(xpath="//meta[@name='msapplication-TileColor']")
	private WebElement msapplication_TileColor;
	@FindBy(xpath="//meta[@name='theme-color']")
	private WebElement themecolor;
	
	@FindBy(xpath="//link[@rel='canonical']")
	private WebElement canonical_link;
	
	
	public void validateExistenceOfHttpEquivTag() {
		Assert.assertTrue(isElementPresent(HttpEquiv1),"Assertion Failed :-");
		Assert.assertEquals(HttpEquiv1.getAttribute("content"), "on","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Httpequiv2),"Assertion Failed :-");
		Assert.assertEquals(Httpequiv2.getAttribute("content"), "IE=edge,chrome=1","Assertion Failed :-");				
	}
	
	public void validateExistenceOfCharset() {
		Assert.assertTrue(isElementPresent(Charset),"Assertion Failed :-");
	}
	
	public void validateExistenceOfViewPort() {
		Assert.assertTrue(isElementPresent(viewPort), "Assertion Failed ");
		Assert.assertEquals(viewPort.getAttribute("content"), "width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0");
	}
	
	public void validateExistenceOfDescriptionTag(String description) {
		Assert.assertTrue(isElementPresent(descriptionTag), "Assertion Failed ");
		Assert.assertEquals(descriptionTag.getAttribute("content"), description);
	}
	
	public void validateExistenceOfFbId() {
		Assert.assertTrue(isElementPresent(fb_appId), "Assertion Failed ");
		Assert.assertEquals(fb_appId.getAttribute("content"), "358267807994345");
	}
	
	public void validateGoogleSiteVerification() {
		Assert.assertTrue(isElementPresent(google_site_verification), "Assertion Failed ");
		Assert.assertEquals(google_site_verification.getAttribute("content"), "24uHm372rCR-MTmdgsGlXDrWh7zLwmWLSYb4jM-jJT0");
	}
	
	public void validateMsapplicationTag() {
		Assert.assertTrue(isElementPresent(msapplication_TileColor), "Assertion Failed ");
		Assert.assertEquals(msapplication_TileColor.getAttribute("content"), "#919191");
	}
	
	public void validateThemecolor() {
		Assert.assertTrue(isElementPresent(themecolor), "Assertion Failed ");
		Assert.assertEquals(themecolor.getAttribute("content"), "#4bcca5");
	}
	public void validateExistenceOfTwitterTag(String twitterTitle,String twitterdes) {
		Assert.assertTrue(isElementPresent(Twitter_card),"Assertion Failed :-");
		Assert.assertEquals(Twitter_card.getAttribute("content"), "summary_large_image","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_type),"Assertion Failed :-");
		Assert.assertEquals(Twitter_type.getAttribute("content"), "website","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_site),"Assertion Failed :-");
		Assert.assertEquals(Twitter_site.getAttribute("content"), "@homluvcom","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_title),"Assertion Failed :-");
		Assert.assertEquals(Twitter_title.getAttribute("content"), twitterTitle,"Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_description),"Assertion Failed :-");
		Assert.assertEquals(Twitter_description.getAttribute("content"), twitterdes,"Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_image),"Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_img_width),"Assertion Failed :-");
		Assert.assertEquals(Twitter_img_width.getAttribute("content"), "500","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(Twitter_img_height),"Assertion Failed :-");
		Assert.assertEquals(Twitter_img_height.getAttribute("content"), "500","Assertion Failed :-");
	}
	
	public void validateExistenceOfOgTag(String ogUrl,String ogTitle,String ogDes) {
		Assert.assertTrue(isElementPresent(og_url),"Assertion Failed :-");
		Assert.assertEquals(og_url.getAttribute("content"), ogUrl,"Assertion Failed :-");
		Assert.assertTrue(isElementPresent(og_type),"Assertion Failed :-");
		Assert.assertEquals(og_type.getAttribute("content"), "website","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(og_title),"Assertion Failed :-");
		Assert.assertEquals(og_title.getAttribute("content"), ogTitle,"Assertion Failed :-");
		Assert.assertTrue(isElementPresent(og_description),"Assertion Failed :-");
		Assert.assertEquals(og_description.getAttribute("content"), ogDes,"Assertion Failed :-");
		Assert.assertTrue(isElementPresent(og_image),"Assertion Failed :-");

		Assert.assertTrue(isElementPresent(og_img_width),"Assertion Failed :-");
		Assert.assertEquals(og_img_width.getAttribute("content"), "1200","Assertion Failed :-");
		Assert.assertTrue(isElementPresent(og_img_height),"Assertion Failed :-");
		Assert.assertEquals(og_img_height.getAttribute("content"), "630","Assertion Failed :-");
	
	}
	
	public void validateConanicalTag(String canonicalUrl) {
		Assert.assertTrue(isElementPresent(canonical_link),"Assertion Failed :-");
		Assert.assertEquals(canonical_link.getAttribute("href"), canonicalUrl,"Assertion Failed :-");
	}
	public void validateExistenceOfNoOfMetaTags() {
		if(prop.getProperty("tier").equalsIgnoreCase("production")) {
			Assert.assertEquals(NoOfMetaTags.size(), getData("seo_nlc", "noOfMetaTags", "live"));
		}else {
		Assert.assertEquals(NoOfMetaTags.size(), getData("seo_nlc", "noOfMetaTags", "others"));
		}
	}

	public void validateTitleOfPage() {
		Assert.assertEquals(getTitleOfpage(), "");
		
	}

}
