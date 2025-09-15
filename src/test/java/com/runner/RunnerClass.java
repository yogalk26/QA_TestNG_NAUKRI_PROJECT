package com.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

public class RunnerClass extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		browserLaunch(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("browser"));
		implicitlyWait("seconds",30);
		launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("url"));
		implicitlyWait("seconds",30);
		
		PageObjectManager.getPageObjectManager().getNaukriLoginPage().Loginpage();
		
		PageObjectManager.getPageObjectManager().getProfileSummaryPage().profilepage();
		
		//navigateMethods("refresh");
		
		browserTerminate();
	}

}


