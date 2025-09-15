package com.pageobjectmanager;

import com.pageobjectmodel.NaukriLoginPage;
import com.pageobjectmodel.ProfileSummaryPage;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private static PageObjectManager manager;
	private static NaukriLoginPage loginpage;
	private FileReaderManager reader;
	private static ProfileSummaryPage profilepage;
	
	public static PageObjectManager getPageObjectManager() {
		if(manager == null) {
			manager = new PageObjectManager();
		}
		return manager;
	}
	
	public static NaukriLoginPage getNaukriLoginPage() {
		if(loginpage==null) {
			loginpage = new NaukriLoginPage();
		}
		return loginpage;
	}
	public FileReaderManager getFileReaderManager() {
		if(reader == null) {
			reader = new FileReaderManager();
		}
		return reader;
	}
	public ProfileSummaryPage getProfileSummaryPage() {
		if(profilepage==null) {
			profilepage=new ProfileSummaryPage();
		}
		return profilepage;
	}

}
