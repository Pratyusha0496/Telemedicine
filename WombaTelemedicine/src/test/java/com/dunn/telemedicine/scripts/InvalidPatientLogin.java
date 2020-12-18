package com.dunn.telemedicine.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dunn.telemedicine.init.Iconstants;
import com.dunn.telemedicine.lib.Baselib;
import com.dunn.telemedicine.lib.excelLib;
import com.dunn.telemedicine.pages.LoginPage;

public class InvalidPatientLogin extends Baselib {
	
	@Test
	public void login() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		String un = excelLib.getData("Sheet1",2,1,Iconstants.DataexcelPath);
		String pw = excelLib.getData("Sheet1",4,1,Iconstants.DataexcelPath);
		lp.doLogin(un, pw);
		WebElement invalid = driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]/span"));
		String Actualtitle = invalid.getText();
		driver.getTitle();
		System.out.println("Title of Dashboard Page : " +Actualtitle);
		String ExpectedTitle = excelLib.getData("Sheet1",4,1,Iconstants.Expectedoutput);
		Assert.assertEquals(Actualtitle, ExpectedTitle);
		}

}
