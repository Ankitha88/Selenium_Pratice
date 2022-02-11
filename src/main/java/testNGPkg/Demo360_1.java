package testNGPkg;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import org.testng.asserts.Assertion;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Demo360_1 {
	
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
        htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report		
		// General information releated to application
		extent.setSystemInfo("Application Name", "Application");
		
				
	}

	

	@Test
	public void loadURL() throws InterruptedException {
		
		test = extent.createTest("MYDEMOTEST","Script start execution");

		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.eschool360.in/index.php");
		Thread.sleep(3000);
		test.info("Page loaded ");
		
		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(3000);
		test.info("Logged in Successfully");
		

		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		//driver.switchTo().frame("1");
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.id("main")));


		//CLASS NAME
		WebElement classname = driver.findElement(By.xpath("//select[contains(@id,'class_name')]"));
		classname.click();
		//driver.findElement(By.xpath("//select[contains(@name,'class_name')]")).click();
		//Select sel = new Select(classname);
		Select sel = new Select(classname);
		sel.selectByIndex(1);
		Thread.sleep(500);

		// SECTION SELECT
		WebElement sectionname = driver.findElement(By.xpath("//select[contains(@id,'section_id')]"));
		sectionname.click();
		sel = new Select(sectionname);
		sel.selectByIndex(1);
		Thread.sleep(500);

		//EXAM MAIN TYPE
		WebElement exammaintype = driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		exammaintype.click();
		sel = new Select(exammaintype);
		sel.selectByIndex(2);
		Thread.sleep(500);

		//EXAM TYPE
		WebElement examtype= driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		examtype.click();
		sel = new Select(examtype);
		sel.selectByIndex(1);
	Thread.sleep(500);
		//driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		test.info("Exam Marks page loaded successful");

		JavascriptExecutor jse = (JavascriptExecutor)driver; // casting the driver into javaScript executor

		String existing_marks = "95/85/92/88/80/100";
		String[] indv_marks = existing_marks.split("/");


		//Adding values into textboxes
		WebElement student_marks_element ;
		for(int student = 1;student <= 5;student ++) {
			int marks_iter = 0;
			for(int marks = 2; marks <= 7; marks++) {		
				student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
				jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element );
				marks_iter = marks_iter+1;
				//	jse.executeScript("arguments[0].value= '"+existing_marks+"';",student_marks_element );
			}
		}	
		WebElement save = driver.findElement(By.xpath("//input[contains(@id,'mode')]"));
		jse.executeScript("arguments[0].click()", save);
		test.info("Marks updation done");
		
		// explicit wait - to wait for the compose button to be click-able
	/*	WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'mode')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//input[contains(@id,'mode')]")).click();
	*/
		
		Thread.sleep(2000);
		//th[contains(@class,'xlth')]
		//th[contains(text(),'Telugu')]

		//	WebElement marks = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr[6]/td[3]/input"));
		//	System.out.println(marks.getAttribute("value"));
		//	WebElement lablename = driver.findElement(By.xpath("//th[contains(text(),'Student')]"));
		//	System.out.println(lablename.getText());


		Alert alert =driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		test.info("Alert option succesfully");

		driver.switchTo().defaultContent();
		WebElement examMaster = driver.findElement(By.xpath("//a[contains(text(),'Exams Master')]"));
		examMaster.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		Thread.sleep(20000);
		//driver.switchTo().frame("1");
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.id("main")));

	
		//JavascriptExecutor jse1 = (JavascriptExecutor)driver; // casting the driver into javaScript executor

		String existing_marks1 = "95/85/95/98/60/90";
		String[] indv_marks1 = existing_marks.split("/");


		//Adding values into textboxes
		WebElement student_marks_element1 ;
		for(int student = 1;student <= 5;student ++) {
			int marks_iter = 0;
			for(int marks = 2; marks <= 7; marks++) {		
				student_marks_element1 = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				String stu_marks_value = student_marks_element1.getAttribute("value");
				//Assertion.assertNotEquals(indv_marks1[marks_iter], stu_marks_value);
				
				assertEquals(indv_marks1[marks_iter], stu_marks_value);
				marks_iter = marks_iter+1;
							/*	if(indv_marks1[marks_iter].equals(stu_marks_value) ) {
									System.out.println("PASS");
									
								} else {
									System.out.println("FAIL");
								} */
								
								//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
								//	jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element1 );
								//	marks_iter = marks_iter+1;
								//	jse.executeScript("arguments[0].value= '"+existing_marks+"';",student_marks_element );
			}
			test.info("Row comparission completed Successfully");
		}
		test.info("Test executed Successfully");
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		extent.flush();
	}
	
}

