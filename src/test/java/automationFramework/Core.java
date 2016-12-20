package automationFramework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.Configuration;
import testReports.TestReports;
import util.TestUtil;


public class Core {

	public static Properties CONFIG;
	public static Properties Objects;
	public static WebDriver dr=null;
	public static WebDriver driver;
	public static int nSelPort;
	public static Random randomGenerator = new Random(); // Random Port Number generation 
	public static String strDate;
	public static Calendar cal = new GregorianCalendar();
	public static  int month = cal.get(Calendar.MONTH);
	public static int year = cal.get(Calendar.YEAR);
	public static  int sec =cal.get(Calendar.SECOND);
	public static  int min =cal.get(Calendar.MINUTE);
	public static  int date = cal.get(Calendar.DATE);
	public static  int day =cal.get(Calendar.HOUR_OF_DAY);
	String startTime=null;
/*	static ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\MyReport.html", false);
	static ExtentTest logger;
*/	
	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
	public static String Description = "Pagal";
	
	
	private String TestCaseName;
	public String testStatus;
	
	public static SoftAssert softAssert = new SoftAssert();
	
	
	
	
   public String getTCName() {
	   return TestCaseName;
   }
		
	
   public void setTCName(String TestCaseName) {
	this.TestCaseName = TestCaseName;
	}
		   
	public String getTCResult() {
		return testStatus;
	}
		
	public void setTCResult(String testStatus) {
		this.testStatus = testStatus;
	}
		   
	public static String getCurrentTimeStamp(){ 
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy"+"_"+"HH-mm-ss");
		Date now = new Date(); 
		String CDate = CurrentDate.format(now); 
		return CDate; 
	}
	
	
		
		
	
	
	public static WebElement isElementLoaded(WebElement ElementToBeLoaded){
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  WebElement element = wait.until(ExpectedConditions.visibilityOf(ElementToBeLoaded));

		  return element;
		 }	
	
	

	  @BeforeSuite
	  public void startTesting() throws Exception{
		  
		  System.setProperty("LogsDir", System.getProperty("user.dir")+"\\src\\test\\java\\logs");
		  
			System.out.println("BeforeSuite");
			nSelPort = randomGenerator.nextInt(40000);
			strDate=getCurrentTimeStamp();
			System.out.println("date time stamp :"+strDate);

			//in Config.properties !! Report_Folder=C://Selenium_3rd_Tools//apache-tomcat-9.0.0.M13//webapps//ROOT//TestReports

			TestReports.startTesting(Configuration.Report_Folder+"//"+strDate+".html",
					TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
					"Environment_Demo",
					"Release_Version_#");										
				
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			dr = new ChromeDriver();

	/*		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
			dr = new FirefoxDriver();
	*/		
			driver = new EventFiringWebDriver(dr);	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			TestReports.startSuite("Test_Suite_Name or Number");
			} 

	  @AfterSuite
	  public static void endScript() throws Exception{
		  System.out.println("AfterSuite");
		  String lastUpdated_Report = TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
		  TestReports.updateEndTime(lastUpdated_Report);

	/*	  extent.endTest(logger);
		  extent.flush();
		  driver.get("C:\\Selenium_Project\\POMFramework\\test-output\\MyReport.html");
	*/		
		  //monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.username, TestConfig.password,TestConfig.port, TestConfig.to, TestConfig.subject, TestConfig.messageBody, System.getProperty("user.dir")+"//test-output//emailable-report.html", "emailable-report.html");
			
		  driver.get("http://"+TestUtil.Handeler()+":8080/TestReports/"+strDate+".html");
		  //driver.quit();

		}

	
}