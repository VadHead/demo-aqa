package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
	
	public SliderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@type='range']")
	private WebElement rangeSlider;
	
	public SliderPage moveSliderTo(int number) {
		if (number < 0) {
			for (int i = number; i < 0; i++) {
				rangeSlider.sendKeys(Keys.ARROW_LEFT);
			}
		}
		else {
			for (int i = 0; i < number; i++) {
				rangeSlider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
		return this;
	}
	
	public int getCurrentRange() {
		return Integer.parseInt(rangeSlider.getAttribute("value"));
	}
	
}
