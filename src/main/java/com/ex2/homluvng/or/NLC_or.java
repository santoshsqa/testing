package com.ex2.homluvng.or;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ex2.homluvng.api.NLCpage_api;
import com.ex2.homluvng.base.BaseClass;


public class NLC_or extends BaseClass {

	NLCpage_api nlcapi = new NLCpage_api();

	public NLC_or() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//aside//a[contains(text(),'View All Articles ')]")
	private WebElement ViewAllArticle;

	@FindBy(xpath="//aside//a[contains(text(),'Trends ')]")
	private WebElement Trend_link;

	@FindBy(xpath="//aside//a[contains(text(),'Advice ')]")
	private WebElement Advice_link;

	@FindBy(xpath="//aside//a[contains(text(),'Relationships ')]")
	private WebElement Relationship_link;

	@FindBy(xpath="//aside//a[contains(text(),'Inspiration ')]")
	private WebElement Inspiration_link;

	@FindBy(xpath="//aside//a[contains(text(),'Lifestyle ')]")
	private WebElement LifeStyle_link;

	@FindBy()
	private WebElement StartFreshBuyNew_link;

	@FindBy(xpath = "//article//figcaption/h3/a")
	private List<WebElement> TitleOf_Articles;

	@FindBy(xpath = "//*[@class='btn show-more-btn']")
	private List<WebElement> ShowMore_btn;
	
	@FindBy(css="div.nlc-author")
	private List<WebElement> Author;

	public void getTheTitleOfArticle() {

	}


	
	
	public void validateUrlOfThePage(String category) {
		int count = 1;
		String currentUrl = driver.getCurrentUrl();
		do {
			if (count == 1) {
				System.out.println("PageNo:-"+count);
				compareActualAndExpected(category, String.valueOf(count));
				compareAuthors_On_page(category, String.valueOf(count));
				
			} else if (ShowMore_btn.get(0).getAttribute("style").equalsIgnoreCase("display: none;")) {
				break;
			} else {
				new Actions(driver).moveToElement(ShowMore_btn.get(0)).perform();
				ShowMore_btn.get(0).click();
				driver.navigate().to(currentUrl + "?page=" + count);
				waitForPageLoad();
				System.out.println("PageNo:-"+count);
				compareActualAndExpected(category, String.valueOf(count));
				compareAuthors_On_page(category, String.valueOf(count));
			}
			count++;
		} while (ShowMore_btn.size() > 0);
	}
	
	
	
	private List getListOfExpectedUrls(String category,String page) {
		List list=new ArrayList();
		System.out.println(page);
		List<String> listOfTitlesfrom_api = nlcapi.getListOfUrlTitles(category,page);
		for (String titlefromapi : listOfTitlesfrom_api) {
			String expectedUrl = getExpectedNLCUrl(titlefromapi);
			list.add(openApplication()+"/article/"+expectedUrl);
		}
		return list;
	}
	
	private List getListOfActualUrls() {
		List list=new ArrayList();
		for (WebElement elemt : TitleOf_Articles) {
			String actual = elemt.getAttribute("href");
			list.add(actual);
		}
		return list;
	}
	
	private boolean compareActualAndExpected(String category, String page) {
		System.out.println(page);
		testlog.info("List for page:-"+page);
		testlog.info("Expected List of Urls:-"+getListOfExpectedUrls(category, page));	
		testlog.info("Actual List of Urls:-"+getListOfActualUrls());
		System.out.println("Expected Listof Urls:-"+getListOfExpectedUrls(category, page));
		System.out.println("Actual List of Urls:-"+getListOfActualUrls());
		boolean resultOfComapriosnequals = getListOfExpectedUrls(category, page).equals(getListOfActualUrls());
		if(resultOfComapriosnequals==true) {
			testlog.pass("Expected url list matches with actual url list");
			System.out.println("============================== Assertion Passed :- Expected url list matches with Actual url list ==============================");
			System.out.println();		
		}
		else {
			testlog.fail("Expected url list does not match with actual url list");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Assertion Failed :- Expected url list does not match with actual url list xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println();
		}
		return resultOfComapriosnequals;
	}
	

	private String getExpectedNLCUrl(String urlData) {
		return urlData.replaceAll(" ", "-").toLowerCase();
	}
	
	
//Accessing description
	private List getExpectedDescription() {
		return ShowMore_btn;
		
	}

	
//Authors	
	private List getListOfExpectedAuthors_from_api(String category,String pageNo) {
		List<String> listOfAuthors = nlcapi.getListOfAuthors(category, pageNo);
		return listOfAuthors;
	}
	
	private List getListOfActualAuthors_from_page() {
		List<String> list=new ArrayList<String>();
		for (WebElement authorelement : Author) {
			
			list.add(authorelement.getText().split("By ")[1]);
		}
		return list;		
	}
	
	private boolean compareAuthors_On_page(String category,String page) {
		testlog.info("Expected List of Authors:-"+getListOfExpectedAuthors_from_api(category, page));
		testlog.info("Actual List of Authors:-"+getListOfActualAuthors_from_page());
		System.out.println("Expected List of Authors:-"+getListOfExpectedAuthors_from_api(category, page));
		System.out.println("Actual List of Authors:-"+getListOfActualAuthors_from_page());
		boolean authorcomparision = getListOfExpectedAuthors_from_api(category, page).equals(getListOfActualAuthors_from_page());
		System.out.println("Dono ka output kya hai"+authorcomparision);
		if(authorcomparision==true) {
			testlog.pass("Expected and Actual authors list is same");
			System.out.println("============================== Assertion Passed:-Expected and Actual authors list is same ==============================");
			System.out.println();
		}else {
			testlog.fail("Expected and Actual authors list is not same");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Assertion Failed:-Expected and Actual authors list is not same xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println();
		}
	return authorcomparision;
	}
	
	public void validateAuthorsOn_thePage(String category,String page) {
		
	}
	
	
	
	
	
	

}
