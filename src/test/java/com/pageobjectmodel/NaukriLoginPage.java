package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.NaukriLoginPageInterfaceElements;
import com.utility.FileReaderManager;

public class NaukriLoginPage extends BaseClass implements NaukriLoginPageInterfaceElements{
	
	@FindBy(xpath= email_xpath)
	private WebElement email;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;
	
	@FindBy(xpath = login_xpath)
	private WebElement login;
	
	public NaukriLoginPage(){
		PageFactory.initElements(driver, this);
		}
	
	public void Loginpage() {
		 inputPassing(email, FileReaderManager.getProperty("email"));
		 inputPassing(password, FileReaderManager.getProperty("password"));
		 elementClick(login);
	}
	}

