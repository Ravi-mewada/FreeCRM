package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	static LoginPage login;
	static HomePage home;
	static TestUtil testUtil;
	
	String sheetName = "contacts";

	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
		testUtil = new TestUtil();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@DataProvider
	public Object[][] getLoginTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getLoginTestData")
	public void loginTest(String userName, String password) {
		//home = login.loginSwaglabs(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("User name and Passwords are: -" + userName + " || " + password);
		home = login.loginSwaglabs(userName, password);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
