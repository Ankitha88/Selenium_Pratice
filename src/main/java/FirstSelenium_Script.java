

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium_Script {

	WebDriver driver;

	public void url_Launch() throws InterruptedException {
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


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirstSelenium_Script fss = new FirstSelenium_Script();
		fss.url_Launch();

	}
}