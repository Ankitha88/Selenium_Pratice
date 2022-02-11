package testNGPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

public class RadioButton_CheckBox {
	WebDriver driver;
	@FindBy(id= "auth_user_name") WebElement loginName;
	@FindBy(id= "auth_password") WebElement password;
	@FindBy(id= "auth_school") WebElement schoolName;
	@FindBy(name= "Login") WebElement login;
	@FindBy(id = "main") WebElement Main_Frame;
	
	//Communication Web Elements
	@FindBy(xpath = "//span[contains(text(),'COMMUNICATION')]") WebElement communication;
	@FindBy(xpath = "//a[contains(text(),'Send Voice Message')]") WebElement voice_msg;
	
	//Fees Web Elements
	@FindBy(xpath = "//span[contains(text(),'FEES')]") WebElement Fees;
	@FindBy(xpath = "//a[contains(text(),'Fee Reimbursement Upload')]") WebElement Fees_Reminburse;
//	@FindBy(xpath= "//input[@type = 'file']") WebElement File_Select;
	
	//Transport WebElements
	@FindBy(xpath = "//span[contains(text(),'TRANSPORT')]") WebElement Transport;
	@FindBy(xpath= "//a[contains(text(),'Trip Master')]") WebElement TripMaster;
//	@FindBy(xpath = "//span[contains(@class,'jtable-toolbar-item jtable-toolbar-item-add-record')]") WebElement Trip_newRecord;
	@FindBy(xpath= "(//span[contains(text(),'Add new record')])[1]")WebElement Trip_newRecord;
	
	@Test
	public void communication() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 40),this);
		driver.get("https://demo.eschool360.in/index.php");
		Thread.sleep(3000);

		loginName.sendKeys("admin");
		password.sendKeys("admin");
		schoolName.sendKeys("1");
		login.click();
		Thread.sleep(3000);
		
		communication.click();
		voice_msg.click();
		
	//	driver.switchTo().frame(driver.findElement(By.id("main")));		
		driver.switchTo().frame(Main_Frame);
		WebElement Radio = driver.findElement(By.xpath("(//input[contains(@name,'sms_sending_method')])[2]"));
		String RadioButtonStatus = Radio.getAttribute("checked");
		System.out.println(RadioButtonStatus);
		if(RadioButtonStatus == null) {
			Radio.click();
		}
		
		//Fees Reimbursement upload
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Fees.click();
		Fees_Reminburse.click();
		driver.switchTo().frame(Main_Frame);
		WebElement File_Select = driver.findElement(By.xpath("//input[@type = 'file']"));
		File_Select.sendKeys("C:\\Users\\ankit\\Downloads\\vovels_swaraha_a_to_ru.pdf");
		
		//Transport
		driver.switchTo().defaultContent();
		Transport.click();
		TripMaster.click();
		Thread.sleep(1000);
		driver.switchTo().frame(Main_Frame);
		Trip_newRecord.click();		
		ADD_Trip_Master("Trip5","secundrabad");
		
		WebElement Checkbox = driver.findElement(null);
	}
	
	
	public void ADD_Trip_Master(String trip_number,String trip_desc) throws InterruptedException {
		WebElement trip_no = driver.findElement(By.xpath("//input[contains(@id,'Edit-trip_number')]"));
		trip_no.sendKeys(trip_number);
		WebElement trip_description =driver.findElement(By.xpath("//input[contains(@id,'Edit-trip_description')]"));
		trip_description.sendKeys(trip_desc);
		Thread.sleep(500);
		WebElement Save = driver.findElement(By.xpath("(//span[contains(text(),'Save')])[1]"));
		Save.click();
	}

}
