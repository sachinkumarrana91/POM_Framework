package automationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import config.Configuration;
import pageObjects.EditProfilePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;



public class Twit_Run {
	public static WebDriver driver = null;
	
	
	
	public static void main(String... xsftvsckscjsc) throws IOException{
		
		try{
		
		
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Configuration.testsite);

		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		LandingPage lndPage = lp.doLogin("poojasen537","218785@Java");
		ProfilePage pp = lndPage.goToProfile();
		pp.goToFollowing();
		pp.goToFollower();
		pp.goToMoments();
		EditProfilePage epp = pp.goToEditProfile();
		epp.setLocation("Noida");
		epp.saveTheChanges();
		driver.quit();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		}

		
	
	
	
	
	
	
	
	
}
