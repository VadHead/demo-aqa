package com.demoqa;

import com.demoqa.pages.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTest extends BaseTest {
	
	SliderPage sliderPage;
	
	@BeforeMethod
	public void setUp() {
		driver.get("https://demoqa.com/slider");
		sliderPage = new SliderPage(driver);
	}
	
	@Test(description = "Slider range test")
	public void sliderRangeTest() {
		int initialRange = sliderPage.getCurrentRange();
		sliderPage.moveSliderTo(15);
		assertEquals(sliderPage.getCurrentRange(), initialRange + 15);
		sliderPage.moveSliderTo(-13);
		assertEquals(sliderPage.getCurrentRange(), initialRange + 15 - 13);
		
	}
	
}
