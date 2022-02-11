package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
	WebDriver driver;
	
	@Test
	public void hard_assert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		Thread.sleep(3000);

		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		
		System.out.println(driver.getTitle());
        String expected_results = "School";
		String actual = driver.getTitle();
		Assert.assertEquals(expected_results, actual);
		Assert.assertNotEquals(expected_results, actual);
		System.out.println("I have crossed Assertion");
	}
}
