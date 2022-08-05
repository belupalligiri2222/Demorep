package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flikart {
	
	WebDriver idriver;
	public Flikart(WebDriver rdriver ){
		idriver =rdriver;
		PageFactory.initElements(rdriver, this);

}
	@FindBy(xpath="//div[text()='Home']")
	WebElement homeoption;
	
	public void sethomes() {
		Actions a = new Actions(idriver);
		a.moveToElement(homeoption);
	}
}