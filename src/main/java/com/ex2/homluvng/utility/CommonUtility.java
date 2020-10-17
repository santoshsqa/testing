package com.ex2.homluvng.utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.ex2.homluvng.base.BaseClass;

public class CommonUtility extends BaseClass{

	/**
	 * @author sagupta
	 * @param allLinks
	 * @description :- this is used to check the broken links, provide the list of
	 *              links as input and it will to other method for every link for
	 *              broken link
	 */
	public void brokenLinks(List<WebElement> allLinks) {
		for (WebElement webElement : allLinks) {

			String url = webElement.getAttribute("href");
			// System.out.println("Check1");
			verifyLink(url);

		}

	}

	/**
	 * @author sagupta
	 * @param linkUrl
	 * @description :-verify any particular link
	 */
	private void verifyLink(String linkUrl) {
		try {
			// System.out.println("Check2");
			URL link = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) link.openConnection();
			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
				testlog.info(linkUrl + " - " + httpURLConnect.getResponseMessage());
				// System.out.println("Check3");
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
				testlog.info(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	public static String getCorrectUrl(String title) {

		String data = title.toLowerCase().replaceAll("-", "").replaceAll(" ", "-").replaceAll(":", "")
				.replaceAll("\\$", "").replaceAll(",", "").replaceAll("\\?", "").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\*", "").replaceAll("\\'", "").replaceAll("#", "").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\"", "").replaceAll("\\@", "").replaceAll("\\%", "").replaceAll("!", "").replaceAll("\\&", "")
				.replaceAll("’", "");

		return data;
	}

}
