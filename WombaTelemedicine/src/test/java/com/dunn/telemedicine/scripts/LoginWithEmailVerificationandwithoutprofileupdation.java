package com.dunn.telemedicine.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dunn.telemedicine.init.Iconstants;
import com.dunn.telemedicine.lib.Baselib;
import com.dunn.telemedicine.lib.excelLib;
import com.dunn.telemedicine.pages.LoginPage;

public class LoginWithEmailVerificationandwithoutprofileupdation extends Baselib{
	 
		
		@Test
		public void login() throws InterruptedException
		{
			LoginPage lp = new LoginPage(driver);
			String un = excelLib.getData("Sheet1",4,1,Iconstants.DataexcelPath);
			String pw = excelLib.getData("Sheet1",4,2,Iconstants.DataexcelPath);
			lp.doLogin(un, pw);	
			WebElement	 Stepname=	driver.findElement(By.xpath("//div[@class='profile-step-info']"));
			System.out.println(Stepname.getText());
			String Actualtitle=	Stepname.getText();
			String ExpectedTitle = excelLib.getData("Sheet1",3,1,Iconstants.Expectedoutput);
			Assert.assertEquals(Actualtitle, ExpectedTitle);

		}
	}
