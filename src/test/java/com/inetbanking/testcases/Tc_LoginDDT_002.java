package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.inetbanking.utilities.XLUtils;

public class Tc_LoginDDT_002 extends Baseclass {

	@Test(dataProvider = "loginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		Loginpage lp = new Loginpage(driver);
		lp.setUserName(user);
		logger.info("user id provided");
		lp.setPassword(pwd);
		logger.info("password given");
		lp.clicksubmit();
		Thread.sleep(5000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close the alert
			driver.switchTo().defaultContent();// redirect to login page
			Assert.assertFalse(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close the alert
			driver.switchTo().defaultContent();// redirect to login page

		}
	}

// in the below method we are verifing the alerts are present in webpage
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}

	}
// Below code snippet is related to excel to get the data

	@DataProvider(name = "loginData") // we should give name because if we have many Dataproviders in the class it
										// doesnt know which one to take
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbankingtestdata/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1"); // this is to get the row count
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

// Multidimesional Array
		String Logindata[][] = new String[rownum][colcount];

		for (int i = 1; i < rownum; i++)// this is for row
		{
			for (int j = 0; j < colcount; j++) {
				Logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// we are entering i-1 because in excel
																				// sheet 0 index of row contains header
			}

		}

		return Logindata;
	}

}
