package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC004_EditLead extends ProjectMethods{
	
	@BeforeTest
	public void setData() {
		testCaseName="TC004_EditLead";
		testDescription="Edit Lead";
		testNodes="Leads";
		category="Smoke";
		authors="Arun";
		browserName="chrome";
		dataSheetName="TC004";
	}	
	
	@Test(dataProvider="fetchData")
	public void loginAndLogout(String uName,String pwd,String fName,String CName ) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogIn()
		.clickOnCrmsfa()
		.clickLeads()
		.clickFindLead()
		.typeFirstName(fName)
		.clickFindLeads()
		.clickFirstResult()
		.clickEditButton()
		.typeCompanyName(CName)
		.ClickUpdate()
		.VerifyCompanyName(CName);
	}
}
