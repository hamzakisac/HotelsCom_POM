package com.qa.hotelscom.test;


import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotelcom.base.BasePage;
import com.qa.hotelcom.page.HomePage;


public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	@Test(priority = 1, description = "---Verifies HomePage Title---")
	public void verifyHomePageTitle() {
		homePage = new HomePage(driver);
		homePage.getPageTitle(prop.getProperty("homePageTitle"));
	}
	
	@Test(priority=2, description="Selects destination and dates")
	public void destinationAndDate() {
		homePage.whereAndWhen(prop.getProperty("destination"));
	}
	
	@Test(priority=3, description="Sets room and people and click search btn")
	public void roomSettings() {
		homePage.roomAndPeople();
	}
	
	

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
