package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "(//div[contains(@class, 'inventory_item_price')])[1]")
	WebElement itemPrice;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String[] extractAllItemsPrice() {
		String allItems = "(//div[contains(@class, 'inventory_item_price')])";
		int countItems = driver.findElements(By.xpath(allItems)).size();
		String[] arr = new String[countItems];
		
		for(int i = 1; i <= countItems; i++) {
			String itemsPrice = driver.findElement(By.xpath(allItems + "[" + i + "]")).getText();
			arr[i - 1] = itemsPrice;
		}
		return arr;
	}
	
	public void printArray() {
		HomePage homePage = new HomePage();
		String [] arr = homePage.extractAllItemsPrice();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
