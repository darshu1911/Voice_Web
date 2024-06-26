package com.voice.testcases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.voice.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig rc = new ReadConfig();
	String url = rc.getBaseUrl();
	String browser = rc.getBrowser();
	public static WebDriver driver;
	public static Logger logger;

	@BeforeTest
	public void setUp() 
	{

		switch(browser.toLowerCase())
		{
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case"msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver =null;
			break;
		}
		//implicitwait of 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		//Window maximize
		driver.manage().window().maximize();

		//for logging
		logger = LogManager.getLogger("Voice");
		
		//open url
				driver.get(url);
				logger.info("Url oepned");
	}

	@AfterTest
	public void tearDown() 
	{
//		driver.close();
//		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testName) {
        try {
            // Step 1: Convert WebDriver object to TakeScreenshot interface
            TakesScreenshot screenshot = ((TakesScreenshot) driver);

            // Step 2: Call getScreenshotAs method to create image file
            File src = screenshot.getScreenshotAs(OutputType.FILE);

            File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

            // Step 3: Copy image file to destination
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            logger.error("Error occurred while capturing screenshot: " + e.getMessage());
        }
	}
}