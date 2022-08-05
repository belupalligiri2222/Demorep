package com.inetbanking.testcase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbaking.utilities.ExcelUtilities;
import com.inetbanking.pageobject.BaseCalss;
import com.inetbanking.pageobject.loginpage;

public class TC_DDT_002 extends BaseCalss {
	@Test(dataProvider="Logindata")
	public void loginDDT(String user,String pass) throws InterruptedException {
		loginpage l = new loginpage(driver);
		l.setusername(user);
		l.setuserpassword(pass);
		l.click();
		Thread.sleep(3000);
		if(isalertpresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
			
		}
		else {
			Assert.assertTrue(true);
			l.logout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	public boolean isalertpresent() {
		
		try {
		driver.switchTo().alert();
		return true;
	}
	catch(NoAlertPresentException e) {
		return false;
	}
	}
	
	
	
	
	@DataProvider(name="Logindata")
String[][] getData() throws IOException{
		
		
		String path = "C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\src\\test\\java\\com\\inetbanking\\testdata\\Book1.xlsx";
		int row =ExcelUtilities.getrowCount(path, "Sheet1");
		int cell =ExcelUtilities.getcellcount(path, "Sheet1", 1);
		
		String logindata[][] = new String[row][cell];
		
	for(int i=1;i<=row;i++) {
		
		for(int j=0;j<cell;j++) {
			logindata[i-1][j]=ExcelUtilities.getcelldata(path, "Sheet1", i, j);
		}
	}
	return logindata;
}
	
	
	
}
