package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fcusd {
	
	WebDriver driver;
	
	public void URL() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation Project\\chromedriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.fcusd.org/Page/1");	
	}
	
	public void dashBoard() {
		
		driver.findElement(By.xpath("//span[contains(text(),'COVID-19')]")).click();
	}

	
	public static void main(String[] arg) {
		Fcusd obj = new Fcusd();
		obj.URL();
		obj.dashBoard();
	}
}
