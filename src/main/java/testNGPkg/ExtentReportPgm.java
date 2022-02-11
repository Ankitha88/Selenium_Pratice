package testNGPkg;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportPgm {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	WebDriver driver=null;

	@BeforeTest
	public void setup(){
		// location and external report
		htmlReporter = new ExtentHtmlReporter("extentReport.html");    
		// Create object of ExtentReports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.out.println("I am in Before Test");
	}

	@Test
	public void googleSearch() throws IOException{
		// creates a toggle for the given test, adds all log events under it    
		test = extent.createTest("MyFirstTest", "Sample description");
		System.setProperty("webdriver.chrome.driver","C:\\Automation Project\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("abcd");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");  
	}


	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
		// calling flush writes everything to the log file
		extent.flush();
	}
}