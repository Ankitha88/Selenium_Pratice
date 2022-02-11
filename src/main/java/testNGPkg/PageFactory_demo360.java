package testNGPkg;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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


public class PageFactory_demo360 {

	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;
	WebDriver driver;

	//PageFactory syntax using findBy
	@FindBy(id= "auth_user_name") WebElement loginName;
	@FindBy(id= "auth_password") WebElement password;
	@FindBy(id= "auth_school") WebElement schoolName;
	@FindBy(name= "Login") WebElement login;
	@FindBy(name= "Login") List<WebElement> login_exists;


	@FindBy(xpath= "//span[contains(text(),'EXAMS')]") WebElement Exams;
	@FindBy(xpath = "//a[contains(text(),'Marks Entry')] ") WebElement Marks_entry;

	@FindBy(xpath = "//select[contains(@id,'class_name')]") WebElement classname;
	@FindBy(xpath = "//select[contains(@id,'section_id')]") WebElement sectionname;
	@FindBy(id = "exam_main_type_id_for_exam_name_combo") WebElement exammaintype;
	@FindBy(id = "exam_type_id_for_exam_type_combo")WebElement examtype;
	@FindBy(xpath = "//input[contains(@id,'mode')]") WebElement save;

	@FindBy(xpath = "//input[contains(@id,'mode')]") List< WebElement> save_exist;
	@FindBy(xpath = "//a[contains(text(),'Exams Master')]") WebElement examMaster;


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
		driver = new ChromeDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 40),this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.eschool360.in/index.php");
		Thread.sleep(3000);
		test.info("Page loaded ");

		System.out.println(loginName);
		loginName.sendKeys("admin");
		password.sendKeys("admin");
		schoolName.sendKeys("1");
		login.click();
		Thread.sleep(3000);

		Exams.click();
		Marks_entry.click();
	/*	if(login_exists.size() > 0 ) {
			System.out.println("Login button exists");
		}
	*/
		driver.switchTo().frame(driver.findElement(By.id("main")));
		
		System.out.println("before calling method");
		
		select_method(classname,1);
		select_method(sectionname,1);
		select_method(exammaintype,2);
		select_method(examtype,1);

/*		classname.click();
		Select sel = new Select(classname);
		sel.selectByIndex(1);
		Thread.sleep(500);

		// SECTION SELECT
		sectionname.click();
		sel = new Select(sectionname);
		sel.selectByIndex(1);
		Thread.sleep(500);

		//EXAM MAIN TYPE
		exammaintype.click();
		sel = new Select(exammaintype);
		sel.selectByIndex(2);
		Thread.sleep(500);

		//EXAM TYPE
		examtype.click();
		sel = new Select(examtype);
		sel.selectByIndex(1);
		Thread.sleep(500);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		test.info("Exam Marks page loaded successful");
*/
		JavascriptExecutor jse = (JavascriptExecutor)driver; // casting the driver into javaScript executor

		String existing_marks = "90/85/92/88/85/90";
		String[] indv_marks = existing_marks.split("/");


		//Adding values into textboxes
		WebElement student_marks_element ;
		for(int student = 1;student <= 5;student ++) {
			int marks_iter = 0;
			for(int marks = 2; marks <= 7; marks++) {		
				student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element );
				marks_iter = marks_iter+1;
			}
		}	
		System.out.println("save button exists" + save_exist.size());
		if(save_exist.size() > 0) {
			jse.executeScript("arguments[0].click()", save);
			test.info("Marks updation done");
			Thread.sleep(2000);
		}

		Alert alert =driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		test.info("Alert option succesfully");

		driver.switchTo().defaultContent();
		examMaster.click();
		Thread.sleep(2000);

		Exams.click();
		Marks_entry.click();
		Thread.sleep(2000);
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
				assertEquals(indv_marks1[marks_iter], stu_marks_value);
				marks_iter = marks_iter+1;
			}
			test.info("Row comparission completed Successfully");
		}
		test.info("Test executed Successfully");

	}
	
	public void select_method(WebElement w_element, int index_value) {
		System.out.println("check Method");
		w_element.click();
		Select sel = new Select(w_element);
		sel.selectByIndex(index_value);	
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		extent.flush();
	}

}

