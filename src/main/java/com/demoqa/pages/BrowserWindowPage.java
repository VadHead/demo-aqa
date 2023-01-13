package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowPage extends BasePage {
	
	public BrowserWindowPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@id='tabButton']")
	private WebElement newTabButton;
	
	@FindBy(xpath = "//button[@id='windowButton']")
	private WebElement newWindowButton;
	
	@FindBy(xpath = "//button[@id='messageWindowButton']")
	private WebElement newWindowMessageButton;
	
	String initWindowHandle = driver.getWindowHandle();
	
	public BrowserWindowPage openNewTab() {
		newTabButton.click();
		swithToNewHandle();
		return this;
	}
	
	public BrowserWindowPage openNewWindow() {
		newWindowButton.click();
		swithToNewHandle();
		return this;
	}
	
	public BrowserWindowPage openNewWindowMessage() {
		newWindowMessageButton.click();
		swithToNewHandle();
		return this;
	}
	
	public BrowserWindowPage openInitialWindow() {
		driver.switchTo().window(initWindowHandle);
		return this;
	}
	
	private BrowserWindowPage swithToNewHandle() {
		for (String windowHandle : driver.getWindowHandles()) {
			if (!initWindowHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}
		return this;
	}
	
}
