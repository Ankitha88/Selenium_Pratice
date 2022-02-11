package testNGPkg;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("multipleClassesextentReport6.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		//extent.setSystemInfo("OS", "Mac Sierra");
		//extent.setSystemInfo("Host Name", "xxxx");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Siva");
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}