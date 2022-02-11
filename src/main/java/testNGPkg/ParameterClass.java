package testNGPkg;

import org.testng.annotations.*;

public class ParameterClass {
	@Parameters("name")
	@Test
	public void Method1(String name) {
		System.out.println("i am in Method1");
		System.out.println("String Value : " + name );
	}

}
