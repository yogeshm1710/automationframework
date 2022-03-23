package practice2;

import org.testng.annotations.Test;

public class CreateCampaignPrcTest {
	@Test(groups = "integrationTest")
	public void organization()
	{
		System.out.println("opportunity");
	}
	@Test(groups = {"FunctionalTest","sanityTest"})
	public void camp()
	{
		System.out.println("campaign created");
	}
	@Test(groups = {"smokeTest","integrationTest"})
	public void helpDesk()
	{
		System.out.println("help");
	}
	@Test(groups = "regressionTest")
	public void loginPage()
	{
		System.out.println("login");
	}
	@Test(groups = {"integressionTest","regressionTest"})
	public void logoutPage()
	{
		System.out.println("logout");
	}
}
