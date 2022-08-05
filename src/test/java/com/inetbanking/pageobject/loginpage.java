package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
WebDriver idriver;
public loginpage(WebDriver rdriver ){
	idriver =rdriver;
	PageFactory.initElements(rdriver, this);
	
}
@FindBy(name="uid")
WebElement username;
@FindBy(name="password")
WebElement Password;
@FindBy(name="btnLogin")
WebElement login;
@FindBy(xpath="//a[text()='Log out']")
WebElement logout;

public void setusername(String uname) {
	username.sendKeys("mngr425464");
}
public void setuserpassword(String upassword) {
	Password.sendKeys("rupyrEg");
}
public void click() {
	login.click();
}
public void logout() {
	logout.click();
}

}