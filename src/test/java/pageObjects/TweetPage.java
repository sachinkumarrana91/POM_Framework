package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationFramework.Core;
import config.Configuration;

public class TweetPage {
	
	
	WebDriver driver;
	
	public TweetPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = Configuration.Compose_new_tweet)
	public WebElement Compose_new_tweet;

	@FindBy(how = How.XPATH , using = Configuration.tweet_button)
	public WebElement tweet_button;

	public void WriteTweet(String writeThis){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		Core.isElementLoaded(Compose_new_tweet).sendKeys(writeThis);
		}

	public void SubmitTweet(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		tweet_button.click();
		}



}
