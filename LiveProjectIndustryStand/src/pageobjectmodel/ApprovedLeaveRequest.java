package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApprovedLeaveRequest {

	@FindBy(xpath="//*[@id=\"menu_leave_viewLeaveModule\"]/b")
public static WebElement clickonLEave;
	@FindBy(linkText="Leave List")
	public static WebElement clickonleavelist;
	@FindBy(id="calFromDate")
	public static WebElement fromdate;
	@FindBy(id="calToDate")
	public static WebElement todate;
	@FindBy(xpath="//*[@id=\"leaveList_chkSearchFilter_2\"]")
	public static WebElement clickonscheduled;
	@FindBy(xpath="//*[@id=\"leaveList_chkSearchFilter_1\"]")
	public static WebElement uncheckpending;
	@FindBy(xpath="//*[@id=\"leaveList_txtEmployee_empName\"]")
	public static WebElement enteremployeename;
	@FindBy(id="btnSearch")
	public static WebElement clickonsearch;
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[7]/span/img")
	public static WebElement clickoncommentbox;
	@FindBy(id="leaveComment")
	public static WebElement entercommentbox;
	@FindBy(id="commentSave")
	public static WebElement clickonsave1;
	@FindBy(xpath="//*[@id=\"select_leave_action_11\"]")
	public static WebElement selectaction;
	@FindBy(name="btnSave")
	public static WebElement clickonsave2;
}
