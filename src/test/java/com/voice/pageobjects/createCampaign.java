package com.voice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createCampaign {

	WebDriver ldriver;

	public createCampaign(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='/campaignList']")
	WebElement myCmpgnBtn;

	@FindBy(xpath = "//button[normalize-space()='Create Campaign']")
	WebElement crtCmpgnBtn;

	@FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-invalid']")
	WebElement cmpgnNameFld;


	@FindBy(xpath = "//span[@class='textLink']")
	WebElement sbsrbList;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement nxtBtn;
	
	@FindBy(xpath = "//h5[normalize-space()='Create Journey']")
	WebElement jrnyTxt;
	
	@FindBy(xpath = "//select[@name='contentType']")
	WebElement channelDrpDwn;
	
	@FindBy(xpath = "//select[@formcontrolname='template_id']")
	WebElement tmplteDrpdwn;
	
	@FindBy(xpath = "//div[@class='row accordion-bg']//div[@class='col-md-2']//div[@class='form-group']//div//input[@type='number']")
	WebElement durtnTxtFld;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
	WebElement actionBttn;
	
	@FindBy(xpath = "//select[@formcontrolname='conditional_contentType']")
	WebElement remndrChnlDrpDwn;
	
	@FindBy(xpath = "//select[@formcontrolname='conditional_template_id']")
	WebElement rmndrTmplteDrpdwn;
	
	@FindBy(xpath = "//div[@class='row ng-untouched ng-pristine ng-invalid ng-star-inserted']//div[@class='col-md-2']//div[@class='form-group']//div//input[@type='number']")
	WebElement rmndrDurtnTxtFld;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement sbmtBttn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement sucessText;
	
	
	public void clickMyCmpgnBtn() 
	{
		myCmpgnBtn.click();
	}

	public void clickcrtCmpgnBtn() 
	{
		crtCmpgnBtn.click();
	}

	public void enterCmpgnName(String name) 
	{
		cmpgnNameFld.sendKeys(name);
	}

	public void selectCntctFile() 
	{
		sbsrbList.click();
	}

	public void clickNxtBtn()
	{
		nxtBtn.click();
	}
	
	public String vrifyTxt() 
	{
		String Txt = jrnyTxt.getText();
		return Txt;		
	}
	
	public void testChnlDropdown() 
	{
		Select Chnldrpdwn = new Select(channelDrpDwn);
		Chnldrpdwn.selectByValue("SMS");
	}
	
	public void testTmplteDropdown() 
	{
		Select Tmpltedrpdwn = new Select(tmplteDrpdwn);
		Tmpltedrpdwn.selectByIndex(1);
	}
	
	public void enterDuration() 
	{
		durtnTxtFld.sendKeys("3");
	}
	
	public void enterActinBttn() 
	{
		actionBttn.click();
	}
	
	public void testRmndrChnlDropdown() 
	{
		Select Chnldrpdwn = new Select(remndrChnlDrpDwn);
		Chnldrpdwn.selectByValue("EMAIL");
	}
	
	public void testRmndrTmplteDropdown() 
	{
		Select Tmpltedrpdwn = new Select(rmndrTmplteDrpdwn);
		Tmpltedrpdwn.selectByIndex(2);
	}
	
	public void enterRmndrDuration() 
	{
		rmndrDurtnTxtFld.sendKeys("5");
	}
	
	public void clickSubmitBttn() 
	{
		sbmtBttn.click();
	}
	
	public String vrifySucesTxt() 
	{
		String scsTxt = sucessText.getText();
		return scsTxt;		
	}

}
