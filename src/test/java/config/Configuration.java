package config;

public class Configuration {

	//Configuration elements
	public static final String Report_Folder="C://Selenium_3rd_Tools//apache-tomcat-9.0.0.M13//webapps//ROOT//TestReports//";
	public static final String testsite="https://twitter.com/";


	//Xpaths


	//LoginPage
	//public static final String signIn="//*[@id='test_to_fail']/div[1]/div/div[1]/div[2]/a[3]";
	public static final String signIn="//*[@id='doc']/div[1]/div/div[1]/div[2]/a[3]";
	public static final String username="//*[@id='login-dialog-dialog']/div[2]/div[2]/div[2]/form/div[1]/input";
	public static final String passsword="//*[@id='login-dialog-dialog']/div[2]/div[2]/div[2]/form/div[2]/input";
	public static final String submitButton="//*[@id='login-dialog-dialog']/div[2]/div[2]/div[2]/form/input[1]";

	//LandingPage
	public static final String profileLink="//*[@id='page-container']/div[1]/div[1]/div/div[2]/div/a";


	//ProfilePage
	public static final String FollowingLink="//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[1]/a";
	public static final String FollowerLink="//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[2]/a";
	public static final String MomentsLink="//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[3]/a";
	public static final String EditLink="//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[5]/div/button/span";

	//EditProfilePage
	public static final String Location="//*[@id='user_location']";
	public static final String SaveChanges="//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[5]/div/div/button[1]";
	public static final String tweet="//*[@id='global-new-tweet-button']/span[2]";
	
	
	//PostTweet
	
	public static final String Compose_new_tweet="//*[@id='tweet-box-global']";
	public static final String tweet_button="//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[2]/div[2]/button";
	public static final String Home="//*[@id='global-nav-home']/a/span[2]";
	
	
	
}
