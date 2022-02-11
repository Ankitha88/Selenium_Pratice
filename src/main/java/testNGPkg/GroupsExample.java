package testNGPkg;

import org.testng.annotations.Test;

public class GroupsExample {

	@Test(groups = "regression") // Regression is used when we need to execute this method in every project and every test case
	public void testMethod1() {
		System.out.println("I am in test Method 1");
	}

	@Test(groups = "regression")
	public void testMethod2() {
		System.out.println("I am in test Method 2");
	}

	@Test(groups = "smoketest")
	public void testMethod3() {
		System.out.println("I am in test Method 3");
	}

	@Test(groups = "sanitytest")
	public void testMethod4() {
		System.out.println("I am in test Method 4");
	}

}
