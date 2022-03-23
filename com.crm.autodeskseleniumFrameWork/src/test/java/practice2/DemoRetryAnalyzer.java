package practice2;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 
 * @author yogesh
 *
 */
public class DemoRetryAnalyzer {
@Test(retryAnalyzer = com.vtiger.comcast.genericUtility.RetryAnalyzerImplementationClass.class)
public void demo()
{
	System.out.println("retry");
	Assert.assertEquals(true, false);
}
}
