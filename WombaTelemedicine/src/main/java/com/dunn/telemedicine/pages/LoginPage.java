package com.dunn.telemedicine.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dunn.telemedicine.lib.GenericLib;

public class LoginPage {
WebDriver driver;
	

@FindBy(id = "username")
private WebElement usrname;

@FindBy(id = "password")
private WebElement psw;

@FindBy(name = "submit")
private WebElement loginBtn;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void doLogin(String username, String password)
{
	GenericLib.enterText(driver, usrname, username, "Username TextBox");
	GenericLib.enterText(driver, psw, password, "password TextBox");
	GenericLib.clickElement(driver, loginBtn, "Login Btn");
}
	public String getLoginPage()
	{
		return driver.getTitle();
		
	}
}
