package com.qa.hotelscom.test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelcom.page.FourStars;
import com.qa.hotelcom.page.HomePage;
import com.qa.hotelcom.page.HotelsPage;

public class FourStarsTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;
	FourStars fourStars;
	
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
		fourStars = new FourStars(driver);
		fourStars.getPageTitle(prop.getProperty("fourStarHotelsPageTitle"));
	}
	@Test(priority=2, description = "Selects 5 stars and distance as City Center")
	public void setStarsAndDistanceTest() {
		fourStars.fourStarHotelsandDistance();
	}
	
	@Test(priority=3, description="scroll the page down the buttom")
	public void scrollDownTest() throws InterruptedException {
		fourStars.scrollDown();
	}
	
	@Test(priority=4, description="Lists all the Hotels which areclose to the center within 10.0 miles")
	public void listHotelsTest() {
		fourStars.printclickFiveStarHotels();
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
