package testNGPkg;

import org.testng.annotations.Test;

public class Priority {
	
	@Test(priority = 3 ,enabled = true)
	public void testMethod1() {
		System.out.println("I am in test Method 1");
	}

	@Test(priority = 1, enabled= true, invocationCount = 5,successPercentage = 50) //Invocation count is used to repeat the test for multiple times
	public void testMethod2() {
		System.out.println("I am in test Method 2");
	}

	@Test(priority = 2, alwaysRun = true, enabled = false  ) //enabled has more priority
	public void testMethod3() {
		System.out.println("I am in test Method 3");
	}

}

