package com.inetBanking.testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.inetBanking.base.Baseclass;
import com.inetBanking.pageobjects.EditCustomerPage;
import com.inetBanking.pageobjects.Homepage;
import com.inetBanking.pageobjects.Loginpage;
import com.inetBanking.pageobjects.NewCustomerPage;

public class EditcustomerTest extends Baseclass {
	@Test
	public void editcustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Random random = new Random();
		int value = random.nextInt(10000);
		System.out.println(value);
		Loginpage lp=new Loginpage();
		Homepage hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));

		NewCustomerPage ncp = hp.newCustomer();
		ncp.createCustomer("hai", "02-12-1994", "varadaiah palem", "andhrapardesh", "tirupathi", "517457",
				"aasad"+value+"@gmail.com", "7896541230", "hsdfhabesd");

		String idString = dataFromExcelSheet.getdatafromExcelSheet("Sheet1", 1, 1);
		System.out.println(idString);
		Thread.sleep(3000);
	     EditCustomerPage ecp=hp.Editcustomer();

		ecp.customername(idString,"hyderabad", "12-11-2012", "karnataka");

	}

}
