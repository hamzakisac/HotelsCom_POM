package com.qa.hotelscom.test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelcom.page.HomePage;
import com.qa.hotelcom.page.HotelsPage;
import com.qa.hotelcom.page.ThreeStars;

public class ThreeStarsTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;
	ThreeStars threeStars;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		hotelsPage = homePage.goToHotelsPage(prop.getProperty("homePageTitle"), prop.getProperty("destination"));
	}
	@Test(priority=1, description= "---gets WebPage's title")
	public void getPageTitleTest() {
		threeStars = new ThreeStars(driver);
		threeStars.getPageTitle(prop.getProperty("threeStarHotelsPageTitle"));
	}
	
	@Test(priority=2, description = "Selects 5 stars and distance as City Center")
	public void setStarsAndDistanceTest() {
		threeStars.threeStarHotelsandDistance();
	}
	
	@Test(priority=3, description="scroll the page down the buttom")
	public void scrollDownTest() throws InterruptedException {
		threeStars.scrollDown();
	}
	
	@Test(priority=4, description="Lists all the Hotels which areclose to the center within 10.0 miles")
	public void listHotelsTest() {
		threeStars.printclickFiveStarHotels();
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
