package testcases.Supplier;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_9193  {
	
	//TFSID-9193 : Cloud - Supplier Form should default Account Type and Account Status 
	
	@Test()
	public void createSupplierTP(int iRowNumber, String sDataSheetName)throws Exception,InterruptedException {
		
		//Access Login Page
		new LoginPage()
		
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
  	    .clicSignin()
  	    .clicYesInStaySignedin()
		
		//Select Accounts Entity
		.selectAccountsTab()
		
		//Click on +New ( goes to Accounts Page)
		.clickNewOnAccountsPage()
		
		//Choose 'Supplier Form' Option
		.chooseSupplierForm()
		
		//Verify Default Account Status on Supplier Form
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))	
		
		//Verify Default Account Type on Supplier Form
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName));		
		
		}
	
}