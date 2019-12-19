package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonfunctions.CommonFunctions;
import pageobjectmodel.LoginPageObject;
import pageobjectmodel.PendingLeaveRequestPageObject;

public class PendingLeaveRequestTestCase extends CommonFunctions {
	
	Logger logger=Logger.getLogger(PendingLeaveRequestTestCase.class);
	@Test
	public void verifypendingleaverequest() throws InterruptedException, IOException {
		testcase=extentreport.createTest("pending Leave Request verify test case");
		PageFactory.initElements(driver, LoginPageObject.class);
		logger.info("Entered the username");
		testcase.log(Status.INFO, "Entered the username");
		LoginPageObject.username.sendKeys(properties.getProperty("username"));
		logger.info("Entered the password");
		testcase.log(Status.INFO, "Entered the password");
		LoginPageObject.password.sendKeys(properties.getProperty("password"));
		logger.info("clicked the Login Button");
		testcase.log(Status.INFO, "Click the login button");
		LoginPageObject.loginbutton.click();
		Thread.sleep(5000);
		PageFactory.initElements(driver, PendingLeaveRequestPageObject.class);
		logger.info("verifying pending leave request available or not");
		testcase.log(Status.INFO, "verifying pending leave request available or not");
		String text = PendingLeaveRequestPageObject.pendingleaverequest.getText();
		if(text.equals("No Records are Avaible")) {
			testcase.log(Status.PASS, "Text verified and it is matched");
		}else {
			testcase.log(Status.FAIL, "Text verified and it is not matched with expected result");
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
			File Destinationfile=new File("./test-output/screenshots/fail1.jpg");
		 FileHandler.copy(sourcefile, Destinationfile);
		 testcase.addScreenCaptureFromPath("./test-output/screenshots/fail1.jpg");
		}

	}
}
