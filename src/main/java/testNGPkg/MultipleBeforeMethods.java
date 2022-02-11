package testNGPkg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class MultipleBeforeMethods {
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println(" I am in 1st before Method");
	}
	
	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("I am in before method 2");
	}
	
	@Test
	public void testMethod(){
		System.out.println("I am in test method");
	}

}
