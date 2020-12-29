package com.dunn.telemedicine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dunn.telemedicine.lib.GenericLib;

public class ViewsAppointments {
	WebDriver driver;
	

	@FindBy(xpath = "//a[contains(text(),'Appointments')]")
	private WebElement appointment;

	
	public ViewsAppointments(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	}
	public void appointments()
	{
		
		GenericLib.clickElement(driver, appointment, "Appointment Btn");
		
		}
	}
	
	

