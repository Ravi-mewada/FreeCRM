package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	static LoginPage login;
	static HomePage homePage;
	static TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		login = new LoginPage();
		homePage = login.loginSwaglabs(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void getAllItemsPriceAccending() {
		homePage.AscendingOrder();
	}
	
	@Test
	public void getAllItemsPriceDesccending() {
		homePage.DescendingOrder();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
