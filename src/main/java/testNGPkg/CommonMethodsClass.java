package testNGPkg;

import org.testng.Assert;

public class CommonMethodsClass {
	
	public void verify_Condition(String exp_value, String act_value) {
		Assert.assertEquals(exp_value, act_value);
	}

}
