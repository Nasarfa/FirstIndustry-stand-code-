package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PendingLeaveRequestPageObject {
	@FindBy(xpath = "//*[@id=\"task-list-group-panel-menu_holder\"]/table/tbody/tr/td")
	public static WebElement pendingleaverequest;

}
