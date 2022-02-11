package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {
	
	WebDriver driver;
	
	public void LoadURL() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation Project\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.library.folsom.ca.us/");
	}
	
	public void Login() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'MY ACCOUNT')]")).click();
		driver.findElement(By.id("username")).sendKeys("Ankitha.kishore");
		driver.findElement(By.id("password")).sendKeys("2671");
		driver.findElement(By.id("loginFormSubmit")).click();
		
	
	}
	
	public void SearchBooks() throws InterruptedException {
		
		WebElement search = driver.findElement(By.id("lookfor"));
		search.sendKeys("Dragon Masters");
		search.sendKeys(Keys.DOWN);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'search-actions')]/button[2]")).click();
		Thread.sleep(2000);
/*		WebElement options = driver.findElement(By.xpath("//div[contains(@id,'search-actions')]/button[2]"));
		options.click();
		Select sel = new Select(options);
		//sel.selectByIndex(4);
		sel.selectByValue("Series");
	*/
		driver.findElement(By.xpath("//a[contains(text(),'by Series')]")).click();
		Thread.sleep(2000);
	//driver.findElement(By.xpath("//select[contains(@id,'basicSearchTypes')]/option[contains(text(),'Series')]")).click();
	
	
		//GO Button
	//	driver.findElement(By.xpath("//div[contains(@id,'search-actions')]/button[1]")).click();
		
		//SORTING RESULTS BYNEWEST FIRST
		WebElement sort = driver.findElement(By.xpath("//select[contains(@id,'results-sort')]"));
		sort.click();
		Select sel = new Select(sort);
		sel.selectByIndex(1);
		Thread.sleep(2000);
		
	//	driver.findElement(By.xpath("//select[contains(@id,'results-sort')]/option[contains(text(),'Newest First')]")).click();
	
		//Avaliable in FPL
		driver.findElement(By.xpath("//button[contains(@id,'FolsomPublicLibrary')]")).click();
		Thread.sleep(2000);
	}
	
	public void AdvanceSearch() throws InterruptedException {
		driver.findElement(By.id("advancedSearchLink")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Optional Filters')]")).click();
		Thread.sleep(1000);
		
		//1 FORMAT CATEGORY
		driver.findElement(By.xpath("//select[contains(@id,'format_category_folsom')]/option[3]")).click();
		Thread.sleep(2000);

/*		WebElement format = driver.findElement(By.xpath("//select[contains(@id,'format_category_folsom')]"));
		format.click();
		Select sel = new Select(format);
		sel.selectByIndex(3);
*/		
		//2.AVALIABLE AT
	//  driver.findElement(By.xpath("//select[contains(@id,'available_at_folsom')]/option[contains(text(),'Folsom Public Library')]")).click();
		driver.findElement(By.xpath("//select[contains(@class,'form-control')]/option[contains(text(),'Folsom Public Library')]")).click();
	/*	WebElement location = driver.findElement(By.id("available_at_folsom"));
		location.click();
		Select sel = new Select(location);
		sel.selectByIndex(1);
	*/
		Thread.sleep(2000);
		//3 FICTION OR NON FICTION
		driver.findElement(By.xpath("//select[contains(@id,'literary_form_full')]/option[3]")).click();
		Thread.sleep(2000);
		
		//AR LEVEL TO AND FROM
		driver.findElement(By.xpath("//input[contains(@id,'accelerated_reader_reading_levelfrom')]")).sendKeys("3.5");
		driver.findElement(By.id("accelerated_reader_reading_levelto")).sendKeys("4.5");
		Thread.sleep(2000);
		
		//AR INTEREST LEVEL
		driver.findElement(By.xpath("//select[contains(@id,'accelerated_reader_interest_level')]/option[contains(text(),'LG')]")).click();
		Thread.sleep(2000);
		
		//FIND BUTTON
		driver.findElement(By.xpath("//table[contains(@id,'facetTable')]/following::button")).click();
		Thread.sleep(2000);
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Library obj = new Library();
		obj.LoadURL();
		obj.Login();
		obj.SearchBooks();
		//obj.AdvanceSearch();
	}

}
