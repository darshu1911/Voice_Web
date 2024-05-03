package com.voice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "email")
	WebElement emailIDFld;

	@FindBy(name = "password")
	WebElement pwdFld;

	@FindBy(xpath  = "//button[normalize-space()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//a[@class='waves-effect waves-light']//span[contains(text(),'Project Manager')]")
	WebElement PMTxt;

	public void enterEmailID(String emailID) 
	{
		emailIDFld.sendKeys(emailID);
	}

	public void enterPwdFld( String Pwd) 
	{
		pwdFld.sendKeys(Pwd);
	}

	public void clickSignINBtn() 
	{
		signInBtn.click();
	}
	
	public String verifyPMTxt() 
	{
		String txt = PMTxt.getText();
		return txt;
		
	}

}
