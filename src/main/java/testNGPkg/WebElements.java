package testNGPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class WebElements {
	WebDriver driver;
	
	//1.SETUP
	WebElement Setup = driver.findElement(By.xpath("//span[contains(text(),'SETUP')]"));
		@FindBy(xpath = "//a[contains(text(),'Class Master')]") WebElement Class_Master;
		@FindBy(xpath = "//a[contains(text(),'Section Master')]") WebElement Section_Master;
		@FindBy(xpath = "//a[contains(text(),'Subject Master')]") WebElement Subject_Master ;
		@FindBy(xpath = "//a[contains(text(),'Class Sections')]") WebElement Class_Sections ;
		@FindBy(xpath = "//a[contains(text(),'Class Section Subjects')]") WebElement Class_Section_Subjects;
		@FindBy(xpath = "//a[contains(text(),'Class Section Subject Teachers')]") WebElement Class_Sec_Sub_Teachers ;
		@FindBy(xpath = "//a[contains(text(),'Notice Board')]") WebElement Notice_Board ;
		@FindBy(xpath = "//a[contains(text(),'Academic Year Details')]") WebElement Academic_Year_Details;
		@FindBy(xpath = "//a[contains(text(),'Change Password')]") WebElement Change_Password ;
		@FindBy(xpath = "//a[contains(text(),Time Table')]") WebElement TimeTable;
		@FindBy(xpath = "//a[contains(text(),'Academic Year Terms')]") WebElement Aca_Year_Terms ;
		@FindBy(xpath = "//a[contains(text(),'Upload School Logo')]") WebElement Logo;
	
	//Admissions
	WebElement Admissions = driver.findElement(By.xpath("//span[contains(text(),'ADMISSIONS')]"));
		@FindBy(xpath= "//a[contains(text(),'Enroll Pre-Admissions')]") WebElement Pre_Admission;
	
	//Students
	WebElement Students = driver.findElement(By.xpath("//span[contains(text(),'STUDENTS')]"));
		@FindBy(xpath = "//a[contains(text(),'Student Master')]") WebElement Stu_Master;
		@FindBy(xpath = "//a[contains(text(),'Student Health Metrics')]") WebElement Stu_Health_Metrics;
		@FindBy(xpath = "//a[contains(text(),'Student Promotion')]") WebElement Stu_Promotion;
		@FindBy(xpath = "//a[contains(text(),'Student Info Academic Year wise')]") WebElement Stu_Academic_Yearrwise ;
		@FindBy(xpath = "//a[contains(text(),'Digital Diary')]") WebElement Digital_Diary ;
		@FindBy(xpath = "//a[contains(text(),'Media Diary')]") WebElement Media_Diary;
		@FindBy(xpath = "//a[contains(text(),'Students Attendance')]") WebElement Stud_Attendence;
		@FindBy(xpath = "//a[contains(text(),'Students Attendance View')]") WebElement  Stud_Attendence_view ;
		@FindBy(xpath = "//a[contains(text(),'Students Import')]") WebElement Stud_Import ;
		@FindBy(xpath= "//a[contains(text(),'Students Import')]//ancestor::ul//following-sibling::li[10]/a") WebElement Stud_Reports;
		
	//STAFF	
	WebElement Staff = driver.findElement(By.xpath("//span[contains(text(),'STAFF')]"));
		@FindBy(xpath = "//span[contains(text(),'STAFF')]//following::li[1]/a") WebElement Teachers;
		@FindBy(xpath = "//span[contains(text(),'STAFF')]//following::li[2]/a") WebElement Teach_Attendence;
		@FindBy(xpath = "//a[contains(text(),'Teachers Attendance View')]") WebElement Teach_Attend_view;
		@FindBy(xpath = "//a[contains(text(),'Staff Import')]") WebElement Staff_import;
		@FindBy(xpath = "(//a[contains(text(),'Staff Import')]//ancestor::ul//following-sibling::li[5]/a)[1]") WebElement Staff_Reports;
	    @FindBy(xpath = "//span[contains(text(),'STAFF')]//following::li[8]/a") WebElement Non_Teachers;
	    @FindBy(xpath = "//span[contains(text(),'STAFF')]//following::li[9]/a") WebElement Non_Teach_Attendence;
	    @FindBy(xpath = "//a[contains(text(),'Non-Teachers Attendance view')]") WebElement Non_Teach_Attendence_view;
	    
	 //COMMUNICATION
	WebElement Communication = driver.findElement(By.xpath("//span[contains(text(),'COMMUNICATION')]"));
		@FindBy(xpath = "//a[contains(text(),'SMS Message Master')] ") WebElement Sms_Msg ;	
		@FindBy(xpath = "//a[contains(text(),'Voice Message Master')] ") WebElement Voice_Msg_master ;	
		@FindBy(xpath = "//a[contains(text(),'Send Bulk SMS')] ") WebElement Bulk_SMS ;	
		@FindBy(xpath = "//a[contains(text(),'Send Voice Message')] ") WebElement Voice_Message ;	
		@FindBy(xpath = "//a[contains(text(),'Schedule Voice Message')] ") WebElement Schedule_Voice_Message ;	
		@FindBy(xpath = "//a[contains(text(),'Notifications')] ") WebElement Notifications ;	
		@FindBy(xpath = "//a[contains(text(),'SMS Delivery Report')] ") WebElement SMS_Delivery_Report ;	
		
		
	//EXAMS	
	WebElement Exams = driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]"));
		@FindBy(xpath = "//a[contains(text(),'Exam Main Types Master')] ") WebElement Exam_Maintype_Mstr;
		@FindBy(xpath = "//a[contains(text(),'Exam Types Master')] ") WebElement ExamType_Master ;
		@FindBy(xpath = "//a[contains(text(),'Exams Master')] ") WebElement Exam_Master ;
		@FindBy(xpath = "//a[contains(text(),'Exams Time Table')] ") WebElement Exam_TT;
		@FindBy(xpath = "//a[contains(text(),'Marks Entry')] ") WebElement Marks_Entry;
		@FindBy(xpath = "//a[contains(text(),'Grade Ranges')] ") WebElement Grade_Ranges;
		@FindBy(xpath = "//a[contains(text(),'Results Upload')] ") WebElement Results_upload;
		@FindBy(xpath = "//a[contains(text(),'Exam Results')] ") WebElement Exam_Results;
		@FindBy(xpath = "//span[contains(text(),'EXAMS')]//following::li[9]/a") WebElement Exam_Reports;
		
		
	//EXPENSES
	WebElement Expenses = driver.findElement(By.xpath("//span[contains(text(),'EXPENSES')]"));
	   @FindBy(xpath = "//a[contains(text(),'Expenses Master')]") WebElement Exp_Master;
	   @FindBy(xpath = "//a[contains(text(),'Expenses Category')]") WebElement Exp_Category;
	   @FindBy(xpath = "//a[contains(text(),'Expenses Subcategory')]") WebElement Expe_Subcategory;
	   @FindBy(xpath = "//a[contains(text(),'Expense Transactions Details')]") WebElement Exp_Trans_Details;
	   @FindBy(xpath = "//a[contains(text(),'Expense Transactions Details')]//ancestor::ul//following-sibling::li[5]/a") WebElement Expense_report;
	
	//Inventory
	WebElement Inventory = driver.findElement(By.xpath("//span[contains(text(),'INVENTORY')]"));
	   @FindBy(xpath = "//a[contains(text(),'Masters')]") WebElement Masters;
	   @FindBy(xpath = "//a[contains(text(),'Add Inventory')]") WebElement Add_Inventory ;
	   @FindBy(xpath = "//a[contains(text(),'Item Price')]") WebElement Item_Price;
	   @FindBy(xpath = "//a[contains(text(),'Stock Details')]") WebElement Stock_Details;
		@FindBy(xpath = "//a[contains(text(),'Item Sales')]") WebElement Item_Sales ;
		@FindBy(xpath = "//a[contains(text(),'Sales Transactions')]") WebElement Sales_Transactions;
	
	//GALLERY
	WebElement Gallery = driver.findElement(By.xpath("//span[contains(text(),'GALLERY')]"));
		@FindBy(xpath = "//a[contains(text(),'Photos Gallery')]") WebElement Photos_Gallery;
		@FindBy(xpath = "//a[contains(text(),'Photos Upload')]") WebElement Photos_Upload ;
		@FindBy(xpath = "//a[contains(text(),'Photo Delete')]") WebElement Photo_Delete;
	
	//FEES
	WebElement Fees = driver.findElement(By.xpath("//span[contains(text(),'FEES')]")); 
		@FindBy(xpath = "//a[contains(text(),'Fee Master')]") WebElement Fees_Mstr;
		@FindBy(xpath = "//a[contains(text(),'Fee Subcategory Master')]") WebElement Fee_Subcategory_Mstr;
		@FindBy(xpath = "//a[contains(text(),'Fee Subcategory Details')]") WebElement Fee_Subcategory_Details;
		@FindBy(xpath = "//a[contains(text(),'Pick Area vs Fee Subcategory')]") WebElement PickArea_Fee_Sub;
		@FindBy(xpath = "//a[contains(text(),'Fee Details')]") WebElement Fee_Details;
		@FindBy(xpath = "//a[contains(text(),'Fee Dues Import')]") WebElement Fee_Dues_Import;
		@FindBy(xpath = "//a[contains(text(),'Fee Concession Details')]") WebElement Fee_Concession_Det;
		@FindBy(xpath = "//a[contains(text(),'Fee Payment Details')]") WebElement Fee_Payment_Details;
		@FindBy(xpath = "//a[contains(text(),'Fee Reimbursement Upload')]") WebElement Fee_Reimb_Upload;
		@FindBy(xpath = "//a[contains(text(),'Fee Reimbursement Details')]") WebElement Fee_Reimbu_Details;
		@FindBy(xpath = "//a[contains(text(),'Update Fee Concession Details')]") WebElement Update_Fee_Concession_Details;
		@FindBy(xpath = "//span[contains(text(),'FEES')]//following::li[12]/a") WebElement Fee_Reports;
		
	//TRANSPORT
	WebElement Transport = driver.findElement(By.xpath("//span[contains(text(),'TRANSPORT')]"));
		@FindBy(xpath = "//a[contains(text(),'Vehicle Master')]") WebElement Tspt_Master;
		@FindBy(xpath = "//a[contains(text(),'Route Master')]") WebElement Route_Master;
		@FindBy(xpath = "//a[contains(text(),'Trip Master')]") WebElement Trip_Master;
		@FindBy(xpath = "//a[contains(text(),'Pick Up Area Master')]") WebElement PickUp_Area_Master;
		@FindBy(xpath = "//a[contains(text(),'Busroute Upload')]") WebElement Busroute_Upload;
		@FindBy(xpath = "//a[contains(text(),'Routes vs Vehicles')]") WebElement Route_OR_vehicles;
		@FindBy(xpath = "//a[contains(text(),'Route vs Pickup Area')]") WebElement Route_OR_Pickup;
		@FindBy(xpath= "//span[contains(text(),'TRANSPORT')]//following::li[8]/a") WebElement Tspt_Report;
	
	//GENERAL
	WebElement General = driver.findElement(By.xpath("//span[contains(text(),'GENERAL')]"));
	  @FindBy(xpath= "//a[contains(text(),'Holidays List Master')]") WebElement List_Master;
	  @FindBy(xpath= "//a[contains(text(),'Event List')]") WebElement Event_List;
	
	//Logs
	WebElement Logs = driver.findElement(By.xpath("//span[contains(text(),'LOGS')]"));
	      @FindBy(xpath= "//a[contains(text(),'Login History')]") WebElement Login_History;
	  	  @FindBy(xpath= "//a[contains(text(),'General Logs')]") WebElement General_Logs;
	
	public void launch() {
		
		System.setProperty("Webdriver.chrome.driver","C:\\Automation Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		driver.manage().window().maximize();
	}

}
