package testNGPkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class MarksEntryInMethods {

	public WebDriver driver;
	public String msg = null;
	public static By loginName = By.id("auth_user_name");
	public static By password = By.id("auth_password");
	public static By school = By.id("auth_school");
	public static By login = By.name("Login");
	
	public static By exams =  By.xpath("//span[contains(text(),'EXAMS')]");
	public static By marks_entry =  By.xpath("//a[contains(text(),'Marks Entry')] ");
	public static By main = By.id("main"); 
	
	public static By classname = By.xpath("//select[contains(@id,'class_name')]");
	public static By sectionname = By.xpath("//select[contains(@id,'section_id')]"); 
	public static By exammaintype =  By.id("exam_main_type_id_for_exam_name_combo");
	public static By examtype =  By.id("exam_type_id_for_exam_type_combo");
	
	
	@Test
	public void launch() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");	
		editBox_Util(loginName,"Username","Login Page","admin");
		editBox_Util(password,"Password","Login Page","admin");
		editBox_Util(school,"School","Login Page","1");
		button_Util(login,"Submit","Login Page");
		
		select_Util(exams,"Exams","HomePage");
		select_Util(marks_entry,"MArks Entry","HomePage");
		
		driver.switchTo().frame(main.findElement(driver));
		
		dropDown_Util(classname,"Class","Marks Entry page",1);
		dropDown_Util(sectionname,"Section","Marks Entry Page",2);
		dropDown_Util(exammaintype,"Exam Main Type","Marks Entry Page",2);
		dropDown_Util(examtype,"Exam Type","Marks Entry page",1);
		}
		
		public String elementPresent(By locator, String locatorName, String pageName) {
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
		
		public void editBox_Util(By locator,String locatorName,String pageName,String value) {
			System.out.println(driver);
			System.out.println(locator);
			System.out.println(value);
			msg = elementPresent(locator,locatorName,pageName);
			if(msg == null) {
				//locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
				locator.findElement(driver).sendKeys(value);
				System.out.println("Inside If block");
			}else {
				System.out.println(msg);
			}
		}
		
		public void button_Util(By locator,String locatorName,String pageName) {
			msg = elementPresent(locator,locatorName,pageName);
			if(msg ==null) {
				locator.findElement(driver).click();
			}else {
				System.out.println(msg);
			}
		}
		
		public void select_Util(By locator,String locatorName,String pageName) {
			msg = elementPresent(locator,locatorName,pageName);
			if(msg ==null) {
				locator.findElement(driver).click();
			}else {
				System.out.println(msg);
			}
		}
		
		public void dropDown_Util(By locator,String locatorName, String pageName,int value) {
			msg = elementPresent(locator,locatorName,pageName);
			if(msg == null) {
				WebElement web_ele = locator.findElement(driver);
				web_ele.click();
				Select sel = new Select(web_ele);
				sel.selectByIndex(value);
			} else {
				System.out.println(msg);
			}	
		}
}

