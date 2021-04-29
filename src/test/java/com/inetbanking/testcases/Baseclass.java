package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class Baseclass {

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getbaseURL();
	public String username = rc.getusername();
	public String password = rc.getpassword();
	public WebDriver driver;

	public static Logger logger;

	@Parameters("browser") // While executing from TEstng xml file we should define @parameter annotation
	@BeforeClass
	// system.getproperty is used to grab the path of the directory

	public void setup(String br) {

		logger = Logger.getLogger(Baseclass.class);
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getchromepath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxpath());
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

// if a testcase is failing below is the code snippet to take the screenshot

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Scrrenshot taken");
	}

	// Here we are defining a userefined method to get the random data for email ID
	// in add new customer TC
	// For evry login email should be different else wont take the duplicate ID

	
}
