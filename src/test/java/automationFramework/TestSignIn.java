package automationFramework;

import java.io.IOException;

import pageObjects.EditProfilePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import testReports.TestReports;
import util.TestUtil;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import config.Configuration;

public class TestSignIn extends Core{

	@BeforeTest
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
		System.out.println("BeforeTest in TestSignIn");
	}

	@Test
	public void doSignIn() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			driver.get(Configuration.testsite);
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			LandingPage lndPage = lp.doLogin("poojasen537","Dummy@poojasen537");

			ProfilePage pp = lndPage.goToProfile();
			pp.goToFollowing();
			
			pp.goToFollower();
			pp.goToMoments();
			
			EditProfilePage epp = pp.goToEditProfile();
			epp.setLocation("Noida");
			epp.saveTheChanges();
			epp.clickTweet();
			
			Description = "Pass";
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Passed");
			Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Description = "Fail : "+e.getMessage();
			APPLICATION_LOGS.debug("Test Case: "+getTCName()+" Failed and error message is : "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
  
  @AfterTest
  	public void AfterMethod() throws IOException{
		System.out.println("Start AfterTest in TestSignIn");
	  try{	
		  String ScreenShotPath = TestUtil.captureScreenshot(driver, getTCResult());
		  TestReports.addTestCase(getTCName(), 
				  startTime, 
				  TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
				  Description.substring(0, 4), 	
				  ScreenShotPath,
				  Description);  
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	  
  }
  
  
}