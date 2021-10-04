package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7162 {
	
	//Automation - Convert a Supplier Main Account to Ship To Location Type Account using Supplier Supervisor Login

	
	@Test()

	public void convertMainToShipToUsingSupplierSupervisor(int iRowNumber, String sDataSheetName) throws Exception {
		
		//Access Login Page
		new LoginPage()
		
		//Type the Username
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
  	    .clicSignin()
  	    .clicYesInStaySignedin()
		
		//Select Accounts Entity
		.selectAccountsTab()
		
		//Search Existing Account using CRM#
		.searchMemberAccount(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumberInput", sDataSheetName))
		
		//Choose the desired account from the search results
		.selectSupplierAccountFromSearchResults()	
		
		//Verify Account Name of the Selected record
		.verifyAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyAccountName", sDataSheetName))		
		
		//Verify Default Account Status on Supplier Form
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
		
		//Verify Default Account Type on Supplier Form
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
		
		//Choose Record Status as Draft.
		.recordStatusDraft()
		
		//Save the information
		.clickSave()
		
		//Choose Store Location Type as Ship To
		.storeLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "storeLocationType", sDataSheetName))
		
		//Verify if CRM# is generated.
		.crmNumberIsDisplayed()
		
		//Save the information
		.clickSave()
		
		//Choose Record Status as Published
		.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))
		
		//Save the information
		.clickSave()
		
		//Verify Entity Code is displayed
		.entityCodeIsDisplayed()
		
		//Verify Entity Code is displayed same as Direct Parent's Entity Code
		.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "verifyEntityCode", sDataSheetName))
		
		//Revert Store Location Type
		.storeLocationTypeBlank()
		
		//Save the information
		.clickSave();
	
	}


}