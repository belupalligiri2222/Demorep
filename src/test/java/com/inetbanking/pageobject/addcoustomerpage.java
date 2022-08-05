package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addcoustomerpage {
	
WebDriver idriver;

public addcoustomerpage(WebDriver rdriver){
	idriver=rdriver;
	PageFactory.initElements(idriver, this);
}
@FindBy(xpath="//a[text()='New Customer']")
WebElement add;
@FindBy(name="name")
WebElement name;
@FindBy(xpath="\"//tbody/tr[5]/td[2]/input[1]\"")
WebElement gender;
@FindBy(xpath="//input[@id='dob']")
WebElement dob;
@FindBy(xpath="//tbody/tr[7]/td[2]/textarea[1]")
WebElement address;
@FindBy(xpath=" //tbody/tr[8]/td[2]/input[1]")
WebElement city;
@FindBy(xpath=" //tbody/tr[9]/td[2]/input[1]")
WebElement state;
@FindBy(xpath="//tbody/tr[10]/td[2]/input[1]")
WebElement pin;
@FindBy(xpath="//tbody/tr[11]/td[2]/input[1]")
WebElement moblie;
@FindBy(xpath="//tbody/tr[12]/td[2]/input[1]")
WebElement Email;
@FindBy(xpath="//tbody/tr[13]/td[2]/input[1]")
WebElement pass;
@FindBy(xpath="//tbody/tr[14]/td[2]/input[1]")
WebElement submit;

public void addcoustomer() {
	add.click();
}
public void setcustomer_name(String cname) {
	name.sendKeys(cname);

}
public void setcustomer_gender() {
	name.click();
		
}
public void setcustomer_dob(String dd, String mm, String yyyy) {
	dob.sendKeys(dd);
	dob.sendKeys(mm);
	dob.sendKeys(yyyy);

}

public void setcustomer_address(String addess) {
	address.sendKeys(addess);

}
public void setcustomer_city(String ccity)  {
	city.sendKeys(ccity);

}

public void setcustomer_state(String c_state) {
	state.sendKeys(c_state);

}
public void setcustomer_pin(int Cpin) {
	pin.sendKeys(String.valueOf(Cpin));

}
public void setcustomer_mobilenumber(String Cmoblie) {
	moblie.sendKeys(Cmoblie);

}
public void setcustomer_pass(String passwords) {
	pass.sendKeys(passwords);

}
public void setcustomer_Email(String email) {
	Email.sendKeys(email);

}
public void clickonsumit() {
	submit.click();

}







}