package testcases.Supplier;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_ 9200:Cloud- Verify new Supplier Diversity Types and Sub Classifications are available


public class TestCase_9200 {


	@Test
	public void verifySupplierDiversityInformation(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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
		//.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumberInput", sDataSheetName))
		.selectAllSupplierView()

		//Choose the desired account from the search results
		.selectSupplierAccountFromSearchResults()


		//Add New Diversity Information
		.selectDiversityType(DataInputProvider.getCellData_ColName(iRowNumber, "diversityType", sDataSheetName))
		.verifyMinorityOwndSubClassificationOptions()
		.addMinorityOwndDiversityType(DataInputProvider.getCellData_ColName(iRowNumber, "diversityType", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName)
				,DataInputProvider.getCellData_ColName(iRowNumber, "diversityStartDate", sDataSheetName),
				(DataInputProvider.getCellData_ColName(iRowNumber, "subClassification", sDataSheetName)))
		.addNewDiversityInfo()
		.verifyVeteranOwndSubClassificationOptions(DataInputProvider.getCellData_ColName(iRowNumber, "diversityType1", sDataSheetName))
		.addVeteranOwndDiversityType(DataInputProvider.getCellData_ColName(iRowNumber, "diversityType1", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "diversityStartDate", sDataSheetName),
				(DataInputProvider.getCellData_ColName(iRowNumber, "subClassification1", sDataSheetName)))
		.addNewDiversityInfo()
		.addLGBTOwndDiversityType(DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "diversityStartDate", sDataSheetName))
		.addNewDiversityInfo()
		.addSmallBusinesDiversityType(DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "diversityStartDate", sDataSheetName))
		.addNewDiversityInfo()
		.addWomenOwndDiversityType(DataInputProvider.getCellData_ColName(iRowNumber, "certifyingAgency", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "diversityStartDate", sDataSheetName))


		//Data Reset
		.deactivateAllDiversityInfo()
		.clickConfirmDiversityDeactivation();



	}
}
