package com.dunn.telemedicine.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.dunn.telemedicine.init.Iconstants;
import com.dunn.telemedicine.lib.Baselib;
import com.dunn.telemedicine.lib.excelLib;
import com.dunn.telemedicine.pages.LoginPage;


public class Login extends Baselib {
	
	@Test
	public void login() throws InterruptedException
	{
	LoginPage lp = new LoginPage(driver);
	String un = excelLib.getData("Sheet1",2,1,Iconstants.DataexcelPath);
	String pw = excelLib.getData("Sheet1",2,2,Iconstants.DataexcelPath);
		lp.doLogin(un, pw);
		}
	}
