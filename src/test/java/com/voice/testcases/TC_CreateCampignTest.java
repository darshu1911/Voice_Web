package com.voice.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.voice.pageobjects.createCampaign;

public class TC_CreateCampignTest extends TC_LoginPageTest{

	createCampaign cC;

	@Test(priority = 2)
	public void createCampaign() throws InterruptedException 
	{
		cC = new createCampaign(driver);
		logger.info("My Campaign module is visible");

		cC.clickMyCmpgnBtn();
		logger.info("My Campaign module clicked succesfully");

		cC.clickcrtCmpgnBtn();
		logger.info("Create Campaign button clicked succesfully");

		cC.enterCmpgnName("Health Husters");
		logger.info("Campaign name entered succesfully");

		cC.selectCntctFile();
		logger.info("Contacts file uploaded succesfully");
		Thread.sleep(10000);

		cC.clickNxtBtn();
		logger.info("Next Button clicked sucessfully");

	}
	
	@Test(priority = 3)
	public void createJourney() throws InterruptedException 
	{

		String crtJrny = cC.vrifyTxt();
		System.out.println(crtJrny);

		if(crtJrny.equals("Create Journey"))
		{
			logger.info("verifyJrnyTxt - passed");
			Assert.assertTrue(true);
		}else
		{
			logger.info("verifyJrnyTxt - failed");
			captureScreenshot(driver, "verifyJrnyTxt");
			Assert.assertTrue(false);
		}

		cC.testChnlDropdown();
		logger.info("SMS Channel selected sucessfully");

		cC.testTmplteDropdown();
		logger.info("SMS template selected sucessfully");

		cC.enterDuration();
		logger.info("Duration entered sucessfully");

		cC.enterActinBttn();
		logger.info("Action button clicked succesfully");

		cC.testRmndrChnlDropdown();
		logger.info("Email channel selected sucessfully");

		cC.testRmndrTmplteDropdown();
		logger.info("Email template selected sucessfully");

		cC.enterRmndrDuration();
		logger.info("Duration entered sucessfully");

		cC.clickSubmitBttn();
		logger.info("Submit button clicked sucessfully");

		String sucesText = cC.vrifySucesTxt();
		System.out.println(sucesText);

		if(sucesText.equals("Journey created successfully"))
		{
			logger.info("vrifySucesTxt - passed");
			Assert.assertTrue(true);
		}else
		{
			logger.info("vrifySucesTxt - failed");
			captureScreenshot(driver, "vrifySucesTxt");
			Assert.assertTrue(false);
		}	
	}

}
