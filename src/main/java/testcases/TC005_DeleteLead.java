package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC005_DeleteLead extends ProjectMethods{
	
	@BeforeTest
	public void setData() {
		testCaseName="TC005_DeleteLead";
		testDescription="Delete Lead";
		testNodes="Leads";
		category="Smoke";
		authors="Arun";
		browserName="chrome";
		dataSheetName="TC005";
	}	
	
	@Test(dataProvider="fetchData")
	public void loginAndLogout(String uName,String pwd,String phNo,String recordAvailability ) {
		 FindLeadsPage flp = new LoginPage()
		//new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogIn()
		.clickOnCrmsfa()
		.clickLeads()
		.clickFindLead()
		.clickOnPhoneTab()
		.TypePhoneNo(phNo)
		.clickFindLeads();
		String firstLeadID=flp.firstLeadNo();
		flp.clickFirstResult()
		.clickDeleteButton()
		.clickFindLead()
		.typeFirstLead(firstLeadID)
		.clickFindLeads()
		.verifyTheAvailableRecords(recordAvailability);
	}
}
