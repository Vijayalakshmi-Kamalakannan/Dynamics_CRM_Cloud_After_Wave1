package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_7138:Create new member - New Member form through sub account and save it as prospect first
public class TestCase_7138 {

	  	
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
	
	//2.Go to Workplace > Accounts and search for EIN 673415 
		.selectAccountsTab()
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
		
	//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectDirectParentFromSearchResults()
		.selectSubaccount()
		
	//4. Click on Add new account 
		.clickNewAccountInSubAccount()
	
	//5. Verify Direct parent and Top parent are populated 
		.verifyDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "verifyTopParent", sDataSheetName))
		.verifyTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
			
	//6. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))
		
			//Top Parent Relation =  OLM
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelation", sDataSheetName))
		
			//Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelationDate", sDataSheetName))
			 
			//type TP reason
			 .typeTPReason(DataInputProvider.getCellData_ColName(iRowNumber, "tpReason", sDataSheetName))
		 
			//Click on save 
	 		 .clickSave() 
			 		 
		//7. Verify CRM Account # is generated 
	 		 .verifyCRMNumberIsDisplayed()
		
		//8 Account  Type = Member
	 		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "accountType", sDataSheetName))
			
			//Class of Trade =Any
		 	.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "classOfTrade", sDataSheetName))
		 	
		 	//Business Classification = Auto populated
			.verifyBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "verifyBusinessClassification", sDataSheetName))
			
			//Account Status = Auto Populated to Active
			.verifyDefaultAccountStatus()	

			//Application Start Date = Today's Date
			.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "applicationDate", sDataSheetName))
		
			//CAMS Flag = Yes
			.changeCAMSFlagAsYes()
			
			//Participation Type = Standard
			.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "participationType", sDataSheetName))
				
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged() 
			
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "directParentRelationDate", sDataSheetName))
			
			//DP exception reason = Any
			.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))
					 
			//Click on Save 
			 .clickSave() 

		//9. Street 1 = Any
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))
			
			 //City = NY
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "city", sDataSheetName))
			
			//Type Zip code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))
			
			//Click on Save
			 .clickSave() 
			 
		// 10.Click the + icon on the Line of Business Grid
			.clickLineOfBusiness()
			
			//Click New Line Of Business
			.clickAddNewLineOfBusiness()
		
			// Line of Business =General GPO
			.selectLineOfBusiness(DataInputProvider.getCellData_ColName(iRowNumber, "lineOfBusiness", sDataSheetName))
			
			// Classification Type = General GPO
			.selectLOBfClassificationType(DataInputProvider.getCellData_ColName(iRowNumber, "lineOfClassification", sDataSheetName))
			
			// Start Date =Today's date
			.typeLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "lineOfBusinessStartDate", sDataSheetName))
			
			// Click on LOB Save 
			.clickLOBSaveAndClose()
		 	
		 //Click add new membership
			.clickMembershipAndAddNewMembership()
			
			// Choose Membership type 
		 	.selectMembershipType(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderType", sDataSheetName))
			.selectMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))
			
			//Provide any start date and click on save
			.typeMembershipStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderStartDate", sDataSheetName))
			
			//Click on membership save and close
			.clickQuickCreateMembershipSaveAndClose()

		//11. Record Status = Published
			.chooseRecordStatusPublished()
			
			//Click on Save 
			.clickSave() 
		
		//12. Verify Entity code is generated 
			.entityCodeIsDisplayed()
			
			//Verify Premier start date is auto populated
			.verifyPremierStartDateIsAutoPopulated()
			
			.verifyAffiliateGroupIsNotNull()
			.verifyAgEffectiveDateIsNotNull()
			
		//13. Verify "IS Corporate account" field
			.verifyIsCorporateAccount(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsCorporateAccount", sDataSheetName))
		
		//14. Verify Corporate parent name in the form
			.verifyCorporateParentName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
		
		//15. Verify "Is Food Service parent" field 
			.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsFoodServiceParent", sDataSheetName))
		
		//16 Verify Food Service parent name in the form 
			.verifyFoodServiceParentName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
		
		//17 Verify Sponsor field 
			.verifySponsor(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
		
		//16 Verify "Is Sponsor" field 
		.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsSponsor", sDataSheetName))
		
			//FBO details verification
			//Verify "Is FBO" field 
			.verifyIsFBO(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsFBO", sDataSheetName))
			
			//FBO
			.verifyFBO(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDirectParent", sDataSheetName))
					
			//FBORD
			.verifyFBORD(DataInputProvider.getCellData_ColName(iRowNumber, "verifyFBORD", sDataSheetName))
		
		//18  Go to > and click on Membership entity and double click on the Top parent membership entity
			.goToMembershipPage(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))
			//.doubleClickOnNationalMembership()
	
		//19 Click on > and go to Audit history 
			.selectMembershipAuditHistory()
	
		//20 Verify "Is Member Add mail sent" flag turned from No to Yes 
			.verifyIsMemberAddMailSent()
		
		//21 Verify the time-stamp on which the flag gets updated 
			.verifyTimeStampInTPMembershipAuditHistory()
					
			;
	}

}
