package testNGPkg;

import org.testng.annotations.Test;

public class MethodIncludeExclude {
	
	@Test
	public void testMethod1() {
		System.out.println("I am in test Method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("I am in test Method 2");
	}

	@Test
	public void testMethod3() {
		System.out.println("I am in test Method 3");
	}

	@Test
	public void testMethod4() {
		System.out.println("I am in test Method 4");
	}

}
