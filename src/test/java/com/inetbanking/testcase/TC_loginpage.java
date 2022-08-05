package com.inetbanking.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.BaseCalss;
import com.inetbanking.pageobject.loginpage;

public class TC_loginpage {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\drivers\\chromedriver.exe");
		driver  = new ChromeDriver();
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@Test
	public void test() throws Exception {
		driver.get("https://demo.guru99.com/v4/manager/Managerhomepage.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("name")).sendKeys("Giri");
		Thread.sleep(3000);
       driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).click();
       driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("20-08-1996");
		Thread.sleep(3000);

	  }
	}
	


