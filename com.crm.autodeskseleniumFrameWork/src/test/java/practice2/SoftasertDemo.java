package practice2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftasertDemo {
	@Test
	public void sf()
	{
		int a = 55;
		int b = 0;
		int c = 23;
		int g = 23;
		String d = null;
		String e = "apple";
		String f = "google";
		String h = "apple";
		String m = "google12";
		boolean n= true;
		boolean o= false;
		
		SoftAssert s = new SoftAssert();
		//s.assertEquals(c, g);
		//s.assertNotEquals(n, o);
		//s.assertSame(h, e);
		//s.assertEquals(m.contains(f), true);
		//s.assertNotSame(s, e);
		//s.fail();
		s.notifyAll();
		s.assertAll();
			
	}

}
