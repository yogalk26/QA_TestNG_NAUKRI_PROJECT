package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.ProfileSummaryInterfaceElements;

public class ProfileSummaryPage extends BaseClass implements ProfileSummaryInterfaceElements{
	
	@FindBy(xpath=completeprofile_xpath)
	private WebElement completeprofbtn;
	
	public ProfileSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void profilepage() {
		elementClick(completeprofbtn);
	}
	
	

}
