package practice2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	 @Test
	 public void hdast()
	 {
		 int a = 10;
		 int b = 20;
		String c= null;
		 boolean flag1 =  true;
		 boolean flag2 = false;
		 
		 String e ="12";
		 String f = "12";
		 
		 //Assert.assertEquals(a, b);
		// Assert.assertEquals(flag1, flag2);
		// Assert.assertEquals(f, e);
		// Assert.assertNotEquals(a, b);
		 //Assert.assertSame(f, e, "passed");
		// Assert.assertSame(f, e);
		 //Assert.assertNotSame(e, f);
		 //Assert.assertTrue(flag1);
		// Assert.assertTrue(flag2);
		// Assert.assertFalse(flag2);
		 //Assert.assertFalse(flag1, "hello");
		// Assert.assertNull(a);
		// Assert.assertNull(c);
		 Assert.assertNotNull(e);

	 }

}
