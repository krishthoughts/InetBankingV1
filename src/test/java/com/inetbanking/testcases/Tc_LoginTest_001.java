package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;



public class Tc_LoginTest_001 extends Baseclass {
@Test

	public void loginTest() throws IOException {


		logger.info("url is opened");

// we have to get the username and password from the pageobjects so we are creating the object 

		Loginpage lp = new Loginpage(driver);

		lp.setUserName(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clicksubmit();
		logger.info("App opened");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))

		{
			Assert.assertTrue(true);
			System.out.println("Titlepass");
		} else {
			// if the TC fails it will capure the screenshot for code check the base class
			captureScreen( driver, "loginTest");
			Assert.assertTrue(false);
			System.out.println("Titlefail");
		}

	}

}
