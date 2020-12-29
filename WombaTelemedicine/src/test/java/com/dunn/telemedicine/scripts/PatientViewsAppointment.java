package com.dunn.telemedicine.scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dunn.telemedicine.init.Iconstants;
import com.dunn.telemedicine.lib.Baselib;
import com.dunn.telemedicine.lib.excelLib;
import com.dunn.telemedicine.pages.LoginPage;
import com.dunn.telemedicine.pages.ViewsAppointments;

public class PatientViewsAppointment extends Baselib {
	
	@Test
	public void viewsAppointment() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String un = excelLib.getData("Sheet1",2,1,Iconstants.DataexcelPath);
		String pw = excelLib.getData("Sheet1",2,2,Iconstants.DataexcelPath);
		lp.doLogin(un, pw);
		String Actualtitle = driver.getTitle();
		System.out.println("Title of Dashboard Page : " +Actualtitle);
		String ExpectedTitle = excelLib.getData("Sheet1",2,1,Iconstants.Expectedoutput);
		Assert.assertEquals(Actualtitle, ExpectedTitle);
		ViewsAppointments va = new ViewsAppointments(driver);
		va.appointments();
		String ac = driver.findElement(By.xpath("//h1[contains(text(),'Appointments')]")).getText();
		System.out.println(ac);		
		String expec = excelLib.getData("Sheet1", 5, 1, Iconstants.Expectedoutput)	;
		Assert.assertEquals(ac, expec);
		}

}
