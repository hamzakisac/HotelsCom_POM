package com.qa.hotelcom.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.hotelscom.util.ElementUtil;

public class ThreeStars {

	WebDriver driver;
	ElementUtil eUtil;
	WebDriverWait wait;

	By star = By.xpath("//input[@id='f-star-rating-3']");
	By hotels = By.className("property-name-link");
	By distance = By.xpath("//a[contains(text(),'Distance')]");
	By cityCenter = By.linkText("City center");
	By hotelDistances = By.className("property-landmarks");

	public ThreeStars(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(driver);
		wait = new WebDriverWait(driver, 10);

	}

	public void getPageTitle(String expectedTitle) {
		String title = eUtil.doGetPageTitle();
		System.out.println("ThreeStarHotelsPage Title is : \n" + title);
		try {
			Assert.assertEquals(title, expectedTitle);
		} catch (AssertionError e) {
			System.out.println("'''Title Changed'''");
		}
	}

	public void threeStarHotelsandDistance() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(star));
		eUtil.getElement(star).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(distance));
		eUtil.getElement(distance).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cityCenter));
		eUtil.getElement(cityCenter);
	}

	public void scrollDown() throws InterruptedException {
		for (int times = 0;; times++) {
			if (times >= 10) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)", "");
			Thread.sleep(3000);
		}

	}

	public void printclickFiveStarHotels() {
		List<WebElement> cityCenterDistance = driver.findElements(hotelDistances);
		int a = 0;
		for (int i = 0; i < cityCenterDistance.size(); i++) {
			double mile = Double.parseDouble(cityCenterDistance
					.get(i).getText().substring(0, 3));

			if (mile <= 10.0) {
				List<WebElement> hotelNames = driver.findElements(hotels);
				System.out.println(
						(++a) + "- " + hotelNames.get(i).getText() + 
						"\n " + mile + " miles away from City Center");

			}
		}

	}

}
