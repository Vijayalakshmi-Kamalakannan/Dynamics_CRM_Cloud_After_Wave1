package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_ 4548: Verify if duplicate contact account association cannot be created for any contact


public class TestCase_4548 {
	
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Go to Contacts >> Choose any contact which is active. Add contact account association with any member and create Job func/Communication records for it
		.clickWorkplace()	
		.selectContacts()
		.clickNewOnContactsPage()
		
			// Provide First name = Any	
			//Last name = Any
			.typeContactName((DataInputProvider.getCellData_ColName(iRowNumber, "firstName", sDataSheetName)),(DataInputProvider.getCellData_ColName(iRowNumber, "lastName", sDataSheetName)))
			
			//Primary Account = 1000155094
			.selectPrimaryAccount(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount", sDataSheetName))
		
			//Save the record
			.clickSave()
			
			// Observe the Innovatix Contact ID field
			.isInnovatixContactIDDisplayed()
		
			// Change the record start from Draft to Published then save
		    .chooseRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatus", sDataSheetName))  
	    
		    //Click on Save
			.clickSave()
			
			//clickSaveDuplicateDetected
			.clickSaveDuplicateDetected()
			
			//Click on refresh
			.pageRefresh()
		    
		//3. Add a new contact account association with any member for that contact
			//Click on Add contact account association
			.clicAddContatAccountAssociation()
			
			//Enter account name CAA
			.typeAccountInCAA(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))
			
			//Click on save
			.clickSaveInContactAccountAssociation()
			
			//Verify created contact account association
			
			
		//4.Try to add same account to the contact account association
			//Click on Add contact account association
			.clicAddContatAccountAssociation()
			
			//Enter account name CAA
			.typeAccountInCAA(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))
			
			//Click on save
			.clickSaveInContactAccountAssociation()	
			
			//Verify error message
			.verifyErrorMsgForDuplicateCAA(DataInputProvider.getCellData_ColName(iRowNumber, "errorMessage", sDataSheetName))
			
			//Click on ok 
			.clickOkErrorMsgForDuplicateCAA()

	    ;
	}
}
