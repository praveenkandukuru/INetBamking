package com.inetBanking.testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.inetBanking.base.Baseclass;
import com.inetBanking.pageobjects.DeleteCustomerPage;
import com.inetBanking.pageobjects.Homepage;
import com.inetBanking.pageobjects.Loginpage;
import com.inetBanking.pageobjects.NewCustomerPage;

public class DeletecustomerTest extends Baseclass{
	@Test()
	public void deletecustomer() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Random random = new Random();
		int value = random.nextInt(10000);

		Loginpage lp=new Loginpage();
	Homepage hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
	NewCustomerPage ncp=hp.newCustomer();
	ncp.createCustomer("hai", "02-12-1994", "varadaiah palem", "andhrapardesh", "tirupathi", "517457",
			"aasad" + value + "@gmail.com", "7896541230", "hsdfhabesd");
	String idString = dataFromExcelSheet.getdatafromExcelSheet("Sheet1", 1, 1);
	System.out.println(idString);
	DeleteCustomerPage dcp=	hp.deleteCustomer();

	dcp.deleteCount(idString);
	
	
		
		
	}

}
