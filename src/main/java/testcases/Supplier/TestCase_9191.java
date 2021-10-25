package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//Test Case 9191:Cloud - Create a supplier child account


public class TestCase_9191 {
	
	@Test()

	public void createSupplierWithSupplierLogin(int iRowNumber, String sDataSheetName) throws Exception {
		new LoginPage()
		//1. Login to CRM as a Supplier Supervisor  *** User should be logged in successfully 
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
		
		//2. From the left navigation column ,Go to My Work>Accounts > + New
			.selectAccountsTab()
			.clickNewOnAccountsPage()
			.chooseSupplierForm()
		
		//4. Fill in all Mandatory Fields to create Supplier Child Account: 
			//Account Name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))	
			
			//Business Classification = Any
			.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "businessClassification", sDataSheetName))
			
			//Direct Parent  =2000133648
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
			
			//Direct Parent Relation Date  =Any
			.selectDPParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "selectDPRelationDate", sDataSheetName))
			
			//Top Parent Relation Date = Any
			.pickTPRD(DataInputProvider.getCellData_ColName(iRowNumber, "selectTPRelationDate", sDataSheetName))
			
			//Street 1  =Any
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))
			
			//Zip Code = Any
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))
			
			//Account Status = Auto populated  ( Active)
			.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
			
			//Account Type = Auto populated  (Supplier)
			.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
			
			//Record Status = Draft (Default)
			.recordStatusDraft()
			 
			//Save the Record
			.clickSave()
						
		//5.Verify the Premier Start Date.
			.verifyPremierStartDateAsCurrentDate()
			
		//6.Modify Premier Start Date to different date and save ***The new Premier Start Date should be saved 
			.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))
			//Save the Record
			.clickSave()
			
		//7.Change Record Status = Published and save  *** The Supplier Record should be published and Entity Code should be generated .
			.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))	
			//Save the Record
			.clickSave()
			.entityCodeIsDisplayed()

			
		//8.Go to Membership  Entity and verify the Premier/National Membership *** The Premier/National Membership should be created with Start Date as  Premier Start Date	
			.selectMembership()
			//Double click on the Premier: National Membership   
			.verifyNationalMembership(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))

		;	
	}
}
