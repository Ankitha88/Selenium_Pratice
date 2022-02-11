package testNGPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	public static By loginName = By.id("auth_user_name");
	public static By password = By.id("auth_password");
	public static By school = By.id("auth_school");
	public static By login = By.name("Login");
	By main = By.id("main"); 
	public static By exams =  By.xpath("//span[contains(text(),'EXAMS')]");
	
	By Reports = By.xpath("//a[contains(text(),'Exam Results')]/ancestor::ul//following-sibling::li[9]/a");
	By exportExammarks = By.xpath("(//a[contains(text(),'Export Exam Marks')])[1]");

	
	@Test
	public void hover() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://demo.eschool360.in/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		loginName.findElement(driver).sendKeys("admin");
		password.findElement(driver).sendKeys("admin");
		school.findElement(driver).sendKeys("1");
		login.findElement(driver).click();


	//	Thread.sleep(2000);
		exams.findElement(driver).click();
		Actions act = new Actions(driver);
		act.moveToElement(Reports.findElement(driver));
		act.moveToElement(exportExammarks.findElement(driver));
		//act.click(exportExammarks.findElement(driver));
		act.click().build().perform();
	}
}