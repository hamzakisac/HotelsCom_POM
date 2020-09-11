package com.qa.hotelscom.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelcom.page.FiveStars;
import com.qa.hotelcom.page.HomePage;
import com.qa.hotelcom.page.HotelsPage;

public class FiveStarsTest extends BasePage{
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;
	FiveStars fiveStars;
		
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
		fiveStars = new FiveStars(driver);
		fiveStars.getPageTitle(prop.getProperty("fiveStarHotelsPageTitle"));
	}
	
	@Test(priority=2, description = "Selects 5 stars and distance as City Center")
	public void setStarsAndDistanceTest() {
		fiveStars.fiveStarHotelsandDistance();
	}
	
	@Test(priority=3, description="scroll the page down the buttom")
	public void scrollDownTest() throws InterruptedException {
		fiveStars.scrollDown();
	}
	
	@Test(priority=4, description="Lists all the Hotels which are close to the center within 10.0 miles")
	public void listHotelsTest() {
		fiveStars.printclickFiveStarHotels();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
