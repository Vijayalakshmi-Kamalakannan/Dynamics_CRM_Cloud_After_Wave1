package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;
//TFS ID_ 8909:Cloud: Verify if HIN accepts Characters, Numbers, Alphanumeric values but it should be 9 char in length

public class TestCase_8908 {

	  	
	@Test
	public void VerifyHINInput(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()

		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()

		.clicYesInStaySignedin()

		//2. From the left navigation column ,Go to Accounts > +New
		.selectAccountsTab()
		.selectActiveMembers()
		.verifyAccountnumberColumns()
		.searchString(DataInputProvider.getCellData_ColName(iRowNumber, "DEANumber", sDataSheetName))
		.verifyAccountisDisplayed()
		.clickclearButton()
		.searchString(DataInputProvider.getCellData_ColName(iRowNumber, "HIN", sDataSheetName))
		.verifyAccountisDisplayed()
		;
	}
}
