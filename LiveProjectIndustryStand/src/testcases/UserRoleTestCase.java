package testcases;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonfunctions.CommonFunctions;
import pageobjectmodel.UserRolePageObject;

public class UserRoleTestCase extends CommonFunctions{
	
    static Logger logger=Logger.getLogger(UserRoleTestCase.class);
	public void movetotarget() throws InterruptedException {
		logger.info("Element moved to the Admin");
		Actions actions=new Actions(driver);
		logger.info("Element moved to the Admin");
		actions.moveToElement(UserRolePageObject.click_on_Admin);
		logger.info("Element moved to the User Management");
		actions.moveToElement(UserRolePageObject.userManagement);
		logger.info("Element moved to the Users");
		actions.moveToElement(UserRolePageObject.clickonusers).click();	
		actions.click().build().perform();
	}
	public void select_user_role() {
		logger.info("Select user role in the dropdown");
		Select userrole=new Select(UserRolePageObject.select_on_userrole);
		userrole.selectByIndex(1);		
	}
	public void select_Status() {
		logger.info("Select status of the user in the dropdown");
		Select status = new Select(UserRolePageObject.select_on_status);
		status.selectByIndex(1);
	}
	@Test
	public void verifyuserroleandstatus() throws InterruptedException, IOException {
		testcase=extentreport.createTest("Verify User Role Test case");
		PageFactory.initElements(driver, UserRolePageObject.class);
		testcase.log(Status.INFO, "Element moved to the user role");
		movetotarget();
		testcase.log(Status.INFO, "Selected the user role");
		select_user_role();
		testcase.log(Status.INFO, "Selected the status");
		select_Status();
		testcase.log(Status.INFO, "clicked on the search button");
		UserRolePageObject.click_on_search.click();
		logger.info("Verifying user role value and Status value");
		testcase.log(Status.INFO, "Verifying user role");
		String actualrole = UserRolePageObject.verifyuserrole.getText();
		String actualstatus = UserRolePageObject.verifystatus.getText();
		if(actualrole.equals("Admn")) {
			testcase.log(Status.PASS, "text matched with expected result");
		}else {
			testcase.log(Status.FAIL, "text is not matched with expected result");
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
			File Destinationfile=new File("./test-output/screenshots/fail.jpg");
		 FileHandler.copy(sourcefile, Destinationfile);
		 testcase.addScreenCaptureFromPath("./test-output/screenshots/fail.jpg");
		}
		Assert.assertEquals(actualstatus, "Enabled");

	}
}
