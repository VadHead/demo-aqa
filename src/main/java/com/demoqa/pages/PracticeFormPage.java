package com.demoqa.pages;

import com.demoqa.Components.DatePicker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

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
	
	@FindBy(xpath = "//input[@id='userNumber']")
	private WebElement userNumberInput;
	
	@FindBy(xpath = "//input[@id='dateOfBirthInput']")
	private WebElement dateOfBirthInput;
	
	@FindBy(xpath = "//input[@id='subjectsInput']")
	private WebElement subjectInput;
	
	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement imageUploadInput;
	
	@FindBy(xpath = "//textarea[@id='currentAddress']")
	private WebElement currentAddressTextArea;
	
	@FindBy(xpath = "//div[@id='state']")
	private WebElement stateSelector;
	
	@FindBy(xpath = "//div[@id='city']")
	private WebElement citySelector;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitButton;
	
	public PracticeFormPage fillFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
		return this;
	}
	
	public PracticeFormPage fillLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
		return this;
	}
	
	public PracticeFormPage fillEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}
	
	public PracticeFormPage selectGender(String gender) {
		WebElement genderRadio = driver.findElement(
				By.xpath(String.format("//div[@id='genterWrapper']//label[text()='%s']", gender)));
		genderRadio.click();
		return this;
	}
	
	public PracticeFormPage fillMobileNumber(String number) {
		userNumberInput.sendKeys(number);
		return this;
	}
	
	public PracticeFormPage selectDateofBirth(String dayNumber, String monthName, String yearNumber) {
		dateOfBirthInput.click();
		DatePicker datePicker = new DatePicker(driver);
		datePicker
				.chooseYear(yearNumber)
				.chooseMonth(monthName)
				.chooseDay(dayNumber);
		userNumberInput.click();
		return this;
	}
	
	public PracticeFormPage selectSubject(String subject) {
		subjectInput.sendKeys(subject);
		subjectInput.sendKeys(Keys.ENTER);
		return this;
	}
	
	public PracticeFormPage selectHobby(String hobby) {
		WebElement hobbyRadio = driver.findElement(
				By.xpath(String.format("//div[@id='hobbiesWrapper']//label[text()='%s']", hobby)));
		hobbyRadio.click();
		return this;
	}
	
	public PracticeFormPage uploadTestImage() {
		File file = new File("src/main/java/com/demoqa/Data/CatTester.png");
		imageUploadInput.sendKeys(file.getAbsolutePath());
		return this;
	}
	
	public PracticeFormPage fillCurrentAddress(String address) {
		currentAddressTextArea.sendKeys(address);
		return this;
	}
	
	public PracticeFormPage selectState(String stateName) {
		scrollIntoView(stateSelector);
		stateSelector.click();
		WebElement state = driver.findElement(By.xpath(String.format("//div[@id='state']//*[text()='%s']", stateName)));
		scrollIntoView(state);
		state.click();
		return this;
	}
	
	public PracticeFormPage selectCity(String cityName) {
		scrollIntoView(citySelector);
		citySelector.click();
		WebElement city = driver.findElement(By.xpath(String.format("//*[text()='%s']", cityName)));
		scrollIntoView(city);
		city.click();
		return this;
	}
	
	public PracticeFormPage submit() {
		submitButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(2))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
		return this;
	}
	
	private PracticeFormPage scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		return this;
	}
	
}
