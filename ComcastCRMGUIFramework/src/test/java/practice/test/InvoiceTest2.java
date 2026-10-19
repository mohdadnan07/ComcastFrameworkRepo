package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;


//@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest2{
	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
		 Assert.assertEquals("", "Login");
		 System.out.println("Step-1");
		 System.out.println("Step-2");
		 System.out.println("Step-3");
		 System.out.println("Step-4");
	}
	

}
