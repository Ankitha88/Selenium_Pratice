package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	
	WebDriver driver;
	
	public void openBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("Ankitha");
	//	driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("Ankitha");
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("Donthi");
	//	driver.findElement(By.xpath("//button[contains(@id,'loginbutton')]")).click();
	//  driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.xpath("//a[contains(@class,'_97w4')]"));
		Thread.sleep(3000);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Facebook obj = new Facebook();
		obj.openBrowser();
	}

}
