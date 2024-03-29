package testcases.DoNotVerifyAddress;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

//Test Case 11436:Verify whether if 'Do Not Verify Address' Field is set to 'No' , Address Cleansing should be enabled on Member Form.

public class TestCase_11436 {


	@Test
	public void DoNotVerifyAddress(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		new WebDriverServiceImpl();
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()
		.clicYesInStaySignedin()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.selectAccountsTab()
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()

		.navigateToDoNotVerifyEnterData(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))

		.selectDonotVerify("No")

		.clickSave()

		.clickNyInformationTab().clickGeneralTab()
		.navigateToState()
		.getSatteValue()
		.typeState("SS")
		.clickSave()

		.clickNyInformationTab().clickGeneralTab()
		.navigateToState()
		.getSatteValue()
		.verifyStateValue("SS", true)
		.clickSave()
		.NavigateToSystemTab()
		.verifyMellissa()
		;
	}

}
