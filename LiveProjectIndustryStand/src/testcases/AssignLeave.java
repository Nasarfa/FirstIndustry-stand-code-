package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonfunctions.CommonFunctions;
import pageobjectmodel.AssignLeaveRequestPageObject;


public class AssignLeave extends CommonFunctions {
	Logger logger=Logger.getLogger(AssignLeave.class);
	public void movetoelement() {
		logger.info("Element moved to the Leave");
		Actions actions=new Actions(driver);
		actions.moveToElement(AssignLeaveRequestPageObject.clickonleave);
		logger.info("Element moved to the assign leave");
		actions.moveToElement(AssignLeaveRequestPageObject.assignleave);
		actions.click().build().perform();
	}
	public void entername() {
		logger.info("Entered employee name");
		AssignLeaveRequestPageObject.enteremployeename.sendKeys("Polaris Royal");

	}
	public void selectonleavetype() {
		logger.info("Selected leave type");
		Select select = new Select(AssignLeaveRequestPageObject.selectleavetype);
		select.selectByIndex(1);
	}
	public void select_fromdate_todate() {
		logger.info("selected from date");
		AssignLeaveRequestPageObject.fromdate.clear();
		AssignLeaveRequestPageObject.fromdate.sendKeys("19-12-2019");
		logger.info("selected from todate");
		AssignLeaveRequestPageObject.todate.clear();
		AssignLeaveRequestPageObject.todate.sendKeys("26-12-2019");
	}
	public void commentbox() {
		logger.info("clicked the comment box and entered value");
		AssignLeaveRequestPageObject.commentbox.sendKeys("i am going to paternity leave above mentionn date please approve my request");	
	}
	public void clickonassign() {
		logger.info("clicked the assign button");
		AssignLeaveRequestPageObject.assign.click();
	}
	public void confirm() {
		logger.info("click on confirm button");
		AssignLeaveRequestPageObject.confirmbutton.click();
	}

	@Test
	public void addedleaverequest() {
		testcase=extentreport.createTest("Assign Leave function test case");
		PageFactory.initElements(driver,AssignLeaveRequestPageObject.class);
		testcase.log(Status.INFO, "Element Moved to assign leave");
		movetoelement();
		testcase.log(Status.INFO,"Entered the user name");
		entername();
		testcase.log(Status.INFO, "Selected the Leave type");
		selectonleavetype();
		testcase.log(Status.INFO,"Selected From date & To Date in Respective field");
		select_fromdate_todate();
		testcase.log(Status.INFO, "Enetered additional detail in the comment box");
		commentbox();
		testcase.log(Status.INFO, "Assign button clicked");
		clickonassign();
		testcase.log(Status.INFO, "Clicked the Confirm button");
		confirm();


	}
}
