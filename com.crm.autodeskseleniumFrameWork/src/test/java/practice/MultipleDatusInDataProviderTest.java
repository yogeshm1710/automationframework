package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDatusInDataProviderTest {

	//to execute same script with multiple data
	// use @DataProvider annotation ==> it will provide data to @test annotation
	@Test(dataProvider = "getdata")
	public void multipledata(String name, String company, String email, String empid)
	{
		System.out.println(name);
		System.out.println(company);
		System.out.println(email);
		System.out.println(empid);
		
		System.out.println();
	}
	 @DataProvider
	 public Object[][] getdata()
	 {
		Object[][] array = new Object[2][4];
		
		array[0][0]= "yogesh";
		array[0][1]="tcs";
		array[0][2]="yogi@gmail.com";
		array[0][3]="007";
		
		array[1][0]="Avishek";
		array[1][1]="hcl";
		array[1][2]="avi@gmail.com";
		array[1][3]="001";
		
		return array;
	 }
	
	
	
	
	
	
}
