package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePageObject {
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/b")
	public static WebElement click_on_Admin;
	@FindBy(xpath="//*[@id=\"menu_admin_UserManagement\"]")
	public static WebElement userManagement;
	@FindBy(xpath="//*[@id=\"menu_admin_viewSystemUsers\"]")
	public static WebElement clickonusers;
	@FindBy(id="searchSystemUser_userType")
	public static WebElement select_on_userrole;
	@FindBy(id="searchSystemUser_status")
	public static WebElement select_on_status;
	@FindBy(id="searchBtn")
	public static WebElement click_on_search;
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")
	public static WebElement verifyuserrole;
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[5]")
	public static WebElement verifystatus;
}
