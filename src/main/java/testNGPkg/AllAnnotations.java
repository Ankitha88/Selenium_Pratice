package testNGPkg;

import org.testng.annotations.*;

public class AllAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am in Before Suite5");
		System.out.println("I am in Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am in After Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am in before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("I am in after Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I am in before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("I am in after Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I am in after Method");
	}

	@Test
	public void testMethod() {
		System.out.println("I am in Test method");
		//GIT commit
		System.out.println("Adding changes in Git repository");
	

	}
	
}
