package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import automationFramework.Core;
import config.Configuration;

public class EditProfilePage {

	WebDriver driver;
	
	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = Configuration.Location)
	public WebElement Location;
	
	@FindBy(how = How.XPATH , using = Configuration.SaveChanges)
	public WebElement SaveChanges;

	@FindBy(how = How.XPATH , using = Configuration.tweet)
	public WebElement tweet;
	
	public void setLocation(String place){
		Location.sendKeys(place);
	}
	
	public void saveTheChanges(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		SaveChanges.click();
		}

	public TweetPage clickTweet(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		tweet.click();

		return PageFactory.initElements(driver, TweetPage.class);
	}
		
		
}
