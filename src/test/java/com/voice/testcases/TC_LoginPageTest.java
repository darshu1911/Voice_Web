package com.voice.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.voice.pageobjects.loginPage;

public class TC_LoginPageTest extends BaseClass{

	loginPage lP;

	@Test(priority = 1)
	public void verifyLogin() throws IOException
	{
		lP = new loginPage(driver);
		logger.info("Login page displayed succesfully");

		lP.enterEmailID("giri@gmail.com");
		logger.info("User entered Email ID succesfully");

		lP.enterPwdFld("voice123");
		logger.info("User entered Password succesfully");

		lP.clickSignINBtn();
		logger.info("User succesfully clicked on Sign IN button");

		String PMTxt = lP.verifyPMTxt();
		System.out.println(PMTxt);

		if (PMTxt.equals("Project Manager")) 
		{
			logger.info("verifyLogin - passed");
			Assert.assertTrue(true);
		}else
		{
			logger.info("verifyLogin - failed");
			captureScreenshot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}

	}
}
