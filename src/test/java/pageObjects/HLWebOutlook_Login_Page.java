package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class HLWebOutlook_Login_Page {

	final WebDriver driver;

	@FindBy(how = How.ID, using = "username")

	public WebElement txtbx_UserName;

	@FindBy(how = How.ID, using = "password")

	public WebElement txtbx_Password;

	@FindBy(how = How.XPATH, using = "//*[@id='tblMid']/tbody/tr[7]/td/table/tbody/tr[3]/td/input[1]")

	public WebElement btn_Login ;

	public HLWebOutlook_Login_Page(WebDriver driver)

	{

		this.driver = driver;

		}

// This method will take two arguments ( Username and Password)

	public void LogIn_Action(String sUserName, String sPassword){

		txtbx_UserName.sendKeys(sUserName);

		txtbx_Password.sendKeys(sPassword);

		btn_Login.click();

	}

}