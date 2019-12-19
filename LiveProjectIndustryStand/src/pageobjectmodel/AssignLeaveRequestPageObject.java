package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignLeaveRequestPageObject {
	@FindBy(xpath="//*[@id=\"menu_leave_viewLeaveModule\"]/b")
	public static WebElement clickonleave;
	@FindBy(xpath="//*[@id=\"menu_leave_assignLeave\"]")
	public static WebElement assignleave;
	@FindBy(xpath="//*[@id=\"assignleave_txtEmployee_empName\"]")
	public static WebElement enteremployeename;
	@FindBy(id="assignleave_txtLeaveType")
	public static WebElement selectleavetype;
	@FindBy(xpath="//*[@id=\"assignleave_txtFromDate\"]")
	public static WebElement fromdate;
	@FindBy(xpath="//*[@id=\"assignleave_txtToDate\"]")
	public static WebElement todate;
	@FindBy(id="assignleave_txtComment")
	public static WebElement commentbox;
	@FindBy(id="assignBtn")
	public static WebElement assign;
	@FindBy(id="confirmOkButton")
	public static WebElement confirmbutton;
}
