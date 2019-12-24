package mavenproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConcepts {
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
	WebDriver driver;
	
	@BeforeTest()
	public void startReport() {
		// initialize the HtmlReporter
	    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/testReport.html");
	    
	    //initialize ExtentReports and attach the HtmlReporter
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	     
	    //To add system or environment info by using the setSystemInfo method.
	    extent.setSystemInfo("OS", "Window 7");
	    extent.setSystemInfo("Browser", "Firefox 60+");
	    extent.setSystemInfo("Author", "SeleniumTester");
	    
	    //configuration items to change the look and feel
	    //add content, manage tests etc
	    //htmlReporter.config().setChartVisibilityOnOpen(true);
	    htmlReporter.config().setDocumentTitle("Extent Report Demo");
	    htmlReporter.config().setReportName("Test Report");
	    //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	
	}
	
	@AfterTest
	public void CloseBrowser() {
			driver.quit();
	    	//to write or update test information to reporter
	        extent.flush();
		}
	
	@Test(priority=1)
	public void LaunchApplication() {
			test = extent.createTest("Test Case 1", "Launch Firefox and Navigate to Firefox Driver");
			    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			 	driver = new FirefoxDriver();
			 	driver.manage().window().maximize();
		}

	@Test(priority=2)
	public void Sign_On() {
		
			test = extent.createTest("Test Case 2", "Login to Mercury Web Application");
			driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("login")).click();
		}


	@AfterMethod
	public void getResult(ITestResult result) {
	    if(result.getStatus() == ITestResult.FAILURE) {
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	        test.fail(result.getThrowable());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS) {
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	    }
	    else {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
	}

}

