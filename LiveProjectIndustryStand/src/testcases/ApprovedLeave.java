package testcases;

import java.nio.channels.AcceptPendingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonfunctions.CommonFunctions;
import pageobjectmodel.ApprovedLeaveRequest;

public class ApprovedLeave extends CommonFunctions {
	
public void movedtoelement() {
	Actions action = new Actions(driver);
	action.moveToElement(ApprovedLeaveRequest.clickonLEave);
	action.moveToElement(ApprovedLeaveRequest.clickonleavelist);
	action.click().build().perform();
}
public void selectfromdate_todate(){
	ApprovedLeaveRequest.fromdate.clear();
	ApprovedLeaveRequest.fromdate.sendKeys("19-12-2019");
	ApprovedLeaveRequest.todate.clear();
	ApprovedLeaveRequest.todate.sendKeys("26-12-2019");
	
}
public void showleavewithstatus() {
	ApprovedLeaveRequest.uncheckpending.click();
	ApprovedLeaveRequest.clickonscheduled.click();
}
public void enteremployeename() {
	ApprovedLeaveRequest.enteremployeename.sendKeys("Polaris Royal");
	ApprovedLeaveRequest.clickonsearch.click();
	
}
public void valueenterincommentbox() {
	ApprovedLeaveRequest.clickoncommentbox.click();
	ApprovedLeaveRequest.entercommentbox.sendKeys("I fnjnnjj njnn");
	ApprovedLeaveRequest.clickonsave1.click();
}
@Test
public void selectactions() throws InterruptedException {
	testcase=extentreport.createTest("Approved Pending Leave Request");
	PageFactory.initElements(driver, ApprovedLeaveRequest.class);
	testcase.log(Status.INFO, "Element moved to the Leave List");
	movedtoelement();
	testcase.log(Status.INFO, "From date and To date ");
	selectfromdate_todate();
	testcase.log(Status.INFO, "Selected the show level");
	showleavewithstatus();
	testcase.log(Status.INFO, "Entered the Employee Name");
	enteremployeename();
	testcase.log(Status.INFO, "Entered values in the comment box");
	valueenterincommentbox();
	testcase.log(Status.INFO, "Selected Action is cancelled");
	((JavascriptExecutor) driver).executeScript("Scroll(0,400)");
	Select select = new Select(ApprovedLeaveRequest.selectaction);
	select.selectByIndex(1);
	ApprovedLeaveRequest.clickonsave2.click();

}
}
