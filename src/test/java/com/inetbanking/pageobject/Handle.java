package com.inetbanking.pageobject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handle {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

}
	@Test
	public void Test() throws Exception {
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys("Giri");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Thread.sleep(3000);

	WebElement	select =driver.findElement(By.id("course"));
		Select s = new Select(select);
		Thread.sleep(3000);
   
		s.selectByVisibleText("Java");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		Thread.sleep(3000);


		


	}
	
	
	
	
	
	
	
	
}