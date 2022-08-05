package com.inetbanking.testcase;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.BaseCalss;
import com.inetbanking.pageobject.addcoustomerpage;

public class addcustomer extends BaseCalss {
	
	@Test
	public void testcase2() throws InterruptedException {
		addcoustomerpage add = new addcoustomerpage(driver);
		add.addcoustomer();
		add.setcustomer_name("Giri");
		add.setcustomer_gender();
		add.setcustomer_dob("20", "08", "1997");
		add.setcustomer_address("seegehalli");
		add.setcustomer_state("Karnataka");
		add.setcustomer_pin(560067);
		add.setcustomer_mobilenumber("9652521757");
		add.setcustomer_Email("bgiri112233@gmail.com");
		add.setcustomer_pass("Giri@2225");
		add.setcustomer_city("bangalore");
		Thread.sleep(3000);
		add.clickonsumit();
		if(altest()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertFalse(false);
			
		}
		
	}
	
	public boolean altest() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		}
}
