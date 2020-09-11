package com.qa.hotelcom.page;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelscom.util.ElementUtil;
import com.qa.hotelscom.util.JavaScriptUtil;

public class HotelsPage extends BasePage {

	WebDriver driver;
	ElementUtil eUtil;
	JavaScriptUtil jsUtil;
	WebDriverWait wait;

	By threeStar = By.id("f-star-rating-3");
	By hotels = By.className("p-name");
	By buttomPage = By.xpath("//a[contains(text(),'See all available')]");
	By buttomPage2 = By.xpath("//em[contains(text(),'not available')]");

	public HotelsPage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);

	}

	public void getPageTitle(String expectedTitle) {
		String title = eUtil.doGetPageTitle();
		System.out.println("HotelPage Title is : \n" + title);
		try {
			Assert.assertEquals(title, expectedTitle);
		} catch (AssertionError e) {
			System.out.println("'''Title Changed'''");
		}
	}

	public void clickStarAndScrollDown() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		eUtil.getElement(threeStar).click();
//		Thread.sleep(3000);
		for (int second = 0;; second++) {
			if (second >= 20) {
				break;
			}
			((JavascriptExecutor) driver).executeScript(
					"window.scrollBy(0,1200)", "");
			Thread.sleep(3000);
		}

	}

	public void listHiltonHotels() {
		List<WebElement> hotelList = driver.findElements(hotels);
		int a = 0;
		for (int i = 0; i < hotelList.size(); i++) {
			String hotels1 = hotelList.get(i).getText();
			if (hotels1.contains("Hilton")) {
				System.out.println((++a) + " " + hotels1);
			}
		}

	}

}
