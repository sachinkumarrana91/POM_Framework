package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import automationFramework.Core;
import config.Configuration;

public class LandingPage {


	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.profileLink)
	public WebElement profileLink;
	
	
	public ProfilePage goToProfile(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		profileLink.click();
		
		return PageFactory.initElements(driver, ProfilePage.class);
	}
	
	
	
}
