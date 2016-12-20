package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import automationFramework.Core;
import config.Configuration;

public class ProfilePage {

	WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = Configuration.FollowingLink)
	public WebElement FollowingLink;
	
	@FindBy(how = How.XPATH , using = Configuration.FollowerLink)
	public WebElement FollowerLink;

	@FindBy(how = How.XPATH , using = Configuration.MomentsLink)
	public WebElement MomentsLink;
	
	@FindBy(how = How.XPATH , using = Configuration.EditLink)
	public WebElement EditLink;
	

	public void goToFollowing(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		FollowingLink.click();
	}

	public void goToFollower(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		FollowerLink.click();
	}

	public void goToMoments(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		MomentsLink.click();
	}
	
	public EditProfilePage goToEditProfile(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		if(Core.isElementLoaded(EditLink).isEnabled()){
			EditLink.click();
		}
		
		

		return PageFactory.initElements(driver, EditProfilePage.class);
	}
}
