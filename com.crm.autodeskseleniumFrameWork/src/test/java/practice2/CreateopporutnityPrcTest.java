package practice2;

import org.testng.annotations.Test;

public class CreateopporutnityPrcTest {
	
@Test(groups = "integrationTest")
public void opporutunity()
{
	System.out.println("opportunity");
}
@Test(groups = {"FunctionalTest","sanityTest"})
public void campaign()
{
	System.out.println("campaign created");
}
@Test(groups = {"smokeTest","integrationTest"})
public void help()
{
	System.out.println("help");
}
@Test(groups = "integrationTest")
public void login()
{
	System.out.println("login");
}
@Test(groups = "regressionTest")
public void logout()
{
	System.out.println("logout");
}
}
