package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Addnewcustomer;
import com.inetbanking.pageobjects.Loginpage;

public class Tc_Addcustomer_002 extends Baseclass {
	@Test
	public void addNewcustomer() throws InterruptedException, IOException {
		// we have to call with login details.

		Loginpage lp = new Loginpage(driver);
		lp.setUserName(username);
		logger.info("Entered the Username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clicksubmit();

		Thread.sleep(3000);

		Addnewcustomer nc = new Addnewcustomer(driver);
		nc.clickAddNewCustomer();
		logger.info("Button Clicked");
		nc.custName("krish");
		logger.info("enterd cust.name");
		nc.custgender("male");
		logger.info("Selected Gender");
		nc.custdob("28", "07", "1990");
		logger.info("Selected the DOB");
		Thread.sleep(3000);
		nc.custaddress("India");
		logger.info("Entered the Address");
		nc.custcity("Hyd");
		logger.info("Selected the city");
		nc.custstate("AP");
		logger.info("Selected the state");
		nc.custpinno("524002");
		logger.info("Entered the Pinno");
		nc.custtelephoneno("9966460945");
		logger.info("Entered the Ph.no");

		String emailid = randomstring() + "kyrjehr@gmail.com";
		nc.custemailid(emailid);
		logger.info("Entered the email");
		nc.custpassword("abcde");
		logger.info("Entered the password");
		nc.custsubmit();
		logger.info("Clicked the submit button");

		Thread.sleep(3000);
		// after creating the account we are verifying true or false

		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "addNewcustomer");
			Assert.assertTrue(false);
		}

	}

	public String randomstring() {

		String generatedstring = RandomStringUtils.randomAlphabetic(0);

		return generatedstring;

	}

	

	}


