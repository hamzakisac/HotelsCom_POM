package com.qa.hotelcom.page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelscom.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil eUtil;

	By popUp = By.xpath("//button[@class='cta widget-overlay-close']");
	By destinationBox = By.id("qf-0q-destination");
	By closeDestination = By.xpath("//td//button[contains(text(),'close')]");
	
	By checkInBox = By.xpath("//input[@id = 'qf-0q-localised-check-in']");
	By checkInDate = By.xpath("//td[@class='widget-datepicker-weekend'][@data-date='2020-8-27']");
	By checkOutBox = By.xpath("//input[@id = 'qf-0q-localised-check-out']");
	By checkOutDate = By.xpath("//td[@data-date='2020-8-30']");
	
	By rooms = By.xpath("//select[@id = 'qf-0q-rooms']");
	By adult = By.xpath("//select[@id = 'qf-0q-room-0-adults']");
	By children = By.id("qf-0q-room-0-children");
	By child1 = By.id("qf-0q-room-0-child-0-age");
	By child2 = By.id("qf-0q-room-0-child-1-age");
	By searchbBtn = By.xpath("//button[@type='submit']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(driver);
	}

	public void getPageTitle(String expectedTitle) {
		String title = eUtil.doGetPageTitle();
		System.out.println("HomePage Title is : \n" + title);
		try {
			Assert.assertEquals(title, expectedTitle);
		} catch (AssertionError e) {
			System.out.println("'''Title Changed'''");
		}
	}

	public void whereAndWhen(String destination) {
		//eUtil.getElement(popUp).click();
		eUtil.doSendKeys(destinationBox, destination);
		eUtil.getElement(closeDestination).click();
		
		eUtil.getElement(checkInBox).click();
		eUtil.getElement(checkInDate).click();
		
		
		eUtil.getElement(checkOutBox).click();
		eUtil.getElement(checkOutDate).click();

	}

	public void roomAndPeople() {
		eUtil.selectDropDownValueByText(driver, rooms, "1");
		eUtil.selectDropDownValueByText(driver, adult, "2");
		eUtil.selectDropDownValueByText(driver, children, "2");
		eUtil.selectDropDownValueByText(driver, child1, "4");
		eUtil.selectDropDownValueByText(driver, child2, "9");
		driver.findElement(searchbBtn).click();
	}

	public HotelsPage goToHotelsPage(String title, String destination) {
		getPageTitle(title);
		whereAndWhen(destination);
		roomAndPeople();
		return new HotelsPage(driver);
	}

}
