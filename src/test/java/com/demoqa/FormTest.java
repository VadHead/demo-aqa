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
		driver.get("chrome://settings/");
		((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.7);");
		driver.get("https://demoqa.com/automation-practice-form");
		((JavascriptExecutor) driver).executeScript("document.getElementById('fixedban').remove();document.getElementById('Ad.Plus-728x90').remove();");
		formPage = new PracticeFormPage(driver);
	}
	
	@Test
	public void selectTest() {
		String firstName = "Luke";
		String secondName = "Skywalker";
		String email = "skynagibator@xwing.com";
		String maleGender = "Male";
		String mobileNumber = "1011011011";
		String subject = "Computer Science";
		String hobby = "Sports";
		String currentAddress = "Ahch-To system";
		String state = "NCR";
		String city = "Noida";
		String resultsRowXpath = "//tr//td[text()='%s']/following-sibling::td";
		
		formPage
				.fillFirstName(firstName)
				.fillLastName(secondName)
				.fillEmail(email)
				.selectGender(maleGender)
				.fillMobileNumber(mobileNumber)
				.selectDateofBirth("15","June","2100")
				.selectSubject(subject)
				.selectHobby(hobby)
				.uploadTestImage()
				.fillCurrentAddress(currentAddress)
				.selectState(state)
				.selectCity(city)
				.submit();
		
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Student Name"))).getText(),String.format("%s %s", firstName, secondName));
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Gender"))).getText(), maleGender);
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Mobile"))).getText(), mobileNumber);
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Date of Birth"))).getText(), "15 June,2100");
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Subjects"))).getText(), subject);
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Hobbies"))).getText(), hobby);
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Picture"))).getText(), "CatTester.png");
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"Address"))).getText(), currentAddress);
		assertEquals(driver.findElement(By.xpath(String.format(resultsRowXpath,"State and City"))).getText(), String.format("%s %s", state, city));
	}
	
}

