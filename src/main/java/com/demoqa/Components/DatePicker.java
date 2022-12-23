package com.demoqa.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DatePicker extends BaseComponent {
	
	private final Select yearSelect = new Select(driver.findElement(By.cssSelector("[class='react-datepicker__year-select']")));
	private final Select monthSelect = new Select(driver.findElement(By.cssSelector("[class='react-datepicker__month-select']")));
	
	public DatePicker(WebDriver driver) {
		super(driver);
	}
	
	public DatePicker chooseDay(String dayNumber) {
		String dayXPath = "//div[@class='react-datepicker__month']//div[text()='%s']";
		WebElement dayElement = driver.findElement(By.xpath(String.format(dayXPath, dayNumber)));
		dayElement.click();
		return this;
	}
	
	public DatePicker chooseMonth(String monthName) {
		monthSelect.selectByVisibleText(monthName);
		return this;
	}
	
	public DatePicker chooseYear(String yearNumber) {
		yearSelect.selectByVisibleText(yearNumber);
		return this;
	}
	
}
