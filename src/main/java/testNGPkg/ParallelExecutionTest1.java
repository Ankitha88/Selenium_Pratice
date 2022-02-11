package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionTest1 {
	
	WebDriver driver;
	@Test
	public void method1() throws InterruptedException {
		System.out.println("Method 1");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://demo.eschool360.in/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"auth_user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_school\"]")).sendKeys("1");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(2000);
	}
	
	@Test
	public void method2() throws InterruptedException {
		System.out.println("Method 2");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://demo.eschool360.in/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"auth_user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_school\"]")).sendKeys("1");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(2000);
	}
	
	@Test
	public void method3() throws InterruptedException {
		System.out.println("Method 3");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://demo.eschool360.in/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"auth_user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_school\"]")).sendKeys("1");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(2000);
	}
	
	@Test
	public void method4() throws InterruptedException {
		System.out.println("Method 4");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://demo.eschool360.in/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"auth_user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"auth_school\"]")).sendKeys("1");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(2000);
	}

}