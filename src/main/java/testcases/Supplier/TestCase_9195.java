package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_9195 {

//	TFS ID_9195:Cloud - Verify if Published Supplier Accounts cannot be made Inactive

	
	@Test()

	public void inactivesupplierAccountStatus(int iRowNumber, String sDataSheetName) throws Exception {
		//Access Login Page
		new LoginPage()
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
  	    .clicSignin()
  	    .clicYesInStaySignedin()
	
		//Select Accounts Entity
		.selectAccountsTab()
		
		//Search Existing Account using CRM#
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumberInput", sDataSheetName))
		
		//Choose the desired account from the search results
		.selectSupplierAccountFromSearchResults()
		
		//Verify Default Account Status on Supplier Form
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
		
		//Verify Default Account Type on Supplier Form
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
		
		//Click on Account Status as Inactive
		.chooseAccountStatus()
		
		//Save the information
		.clickSave()
		
		//Verify Supplier Account cannot be Inactive Error Message is Displayed
		.verifyInactiveAccountStatusError(DataInputProvider.getCellData_ColName(iRowNumber, "expectedAccountStatusErrorText", sDataSheetName));
						
	}


}