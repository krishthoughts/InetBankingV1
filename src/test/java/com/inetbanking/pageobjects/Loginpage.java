package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	// defining the driver object
	WebDriver driver;

	// defining the Constructor

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// if we use @findby we have to define this one

	}

//	Creating the pageobjects for the login page

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnlogin;
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnklogout;

	public void setUserName(String uname) {

		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		txtPassword.sendKeys(pwd);
	}

	public void clicksubmit() {

		btnlogin.click();
	}
	public void clickLogout() {

		lnklogout.click();
	}

}
