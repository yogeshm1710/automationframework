package practice2;

import org.testng.annotations.Test;

public class CreateOrgWithSmokeAndReggTest {
@Test(groups="smokeTest")
public void organization()
{
	System.out.println("organization created successfully");
}
@Test(groups="regressionTest")
public void companyName()
{
	System.out.println("company name is tyss");
}
}
