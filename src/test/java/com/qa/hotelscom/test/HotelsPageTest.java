package com.qa.hotelscom.test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelcom.page.HomePage;
import com.qa.hotelcom.page.HotelsPage;

public class HotelsPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		hotelsPage = homePage.goToHotelsPage(prop.getProperty("homePageTitle"), prop.getProperty("destination"));
	}
	
	
	@Test(priority=1, description="---Verifies HotelsPage Title---")
	public void getHotelsPageTitle() {
		hotelsPage.getPageTitle(prop.getProperty("hotelsPageTitle"));
	}
	@Test(priority=2,description="Selects 3 stars and scroll down")
	public void selectStarAndScrollDownTest() throws InterruptedException{
		hotelsPage.clickStarAndScrollDown();
	}
	@Test(priority=3, description="Print all the 3 star Hilton Hotels")
	public void listHiltonHotelsTest() {
		hotelsPage.listHiltonHotels();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
