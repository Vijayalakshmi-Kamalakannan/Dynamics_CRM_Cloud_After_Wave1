package testcases.Member;

import java.awt.AWTException;
import pages.LoginPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;
public class TestCase_8803 {
	
//	Test Case 8998:Cloud: Validate Business Key and BK Active fields..
	
	public static void createMemberTP(int iRowNumber, String sDataSheetName)throws Exception, InterruptedException, AWTException
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
	
	  	 
			.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
			.selectAccountFromSearchResults()
			//9.Move the record status to draft and save  ***** Record moved to draft 
			.chooseRecordStatusDraft()
			
			//Click on Save 
			.clickSave() 
		
		//10.Go to membership and Open the Premier National membership ***** Premier National membership should be opened 
			.goToMembershipPage(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))
			//.doubleClickOnNationalMembership()
			
		//11.Provide end date = Any future date **** Account should be saved successfully 
			.typeMembershipEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))
			
			// End reason = Anything from dropdown,
			.selectMembershipEndReason(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndReason", sDataSheetName))
			
			// then save
			.clickSaveAndCloseInEditPage()
			.verifyCantTerminateMembershipError()
			.clickGoBack()
			.chooseRecordStatusPublished()
			.clickSave()
			;
	}
}
