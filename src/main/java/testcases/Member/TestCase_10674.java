package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_10674-Cloud :Base Read Only should NOT have access to "# of Estimated Locations"

public class TestCase_10674 {

	  	
	@Test
	public void verifyBaseReadOnlyEstLoc(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM as BaseReadOnly 
		new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
		
		//2. Go to Workplace >> Take Any Member Account 
	  	  .selectAccountsTab()		
			.selectActiveMembers()
			.selectAccountFromSearchResults()

		//3.Verify  NIACS code field access 
			.clickNYInformationTab()
			.verifyEstimatedNumLocationsIsNotEditable();
								
			
		
		//data reset-not required
			
			
		
				
			
	}
}
