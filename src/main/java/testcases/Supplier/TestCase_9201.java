	package testcases.Supplier;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_9201: Cloud-Verify new field Certifying Agency available in Supplier Diversity Entity


public class TestCase_9201 {


	@Test
	public void verifyCertAgencyField(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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

		//Verify Certifying Agency field validation

		.verifyCertifyingAgency(DataInputProvider.getCellData_ColName(iRowNumber, "verifyCertifyingAgencyError", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName))
		
		//data reset
		.deactivateDiversityInfoDivAssociatedView();

	}
}
