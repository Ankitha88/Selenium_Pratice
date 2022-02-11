package testNGPkg;

import org.testng.annotations.Test;

public class DependsOnMethodsAndGroups {
	

	 @Test(groups = "pre-tests")
	public void init() {
	System.out.println("I am in init Method");
	}

	@Test(groups = "tests",dependsOnGroups = "pre-tests")
	public void insert() {
	System.out.println(" I am in Insert Method");
	}

	@Test(groups = "tests", dependsOnMethods = "insert")
	public void selectMethod() {
	System.out.println("I am in selectMethod");
	}

	@Test( groups = "tests", dependsOnMethods = "selectMethod")
	public void updatedMethod() {
	System.out.println("I am in UpdateMethod");
	}

	@Test(groups = "tests", dependsOnMethods = "updatedMethod")
	public void deleteMethod() {
	System.out.println("I am in DeleteMethod");
	}

	@Test(dependsOnGroups = "tests",ignoreMissingDependencies = true)
	public void cleanUpMethod() {
	System.out.println("I am in CleanUpMethod");
	}

}
