package testNGPkg;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
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

public class Demo360_ByClassName {

	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;
	public WebDriver driver;
	public String msg = null;
	
	public Demo360_ByClassName(WebDriver driver) {
		this.driver = driver;
	}

	public static By loginName = By.id("auth_user_name");
	public static By password = By.id("auth_password");
	public static By school = By.id("auth_school");
	public static By login = By.name("Login");

	public static By Exams = By.xpath("//span[contains(text(),'EXAMS')]");
	public static By marks_entry = By.xpath("//a[contains(text(),'Marks Entry')] ");

	public static By classname = By.xpath("//select[contains(@id,'class_name')]");
	public static By sectionname = By.xpath("//select[contains(@id,'section_id')]"); 
	public static By exammaintype = By.id("exam_main_type_id_for_exam_name_combo");
	public static By examtype = By.id("exam_type_id_for_exam_type_combo");

	public static By save = By.xpath("//input[contains(@id,'mode')]");

	public static By examMaster = By.xpath("//a[contains(text(),'Exams Master')]");

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
		//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demo.eschool360.in/index.php");

		test.info("Page loaded ");

		loginName.findElement(driver).sendKeys("admin");
		password.findElement(driver).sendKeys("admin");
		school.findElement(driver).sendKeys("1");
		login.findElement(driver).click();

		Exams.findElement(driver).click();
		marks_entry.findElement(driver).click();
		//	driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		//	driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		//driver.switchTo().frame("1");
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.id("main")));


		//CLASS NAME
		classname.findElement(driver).click();
		//	WebElement classname = driver.findElement(By.xpath("//select[contains(@id,'class_name')]"));
		//	classname.click();
		//driver.findElement(By.xpath("//select[contains(@name,'class_name')]")).click();
		//Select sel = new Select(classname);
		Select sel = new Select(classname.findElement(driver));
		sel.selectByIndex(1);


		// SECTION SELECT
		sectionname.findElement(driver).click();
		//	WebElement sectionname = driver.findElement(By.xpath("//select[contains(@id,'section_id')]"));
		//	sectionname.click();
		sel = new Select(sectionname.findElement(driver));
		sel.selectByIndex(1);
		//Thread.sleep(500);

		//EXAM MAIN TYPE
		exammaintype.findElement(driver).click();
		//	WebElement exammaintype = driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		//	exammaintype.click();
		sel = new Select(exammaintype.findElement(driver));
		sel.selectByIndex(2);
		//Thread.sleep(500);

		//EXAM TYPE
		examtype.findElement(driver).click();
		//	WebElement examtype= driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		//	examtype.click();
		sel = new Select(examtype.findElement(driver));
		sel.selectByIndex(1);
		//Thread.sleep(500);
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
		save.findElement(driver).click();
		//	WebElement save = driver.findElement(By.xpath("//input[contains(@id,'mode')]"));
		jse.executeScript("arguments[0].click()", save);
		test.info("Marks updation done");

		Alert alert =driver.switchTo().alert();
		alert.accept();
		//Thread.sleep(2000);
		test.info("Alert option succesfully");

		driver.switchTo().defaultContent();
		examMaster.findElement(driver).click();
		//	WebElement examMaster = driver.findElement(By.xpath("//a[contains(text(),'Exams Master')]"));
		//	examMaster.click();
		//Thread.sleep(2000);

		Exams.findElement(driver).click();
		marks_entry.findElement(driver).click();
		//	driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		//Thread.sleep(20000);
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

	/*	public String element_present(By locator,String locator_name,String Page_name) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			.w
		return msg;
	}
	 */

	public  String elementPresent(By locator, String locatorName, String pageName) {
		// Waiting 30 seconds for an element to be present on the page, checking		
		// for its presence once every 5 seconds.
		//WebElement element =(WebElement) locator;
		try {
			Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)
					//new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);
			//.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth_user_name")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("I have entered into catch block");
			//e.printStackTrace();
			msg = "Locator Name:-"+locatorName+" : "+locator+" is not identified in Page : "+pageName;
		}
		return msg;
	}
	public void editBox_Util(WebDriver driver,By locator,String locatorname,String pageName,String value) {
		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator,locatorname,pageName);
		if(msg == null) {
			locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"A"),value);
		}else {
			System.out.println(msg);
		}
	}

}
/*
 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
.withTimeout(Duration.ofSeconds(30))
.pollingEvery(Duration.ofSeconds(5))
.ignoring(StaleElementReferenceException.class);

wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

1. x = new FluentWait<WebDrive>()
2. x.withTimeout()
3. x.pollingEvery()
4 x.ingoring()

Very old way of done (i.e. olden days)
x = new FluentWait<WebDriver>()
x.timeout = whatever
x.pollingEvery = whatever
x.ignoring = whatever

New way of doing
x = new FluentWait<WebDriver>()
y = x.withTimeout(whatever)
z = y.pollingEvery(whatever)
a = z.ignoringEvery(whatever)
b = a.until()

FluentWait -> withTimeout -> FluentWait
FluentWait -> pollingEvery -> FluentWait
FluentWait -> ignoring -> FluentWait
FluentWait -> until -> WebElement

Here WebElement can't convert to FluentWait that’s why it's throwing "cannot cast a webelement into a wait variable. So, we need to use "wait."

Wait<WebDriver> wait = a
wait.until()

Cannot cast a WebElement into a Wait variable

 */


