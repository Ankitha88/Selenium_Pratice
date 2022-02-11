package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	WebDriver driver;
	SoftAssert soft_assert =  new SoftAssert();
	
	@Test
	public void soft_assert() throws InterruptedException {
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
		soft_assert.assertEquals(expected_results, actual);
		soft_assert.assertNotEquals(expected_results, actual);
		
		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		System.out.println("I have crossed Assertion");
		soft_assert.assertAll();
	}
}
