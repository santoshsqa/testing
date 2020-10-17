package com.ex2.homluvng.or;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.ex2.homluvng.base.BaseClass;
import com.ex2.homluvng.utility.CommonUtility;



public class HomePage_OR extends BaseClass {

	public HomePage_OR() {
		System.out.println(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@class='global-navigation']")
	private WebElement SideMenu;

	@FindBy(xpath = "(//ul[@id='userProfileContainer']//span)[1]")
	private WebElement Signuplink; 

	@FindBy(xpath = "(//ul[@id='userProfileContainer']//span)[2]")
	private WebElement LogInlink;

	@FindBy(xpath = "(//ng-select[@id='homePageLocationSearch'])[1]//input")
	private WebElement SearchTextbox;

	@FindBy(xpath = "//input[@class='hl-search-btn search-btn']")
	private WebElement SearchButton;

	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']/div[2]/div")
	private List<WebElement> SearchAutosuggest;

	@FindBy(xpath = "//ul[@class='d-flex flex-wrap']//a")
	private List<WebElement> AllCommunties;

	@FindBy(xpath = "//section[@class='home-search-area d-flex align-items-center justify-content-center']")
	private WebElement HeroImage;

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ How It Work Section(Not changed) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@FindBy(xpath = ".//*[@id='mainDiv']/section/div[2]/div/ul/li")
	private List<WebElement> HowItWorkSection;

	@FindBy(xpath = ".//div[@class='hlvs-video-text']/h2")
	private WebElement HowItWorkSectionVideoh1text;

	@FindBy(xpath = ".//div[@class='hlvs-video-text']/h3")
	private WebElement HowItWorkSectionVideoh2text;

	@FindBy(xpath = ".//div[@class='hlvs-video-text']/p")
	private WebElement HowItWorkSectionVideopara;



	@FindBy(xpath = ".//*[@id='mainDiv']/section/div[2]/div/ul/li[1]")
	private WebElement ExploreSection;

	@FindBy(xpath = ".//*[@id='mainDiv']/section/div[2]/div/ul/li[2]")
	private WebElement LuvSection;

	@FindBy(xpath = ".//*[@id='mainDiv']/section/div[2]/div/ul/li[3]")
	private WebElement MatchSection;

	@FindBy(xpath = ".//*[@id='mainDiv']/section/div[2]/div/ul/li[4]")
	private WebElement BuildSection;

	@FindBy(id = "myvideo")
	private WebElement HowItWorkSectionVideo;
	
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ NLC Data @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@FindBy(xpath = "//article[@class='articles-list']")
	private List<WebElement> ArticleSection;
	
	@FindBy(xpath="//article[@class='articles-list']//a")
	private List<WebElement> All_links;

	@FindBy(xpath = "//article//img")
	private List<WebElement> NLCImages;

	@FindBy(css = "a.more-article-link")
	private WebElement ViewAllArticles;
	
	public int getnoOfSection() {
		return ArticleSection.size();
	}

	public void clickOnNLC_Image(int noOfNLC) {
		click(NLCImages.get(noOfNLC));
		testlog.info("Clicked on NLC Image");
		System.out.println("Clicked on NLC");
	}

	public void clickOnViewArticles_Page() {
		click(ViewAllArticles);
		testlog.info("Clicked on NLC Image");
		System.out.println("Clicked on NLC");
	}

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SEO Tags @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@FindBy(xpath = "//link[@rel='canonical']")
	public WebElement Home_canonical;

	@FindBy(xpath = "//title")
	public WebElement Home_title;
	@FindBy(xpath = "//h1")
	public WebElement Home_h1;

// ############################################### Validation ###############################################
	/**
	 * @author sagupta
	 * @description :-
	 */
	public void verifySideMenuExists() {
		Assert.assertTrue(isElementPresent(SideMenu), "Assertion Failed :-Side Menu not exist on the page");
		testlog.info("Assertion Passed :- SideMenu Exist on the page");
		System.out.println("Assertion Passed :- SideMenu Exist on the page");

	}

	/**
	 * @author sagupta
	 * @description :-
	 */
	public void openSideMenu() {
		click(SideMenu);
		testlog.info("Opened Side Menu");
		System.out.println("Opened Side Menu");
	}

	/**
	 * @author sagupta
	 * @description :-
	 */
	public void verifyExistenceOfSignUp_link() {
		Assert.assertTrue(isElementPresent(Signuplink), "Asserion Failed :- ");
		testlog.info("Assertion Passed :-SignUp link is available");
		System.out.println("Assertion Passed :-SignUp link is available");
	}

	/**
	 * @author sagupta
	 * @description :-
	 */
	public void verifyExistenceOfLogIn_link() {
		Assert.assertTrue(isElementPresentwithLog(LogInlink), "Asserion Failed :-LoginIn link is not available ");
		testlog.info("Assertion Passed :-LogIn link is available");
		System.out.println("Assertion Passed :-LogIn link is available");
	}

	/**
	 * @author sagupta
	 * @description :-
	 */
	public void verifyExistenceOfSearch_field() {
		Assert.assertTrue(isElementPresent(SearchTextbox), "Assertion Failed :- SearchBox is not availble on the home page");
		testlog.info("Assertion Passed :-Search Text box is available");
		System.out.println("Assertion Passed :-Search Text box is available");
	}

	/**
	 * @author sagupta
	 * @description :-
	 */
	public void verifyExistenceOfSearch_btn() {
		Assert.assertTrue(isElementPresentwithLog(SearchButton), "Assertion Failed :- Search button is not available");;
		testlog.info("Assertion Passed :-Search button is available");
		System.out.println("Assertion Passed :-Search button is available");
	}

	/**
	 * @author rverma
	 * @description :-Verifying How it work section
	 */
	public void verifyExistenceOfHowItWorkSection() {
		Assert.assertTrue(isElementPresent(ExploreSection), "Assertion Failed :- ");
		testlog.info("Assertion Passed :-Explore Section is available");
		System.out.println("Assertion Passed :-Explore Section is available");
		Assert.assertTrue(isElementPresent(LuvSection), "Assertion Failed :- ");
		testlog.info("Assertion Passed :-Luv Section is available");
		System.out.println("Assertion Passed :-Luv Section is available");
		Assert.assertTrue(isElementPresent(MatchSection), "Assertion Failed :- ");
		testlog.info("Assertion Passed :-Match Section is available");
		System.out.println("Assertion Passed :-Match Section is available");
		Assert.assertTrue(isElementPresent(BuildSection), "Assertion Failed :- ");
		testlog.info("Assertion Passed :-Build Section is available");
		System.out.println("Assertion Passed :-Build Section is available");

	}

	/**
	 * @author rverma
	 * @Description:- Verifying elements of videos and Playing the video and
	 *                Printing the text beside the video played at home page
	 * @version 1.0
	 * @see https://builderhomesite.atlassian.net/browse/BDXHL-1187
	 */

	public void verifyExistenceOfHowItWorkVideo() {
		isElementPresent(HowItWorkSectionVideo);
		isElementPresent(HowItWorkSectionVideoh1text);
		System.out.println("Text under h1 is as " + HowItWorkSectionVideoh1text.getText());
		isElementPresent(HowItWorkSectionVideoh2text);
		System.out.println("Text under h2 is as " + HowItWorkSectionVideoh2text.getText());
		isElementPresent(HowItWorkSectionVideopara);
	//	Reporter.log("Checking HowItWorks section video and its content", true);
		HowItWorkSectionVideo.click();
//		Reporter.log("Video and Text displayed beside video on home page tested succesfully", true);

	}

// ############################################## Actions ######################################################

	public void clickOnSignUp_link() {
		sleep(2);
		click(Signuplink);
	}

	public void clickOnLogin_link() {
		click(LogInlink);
	}

	public void enterTextIntoSearch_field(String valuetoSearch) {
		testlog.info("Enter----> "+valuetoSearch+" on search box");
		sendText(SearchTextbox, valuetoSearch);
		sleep(2);
		testlog.info(valuetoSearch+"entered on search box");
		System.out.println(valuetoSearch+"entered on search box");
	}

/*	public void clickOnSearch_btn() {
		Search_Listing_OR listing = new Search_Listing_OR();
		click(SearchButton);
		testlog.info("Clicked on search button");
		System.out.println("Clicked on Search button");
		listing.closePopUpIfExists();
	}*/

	/**
	 * @author rverma Validating autosearch
	 * @version:- 1.0
	 * @description:- validating autosearch
	 * @see:https://builderhomesite.atlassian.net/browse/BDXHL-1180
	 */
	public void autoSearch(String string) {
		System.out.println(SearchAutosuggest.size());
		for (WebElement we : SearchAutosuggest) {
			Assert.assertTrue(we.getText().toLowerCase().contains(string.toLowerCase()),
					"Assertion Failed :- " + we.getText() + "has no matching data");
		}
	}

	public void validateAllBrokenLinksCommunties() {
		CommonUtility common = new CommonUtility();
		common.brokenLinks(AllCommunties);
		
	}

	public void validateNoOfComunities(int Expectedsize) {
		Assert.assertEquals(AllCommunties.size(), Expectedsize, "Assertion Failed :- ");
		testlog.info("Assertion Passed :-No fo communities are as expected");
		System.out.println("Assertion Passed :-No of communities are as expected");
	}

	/**
	 * @author rverma
	 * @Description:- Validating how it work section
	 */
	public void validateHowItWorksSection() {
		for (WebElement Section : HowItWorkSection) {
			System.out.println(Section.getText());
			testlog.info("Element with text"+Section.getText()+ "displayed correctly");

		}
	}

	/**
	 * @author rverma
	 * @description: NLC links of home page verification
	 * @Version: 1.0
	 * @see https://builderhomesite.atlassian.net/browse/BDXHL-1081
	 */
	public void validateNLConHomePage() {

		CommonUtility cls = new CommonUtility();
		cls.brokenLinks(All_links);
		testlog.info("URL verified succesfully");
		System.out.println("URL verified succesfully");

	}

	/**
	 * @author rverma
	 * @description:- SEO tags for home page verification(Title,h1,canonical)
	 * @version 1.0
	 * @see https://builderhomesite.atlassian.net/browse/BDXHL-1183
	 */		
	public void validateSEOTags(String title, String H1, String href) {
		// for title
		String Title_expected = title;
		System.out.println("text is " + Title_expected);
		String Title_actual = Home_title.getAttribute("textContent");
		System.out.println("text is " + Title_actual);
		Assert.assertTrue(Title_expected.equals(Title_actual), "Assertion Failed, does not matched title :-");
		testlog.info("Assertion Passed :-title matched");
		System.out.println("Assertion Passed :-Explore Section is available");
		// for h1
		String H1_expected = H1;
		String H1_actual = Home_h1.getAttribute("textContent");
		System.out.println("h1 text diplayed is " + H1_actual);
		Assert.assertTrue(H1_expected.equals(H1_actual), "Assertion Failed :-");

		// for canonical
		String Canonical_expected = href;
		String Canonical_actual = Home_canonical.getAttribute("href");
		System.out.println("canonical link is " + Canonical_actual);
		Assert.assertTrue(Canonical_expected.equals(Canonical_actual), "Assertion Failed :-");
	}

	/**
	 * @author rverma
	 * @description check the existence of SEO Tags
	 * @version 1.0
	 * @see https://builderhomesite.atlassian.net/browse/BDXHL-1183
	 */
	public void excistenceSEOTags() {
		Assert.assertTrue(isElementPresent(Home_canonical), "Assertion Failed:- Home canonical not exist");
		Reporter.log("Assertion Passed :- Home canonical as expected exist on the page", true);
		Assert.assertTrue(isElementPresent(Home_title), "Assertion Failed:- Home title not exist");
		Reporter.log("Assertion Passed :- Home title as expected exist on the page", true);
		Assert.assertTrue(isElementPresent(Home_h1), "Assertion Failed:- Home h1 not exist");
		Reporter.log("Assertion Passed :- Home h1 presented as expected exist on the page", true);

	}
}
