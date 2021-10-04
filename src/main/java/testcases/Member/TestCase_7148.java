package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;


//Test Case 7148:Create new Shipto account - New Member entry form and Save it as prospect first

public class TestCase_7148 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{
		//1. Login to CRM using member supervisor / member credentials 
			new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()

		//2. From the left navigation column ,Go to Accounts > +New
	  	    .selectAccountsTab()
	  	  	.clickNewOnAccountsPage()
			.chooseMemberEntryForm()
		
		//3. Account Name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))
		
			//Click on save 			
			.clickSave() 
		
		//4. Verify CRM Account # is generated 
			.verifyCRMNumberIsDisplayed()	
		
		//5. Account Type = Member
			.selectAccountTypeMEF(DataInputProvider.getCellData_ColName(iRowNumber, "accountType", sDataSheetName))
				
			//Class of Trade =Any
			.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "classOfTrade", sDataSheetName))
			
			//Business Classification = Auto populated
			.verifyBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "verifyBusinessClassification", sDataSheetName))
			
			//Account Status = Auto Populated to Active
			.verifyDefaultAccountStatus()	
			
			//Store/Location type = Bill to
			.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "locationType", sDataSheetName))	
					
			//CAMS Flag = Yes
			//.changeCAMSFlag()
			
			//Direct Parent Entity Code = 673415
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
				
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged() 
					
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "directParentRelationDate", sDataSheetName))
					
			//Top Parent Relation =  OLM
			.selectTopParentRelationMEF(DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelation", sDataSheetName))
			
			// Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelationDate", sDataSheetName))
					 
			//Click on Save 
			 .clickSave() 
					 
		//6. Street 1 = Any
			 .typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))
				
			 //City = NY
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "city", sDataSheetName))
			
			 //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "country", sDataSheetName))
			
			//Type Zip code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
				
			//Click on Save 
			.clickSave() 
				
		//7. Record Status = Published
			
			.chooseRecordStatusPublishedMEF()				
				
			//Click on Save 
			.clickSave() 
				
		//8. Verify Entity code is same as DP's entity code 
			.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
		
		//Verify Premier start date is auto populated
			.verifyPremierStartDateIsAutoPopulated()
			
			.verifyAgEffectiveDateIsNull()
			.verifyAffiliateGroupIsNull()
				
		//9. Verify "IS Corporate account" field
			.verifyIsCorporateAccountMEF(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsCorporateAccount", sDataSheetName))
		
		//10. Verify Corporate parent name in the form
			.verifyCorporateParentName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
			
		//11. Verify "Is Food Service parent" field 
			.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsFoodServiceParent", sDataSheetName))
		
		//12 Verify Food Service parent name in the form 
			.verifyFoodServiceParentName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
			
		//13 Verify Sponsor field 
			.verifySponsor(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
		
		//14 Verify "Is Sponsor" field 
			.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsSponsor", sDataSheetName))
			
			;


	}
}
