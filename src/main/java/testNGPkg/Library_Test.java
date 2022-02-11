package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Library_Test {
	
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void extentReportSetup() {
		
		System.out.println("I am in BeforeTest");		
		// location and external report
        htmlReporter = new ExtentHtmlReporter("extentReport.html");    
        // Create object of ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);        
        htmlReporter.config().setDocumentTitle("Automation Report"); // Title of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report		
		// General information releated to application
		extent.setSystemInfo("Application Name", "Application");		
	}


	@Test
	public void advanceSearch() throws InterruptedException {
		
		test = extent.createTest("LIBRARY BOOK SEARCH","Script start execution");

		System.setProperty("webdriver.chrome.driver","C:\\Automation Project\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.library.folsom.ca.us/");
		test.info("Webpage Loaded");
		
	//	driver.findElement(By.id("search_text")).sendKeys("Dragon masters");

    	driver.findElement(By.xpath("//span[contains(text(),'MY ACCOUNT')]")).click();
		driver.findElement(By.id("username")).sendKeys("Ankitha.kishore");
		driver.findElement(By.id("password")).sendKeys("2671");
		driver.findElement(By.id("loginFormSubmit")).click();
		test.info("Login Successfully");

		driver.findElement(By.id("advancedSearchLink")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Optional Filters')]")).click();
		Thread.sleep(1000);
		test.info("Advance search and Optional link executed");

		//1 FORMAT CATEGORY
//		dropDown_Selection("format_category_folsom",3,"index");
		
		driver.findElement(By.xpath("//select[contains(@id,'format_category_folsom')]/option[3]")).click();
		Thread.sleep(2000);
		test.info("Category selected");

//		dropDown_Selection("available_at_folsom",1,"value");
		driver.findElement(By.xpath("//select[contains(@class,'form-control')]/option[contains(text(),'Folsom Public Library')]")).click();
		/*	WebElement location = driver.findElement(By.id("available_at_folsom"));
			location.click();
			Select sel = new Select(location);
			sel.selectByIndex(1);
		 */
		Thread.sleep(2000);
		test.info("Location selected");
		
		//3 FICTION OR NON FICTION
		driver.findElement(By.xpath("//select[contains(@id,'literary_form_full')]/option[3]")).click();
		Thread.sleep(2000);
		test.info("Types of books selected");

		//AR LEVEL TO AND FROM
		driver.findElement(By.xpath("//input[contains(@id,'accelerated_reader_reading_levelfrom')]")).sendKeys("3.5");
		driver.findElement(By.id("accelerated_reader_reading_levelto")).sendKeys("4.5");
		Thread.sleep(2000);
		test.info("AR Reading level set");

		//AR INTEREST LEVEL
		driver.findElement(By.xpath("//select[contains(@id,'accelerated_reader_interest_level')]/option[contains(text(),'LG')]")).click();
		Thread.sleep(2000);
		test.info("AR interest level set");

		//FIND BUTTON
		driver.findElement(By.xpath("//table[contains(@id,'facetTable')]/following::button")).click();
		Thread.sleep(2000);
		test.info("Search Successfully Completed");
	}
	
	
	public void dropDown_Selection(String webele,int dropdownValue,String criteria) {
		
		WebElement we = driver.findElement(By.id("+webele+"));
		we.click();
		Select sel = new Select(we);
		if(criteria.equals("index")) {
			sel.selectByIndex(dropdownValue);
		}else {
			String s=String.valueOf(dropdownValue);
			sel.selectByValue(s);
		}	
	}
	

	
/*	@AfterTest
	public void tearDown() {
	//	driver.close();
	//	driver.quit();
		extent.flush();
	}
	*/
}
