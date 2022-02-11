package testNGPkg;

//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Demo360 {

	WebDriver driver;

	public void loadURL() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		Thread.sleep(3000);
	}

	public void login() throws InterruptedException {

		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(3000);
	}

	public void exams() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		//driver.switchTo().frame("1");
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.id("main")));


		//CLASS NAME
		WebElement classname = driver.findElement(By.xpath("//select[contains(@id,'class_name')]"));
		classname.click();
		//driver.findElement(By.xpath("//select[contains(@name,'class_name')]")).click();
		//Select sel = new Select(classname);
		Select sel = new Select(classname);
		sel.selectByIndex(1);
		Thread.sleep(500);

		// SECTION SELECT
		WebElement sectionname = driver.findElement(By.xpath("//select[contains(@id,'section_id')]"));
		sectionname.click();
		sel = new Select(sectionname);
		sel.selectByIndex(1);
		Thread.sleep(500);

		//EXAM MAIN TYPE
		WebElement exammaintype = driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		exammaintype.click();
		sel = new Select(exammaintype);
		sel.selectByIndex(2);
		Thread.sleep(500);

		//EXAM TYPE
		WebElement examtype= driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		examtype.click();
		sel = new Select(examtype);
		sel.selectByIndex(1);
		Thread.sleep(500);
		//driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		JavascriptExecutor jse = (JavascriptExecutor)driver; // casting the driver into javaScript executor

		String existing_marks = "95/85/92/88/80/100";
		String[] indv_marks = existing_marks.split("/");


		//Adding values into textboxes
		WebElement student_marks_element ;
		for(int student = 1;student <= 5;student ++) {
			int marks_iter = 0;
			for(int marks = 2; marks <= 7; marks++) {		
				student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
				jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element );
				marks_iter = marks_iter+1;
				//	jse.executeScript("arguments[0].value= '"+existing_marks+"';",student_marks_element );
			}
		}	
		WebElement save = driver.findElement(By.xpath("//input[contains(@id,'mode')]"));
		jse.executeScript("arguments[0].click()", save);
		Thread.sleep(2000);
		//th[contains(@class,'xlth')]
		//th[contains(text(),'Telugu')]

		//	WebElement marks = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr[6]/td[3]/input"));
		//	System.out.println(marks.getAttribute("value"));
		//	WebElement lablename = driver.findElement(By.xpath("//th[contains(text(),'Student')]"));
		//	System.out.println(lablename.getText());


		Alert alert =driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		WebElement examMaster = driver.findElement(By.xpath("//a[contains(text(),'Exams Master')]"));
		examMaster.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entry')] ")).click();
		Thread.sleep(20000);
		//driver.switchTo().frame("1");
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.id("main")));

		/*		
		//CLASS NAME
		WebElement classname1 = driver.findElement(By.xpath("//select[contains(@id,'class_name')]"));
		classname1.click();
		//driver.findElement(By.xpath("//select[contains(@name,'class_name')]")).click();
		//Select sel = new Select(classname);
		Select sel1 = new Select(classname1);
		sel1.selectByIndex(1);
		Thread.sleep(500);

		// SECTION SELECT
		WebElement sectionname1 = driver.findElement(By.xpath("//select[contains(@id,'section_id')]"));
		sectionname1.click();
		Select sel2 = new Select(sectionname1);
		sel2.selectByIndex(1);
		Thread.sleep(500);

		//EXAM MAIN TYPE
		WebElement exammaintype1 = driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		exammaintype1.click();
		Select sel3 = new Select(exammaintype1);
		sel3.selectByIndex(2);
		Thread.sleep(500);

		//EXAM TYPE
		WebElement examtype1= driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		examtype1.click();
		Select sel4 = new Select(examtype1);
		sel4.selectByIndex(1);
		Thread.sleep(500);
		//driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		 */		

		//JavascriptExecutor jse1 = (JavascriptExecutor)driver; // casting the driver into javaScript executor

		String existing_marks1 = "95/85/95/98/60/90";
		String[] indv_marks1 = existing_marks.split("/");


		//Adding values into textboxes
		WebElement student_marks_element1 ;
		for(int student = 1;student <= 5;student ++) {
			int marks_iter = 0;
			for(int marks = 2; marks <= 7; marks++) {		
				student_marks_element1 = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				String stu_marks_value = student_marks_element1.getAttribute("value");
			//	Assert.assertEquals(indv_marks1[marks_iter], stu_marks_value);
				
			/*	if(indv_marks1[marks_iter].equals(stu_marks_value) ) {
					System.out.println("PASS");
					
				} else {
					System.out.println("FAIL");
				} */
				marks_iter = marks_iter+1;
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
				//	jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element1 );
				//	marks_iter = marks_iter+1;
				//	jse.executeScript("arguments[0].value= '"+existing_marks+"';",student_marks_element );
			}
		}	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Demo360 obj = new Demo360();
		obj.loadURL();
		obj.login();
		obj.exams();
	}

}
