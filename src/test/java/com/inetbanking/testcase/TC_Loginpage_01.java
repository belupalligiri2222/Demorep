package com.inetbanking.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.BaseCalss;
import com.inetbanking.pageobject.loginpage;

public class TC_Loginpage_01 extends BaseCalss{
	
	@Test
	public void login() throws Exception {
		
		loginpage log = new loginpage(driver);
		log.setusername(username);
		log.setuserpassword(password);
		Thread.sleep(3000);
		log.click();
		Thread.sleep(3000);
		if(driver.getTitle().equals("Guru Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);

		}
		
	}

}
