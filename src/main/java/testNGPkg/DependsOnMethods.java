package testNGPkg;

import org.testng.annotations.*;

public class DependsOnMethods {

	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I am in After method");
	}
	
	@Test(dependsOnMethods = "testMethod3")  //this is used to set the priority of execution of methods
	public void testMethod1() {
		System.out.println("I am in test method 1");
	}
	
	@Test (dependsOnMethods = "testMethod1")
	public void testMethod2() {
		System.out.println(" I am in Test method 2");
	}
	
	@Test
	public void testMethod3() {
		System.out.println("i am in test method 3");
	}
}
