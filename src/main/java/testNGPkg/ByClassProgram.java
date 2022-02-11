package testNGPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ByClassProgram {
	
	WebDriver driver;
	public static By loginName = By.id("auth_user_name");
	public static By password = By.id("auth_password");
	public static By school = By.id("auth_school");
	public static By login = By.name("Login");
	
	By main = By.id("main"); 
	
	public static By exams =  By.xpath("//span[contains(text(),'EXAMS')]");
	public static By marks_entry =  By.xpath("//a[contains(text(),'Marks Entry')] ");
	public static By classname = By.xpath("//select[contains(@id,'class_name')]");
	public static By sectionname = By.xpath("//select[contains(@id,'section_id')]"); 
	public static By exammaintype =  By.id("exam_main_type_id_for_exam_name_combo");
	public static By examtype =  By.id("exam_type_id_for_exam_type_combo");
	
	public static By save = By.xpath("//input[contains(@id,'mode')]");

	
	@Test
	public void launch() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.eschool360.in/index.php");
		Thread.sleep(3000);
		
		loginName.findElement(driver).sendKeys("admin");
		password.findElement(driver).sendKeys("admin");
		school.findElement(driver).sendKeys("1");
		login.findElement(driver).click();
		
	
		Thread.sleep(2000);
		exams.findElement(driver).click();
		marks_entry.findElement(driver).click();
		
		driver.switchTo().frame(main.findElement(driver));
		
		select_method(classname,1);
		select_method(sectionname,1);
		select_method(exammaintype,2);
		select_method(examtype,1);
	}
	
	 public void select_method(By element,int value) {
		 
		 WebElement web_ele = element.findElement(driver);
		 web_ele.click();
		 Select sel = new Select(web_ele);
		 sel.selectByIndex(value);	 
	 }

}
