package practice2;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class TestNGxmlDemo {
	@Test
	public void fetchDataFromxml(XmlTest xml)
	{
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));

	}

}
