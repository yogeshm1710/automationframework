package practice2;

import org.testng.annotations.Test;

public class CreateContactWithSmokeAndReggTest {
	@Test(groups="smokeTest")
	public void contact()
	{
		System.out.println("contact created succefully");
	}
	@Test(groups="regressionTest")
	public void  information()
	{
		System.out.println("information saved");
	}
}
