package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingaporeAirlines {
	
	WebDriver driver;
	
	public void loadURL() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation Project\\chromedriver.exe");
	//  System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("https://www.singaporeair.com/en_UK/us/home#/book/bookflight");
		Thread.sleep(3000);
	}
	
	public void flightSearch() throws InterruptedException {
		
		WebElement Origin = driver.findElement(By.id("flightOrigin1"));
		Origin.sendKeys("SFO");
		Origin.sendKeys(Keys.DOWN);
		Origin.sendKeys(Keys.ENTER);
	//  driver.findElement(By.xpath("//div[contains(@class,'flight__ticker')]/preceding-sibling::input")).sendKeys("san francisco");
	//	driver.findElement(By.xpath("//div[contains(@class,'flight__ticker')]/preceding-sibling::input")).sendKeys(Keys.DOWN);
	//	driver.findElement(By.xpath("//div[contains(@class,'flight__ticker')]/preceding-sibling::input")).sendKeys(Keys.ENTER);
		WebElement Destin = driver.findElement(By.id("bookFlightDestination"));
		Destin.sendKeys("BLR");
		Destin.sendKeys(Keys.DOWN);
		Destin.sendKeys(Keys.ENTER);
		
	//	driver.findElement(By.id("bookFlightDestination")).sendKeys("Bengaluru, India");
		driver.findElement(By.id("departDate1")).sendKeys("15012022");
		driver.findElement(By.id("returnDate1")).sendKeys("30012022");
		
		driver.findElement(By.id("flightClass1")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Premium Economy')]")).click();
		driver.findElement(By.id("flightPassengers1")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn--image_icon input__number--ticker-plus')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary js-open-loading')]")).click();
		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SingaporeAirlines obj = new SingaporeAirlines();
		obj.loadURL();
		obj.flightSearch();

	}

}
