package testNGPkg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SimpleLogin {
	
	public WebDriver driver;
	public String msg = null;
	public static By loginName = By.id("auth_user_name");
	public static By password = By.id("auth_password");
	public static By school = By.id("auth_school");
	public static By login = By.name("Login");
	
	@Test
	public void launch() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		
	editBox_Util(loginName,"Username","Login Page","admin");
	editBox_Util(password,"Password","Login Page","admin");
	editBox_Util(school,"School","Login Page","1");
	login.findElement(driver).click();	
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
}
