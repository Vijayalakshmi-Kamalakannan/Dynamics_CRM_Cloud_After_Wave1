package testcases.Supplier;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_ 9182:Cloud -Add Diversity information to a supplier


public class TestCase_9182 {


	@Test
	public void replacePrimaryContactOnSupplier(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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



		//Verify Diversity Info fields
		.verifyDiversityInfoFields()


		//Add New Diversity Information
		.addNewDiversityInfo(DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "diversityType", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "diversityStartDate", sDataSheetName))


		//Data Reset

		.deactivateDiversityInfo();


	}
}
