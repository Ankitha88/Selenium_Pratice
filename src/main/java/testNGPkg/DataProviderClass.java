package testNGPkg;

import org.testng.annotations.*;

public class DataProviderClass {
	
	@Test(dataProvider = "getDataMethod")
	public void Method1(String Username,String pswd,String abc) {
		System.out.println("Username" + Username);
		System.out.println("Password" + pswd);
		System.out.println("ABC  : " + abc);
	}
	
	@Test(dataProvider = "getDataMethod")
	public void Method2(String Username,String pswd,String abc) {
		System.out.println("Username" + Username);
		System.out.println("Password" + pswd);
		System.out.println("ABC  : " + abc);
		
	}
	
	@Test(dataProvider = "getDataMethod")
	public void Method3(String Username,String pswd,String abc) {
		System.out.println("Username :" + Username);
		System.out.println("Password : " + pswd);
		System.out.println("ABC  : " + abc);
		
	}
	
/*	@DataProvider
	public Object[][] getDataMethod(){
		Object[][] data = new Object[0][0];
		// First Row
		data[0][0] = "Donthi";
		data[0][1] = "Password123";
		//Second row
	//	data[1][0] = "Manandhi";
	//	data[1][1]= "Password456";
		
		return data;
		}
		
*/
	
	@DataProvider   //Syntax for DataProvider
	public Object[][] getDataMethod(){
		return new Object[][] {
			{"Donthi", "password123","95630"},{"manandhi","pswd456","95856"}
		};
	}
}
