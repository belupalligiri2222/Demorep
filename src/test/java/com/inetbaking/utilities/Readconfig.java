package com.inetbaking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig() {
		try {
		File src = new File("./configaration/conf.Properties");
		
		
	   FileInputStream fis = new FileInputStream(src);	
	    pro = new Properties();
	    pro.load(fis);
	}
	catch(Exception e) {
		System.out.println("Excepation is"+e.getMessage());
		}
	    
}
	public String getApplicationURL() {
		String Url = pro.getProperty("baseURL");
		return Url;
	}
	public String ApplicationUser() {
		String use = pro.getProperty("User");
		return use;
	}
	public String password() {
		String pass = pro.getProperty("pass");
		return pass;
	}
	public String Chrome() {
		
		String chromepath="C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\drivers\\chromedriver.exe";
	return chromepath;
}
}