package practice;

import org.testng.annotations.Test;

public class DependsOnMethodTest {
	@Test()
	public void createaccount() 
	{
		System.out.println("login");
		System.out.println("create account");
		System.out.println("logout");
	}

	@Test(dependsOnMethods="createaccount")
	public void modifyAccount() throws Exception
	{
		System.out.println("login");
		System.out.println("modify account");
		System.out.println("logout");
		//throw new Exception();

	}
	@Test(dependsOnMethods="modifyAccount")
	public void deleteAccount()
	{
		System.out.println("login");
		System.out.println("delete account");
		System.out.println("logout");
	}
}
