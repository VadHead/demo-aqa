package com.demoqa.pages;

import com.demoqa.Components.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class PracticeFormPage extends BasePage {
	
	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNameInput;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastNameInput;
	
	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement emailInput;
	
	@FindBy(xpath = "//div[@id='genterWrapper']//input[@value='Male']")
	private WebElement genderMaleRadio;
	
	@FindBy(xpath = "//input[@id='userNumber']")
	private WebElement userNumberInput;
	
	@FindBy(xpath = "//input[@id='dateOfBirthInput']")
	private WebElement dateOfBirthInput;
	
	@FindBy(xpath = "//div[@id='subjectsContainer']")
	private WebElement subjectInput;
	
	@FindBy(xpath = "//div[@id='hobbiesWrapper']//input[@value='1']")
	private WebElement hobbiesSportRadio;
	
	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement imageUploadInput;
	
	@FindBy(xpath = "//textarea[@id='currentAddress']")
	private WebElement currentAddressTextArea;
	
	@FindBy(xpath = "//div[@id='state']")
	private WebElement stateSelector;
	
	@FindBy(xpath = "//div[@id='city']")
	private WebElement citySelector;
	
	public PracticeFormPage selectState(String stateName) {
		stateSelector.click();
		WebElement state = driver.findElement(By.xpath(String.format("//*[text()='%s']", stateName)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", state);
		state.click();
		return this;
	}
	
	public PracticeFormPage selectCity(String cityName) {
		citySelector.click();
		WebElement city = driver.findElement(By.xpath(String.format("//*[text()='%s']", cityName)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cityName);
		city.click();
		return this;
	}
	
	public PracticeFormPage uploadTestImage() {
		File file = new File("src/main/java/com/demoqa/Data/CatTester.png");
		imageUploadInput.sendKeys(file.getAbsolutePath());
		return this;
	}
	
	public PracticeFormPage selectDate(String dayNumber, String monthName, String yearNumber) {
		dateOfBirthInput.click();
		DatePicker datePicker = new DatePicker(driver);
		datePicker
				.chooseYear(yearNumber)
				.chooseMonth(monthName)
				.chooseDay(dayNumber);
		userNumberInput.click();
		return this;
	}
	
}
