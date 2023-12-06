package com.crm.qa.pages;

import java.util.Arrays;

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

	public static Double[] extractAllItemsPrice() {
		String allItems = "(//div[contains(@class, 'inventory_item_price')])";
		int countItems = driver.findElements(By.xpath(allItems)).size();
		String[] arr = new String[countItems];
		Double[] darr = new Double[arr.length];

		for (int i = 1; i <= countItems; i++) {
			String itemsPrice = driver.findElement(By.xpath(allItems + "[" + i + "]")).getText();
			arr[i - 1] = itemsPrice;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].replace("$", "");
			darr[i] = Double.parseDouble(arr[i]);
		}

		Arrays.sort(darr);

		for (int i = darr.length - 1; i >= 0; i--) {
			System.out.print(darr[i] + " ");
		}
		System.out.println();

		return darr;
	}

	public void AscendingOrder() {
		Double[] arr = extractAllItemsPrice();
		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print("$" + arr[i] + " ");
		}
		System.out.println();
	}

	public void DescendingOrder() {
		Double[] arr = extractAllItemsPrice();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print("$" + arr[i] + " ");
		}
		System.out.println();
	}

}
