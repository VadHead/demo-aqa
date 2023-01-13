package com.demoqa;

import com.demoqa.pages.BrowserWindowPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrowserWindowsTest extends BaseTest {
	
	BrowserWindowPage browserWindowPage;
	
	@BeforeMethod
	public void setUp() {
		driver.get("https://demoqa.com/browser-windows");
		browserWindowPage = new BrowserWindowPage(driver);
	}
	
	@Test(description = "Open Chrome new Tab test")
	public void openTabTest() {
		browserWindowPage.openNewTab();
		assertEquals(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText(), "This is a sample page");
		browserWindowPage.openInitialWindow();
		assertEquals(driver.getTitle(), "ToolsQA");
		
	}
	
	@Test(description = "Open Chrome new Window test")
	public void openWindowTest() {
		browserWindowPage.openNewWindow();
		assertEquals(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText(), "This is a sample page");
		browserWindowPage.openInitialWindow();
		assertEquals(driver.getTitle(), "ToolsQA");
		
	}
	
	@Test(description = "Open Chrome new Window Message test")
	public void openWindowMessageTest() {
		browserWindowPage.openNewWindowMessage();
		browserWindowPage.openInitialWindow();
		assertEquals(driver.getTitle(), "ToolsQA");
	}
	
}
