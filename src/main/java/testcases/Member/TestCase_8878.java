package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS_ID_8878-Cloud : Limited member should have access to "# of Estimated Locations"

public class TestCase_8878 {

	  	
	@Test
	public void verifyLimitedMemberEditablefields(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM as Limited member 
		new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
		
		//2. Go to Workplace >> Take Any Member Account 
		.selectAccountsTab()		
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber", sDataSheetName)) 
		.selectAccountFromSearchResults()

		//3.Verify  NIACS code field access 
			.verifyEstLocIsEditable(DataInputProvider.getCellData_ColName(iRowNumber, "numEstLoc", sDataSheetName))
			
								
			.clickNyTabSave();
		
						
		
				
			
	}
}
