package com.inetbanking.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbaking.utilities.Readconfig;

public class BaseCalss {
	Readconfig rp = new Readconfig();
	public String username=rp.ApplicationUser();
	public String  password = rp.password();
	public String  URL = rp.getApplicationURL();
	public WebDriver driver;
	
	@Parameters("Brower")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",rp.Chrome());
		driver  = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\drivers\\geckodriver.exe");
			driver  = new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);

	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}


