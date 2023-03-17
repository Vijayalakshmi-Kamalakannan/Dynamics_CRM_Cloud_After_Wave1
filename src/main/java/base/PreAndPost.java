package base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import events.WebDriverEvents;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DataInputProvider;

public class PreAndPost extends WebDriverEvents
{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties properties = new Properties();
	private static String reportFileName = "Test-Automation-Report";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
	static String timeStamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_a").format(new Date());
	private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName+timeStamp+".html";
	public static String URL;

	//Extent Report Initialization
	
	@BeforeSuite
	public static void setUp() throws Exception
	{
		properties.load(new FileInputStream(new File("./src/test/resources/environment.properties")));	
		//read excel file
		String sExcelFilePath=System.getProperty("user.dir")+"\\data\\"+properties.getProperty("DataFile");
		DataInputProvider.setExcelFile(sExcelFilePath,properties.getProperty("DriverSheetName"));
		URL=DataInputProvider.getCellData_ColName(1, "Environment",properties.getProperty("DriverSheetName"));
		String fileName = getReportPath(reportFilepath);
	

		htmlReporter = new ExtentHtmlReporter(fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", URL); 
		extent.setSystemInfo("Browser", "Chrome");  
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setReportName("CRM Automation Test Results");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	//Initiate webdriver
	public void beforeMethod() throws Exception { 
		
		properties.load(new FileInputStream(new File("./src/test/resources/environment.properties")));
		
		webdriver = (RemoteWebDriver) WebDriverManager.chromedriver().create();
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src\\test\\resources\\chromedriver.exe"); webdriver = new ChromeDriver();
		 */
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		tlDriver.set(driver);		
		getDriver().manage().window().maximize();
		getDriver().get(URL);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}


	//Create the report path
	private static String getReportPath (String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!" );
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Test results report directory already exists: " + path);
		}
		return reportFileLocation;
	}

	public void getUrl() {
		getDriver().get(URL);
	}
	public void closeAllBrowsers()
	{
		try {
			getDriver().quit();
			test.log(Status.PASS, "The opened browsers are closed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unexpected error occured in Browser");
		}
	}
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
}
