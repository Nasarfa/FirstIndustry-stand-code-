package commonfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonFunctions {

	public static Properties properties=null;
	public static WebDriver driver=null;
    public static ExtentReports extentreport;
    public static ExtentHtmlReporter htmlreport;
    public static ExtentTest testcase;
    Logger logger=Logger.getLogger(CommonFunctions.class);
	public Properties propertiesload() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;

	}
	@BeforeSuite
	public void launchbroweser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Propertie File Loading");
		propertiesload();
		String browser = properties.getProperty("browser");
		String driverlocation = properties.getProperty("Driverlocation");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password=properties.getProperty("password");
		extentreport=new ExtentReports();
		htmlreport=new ExtentHtmlReporter("ExtentReport.html");
		extentreport.attachReporter(htmlreport);
		if(browser.equalsIgnoreCase("chrome")){ 
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			logger.info("Web Browser Launching");
			System.setProperty("webdriver.gecko.driver", driverlocation);
			driver=new FirefoxDriver();
		}
		logger.info("Browser maximise");
		driver.manage().window().maximize();
		logger.info("Url Navigated to the Login HRM Page");
		driver.get(url);
	}
	@AfterSuite
	public void teardown() {
		logger.info("Test Case executed successfully and Browser exist");
		extentreport.flush();
    driver.quit();
	}



}
