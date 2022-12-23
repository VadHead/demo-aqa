package com.demoqa;

import com.demoqa.pages.PracticeFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FormTest extends BaseTest{
	
	private PracticeFormPage formPage;
	
	@BeforeMethod
	public void setUp() {
		driver.get("https://demoqa.com/automation-practice-form");
		formPage = new PracticeFormPage(driver);
		((JavascriptExecutor) driver).executeScript("document.getElementById('fixedban').remove();document.getElementById('Ad.Plus-728x90').remove();");
	}
	
	@Test
	public void selectTest() {
		String state = "NCR";
		String city = "Gurgaon";
		formPage
				.selectDate("13","March", "1990")
				.uploadTestImage()
				.selectState(state)
				.selectCity(city);
		assertEquals(driver.findElement(By.xpath("//div[@id='state']//div[@class=' css-1uccc91-singleValue']")).getText(), state);
		assertEquals(driver.findElement(By.xpath("//div[@id='city']//div[@class=' css-1uccc91-singleValue']")).getText(), city);
	}
	
}

