package com.dunn.telemedicine.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dunn.telemedicine.init.Iconstants;
import com.dunn.telemedicine.lib.Baselib;
import com.dunn.telemedicine.lib.excelLib;
import com.dunn.telemedicine.pages.LoginPage;

public class Loginwithoutemailverification  extends Baselib {
	
	@Test
	public void login() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String un = excelLib.getData("Sheet1",3,1,Iconstants.DataexcelPath);
		String pw = excelLib.getData("Sheet1",3,2,Iconstants.DataexcelPath);
		lp.doLogin(un, pw);
		String Actualtitle = driver.getTitle();
		System.out.println("Title of Dashboard Page : " +Actualtitle);
		String ExpectedTitle = excelLib.getData("Sheet1",2,1,Iconstants.Expectedoutput);
		Assert.assertEquals(Actualtitle, ExpectedTitle);
		WebElement msg = driver.findElement(By.xpath("//div[contains(text(),'You are not verified yet. ')]"));
		System.out.println("Message : " +msg.getText() );
		}
	}
