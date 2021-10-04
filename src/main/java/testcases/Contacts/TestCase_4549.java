package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_ 4549:Verify once the Contact's relationship end date is updated then its job function and communications should get terminated

public class TestCase_4549 {
	
	
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
		    
			// Click on Contact Account association record created
			.doubleClickOnContactAccountAssociationRecord()
		    
			// Click on Add new Job function
			.clicAddJobFunction()
		    
			// Select "Bid Proposal Team" as Job function and click on Save
			.typeJobFunction(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
			//Click on Save
			.clickSaveInJobFunction()
			
			//Verify created job function
			.verifyJobFunctionIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
			// Click on add new Communication/Publications
			.clicAddCommunicationPublication()
		    
			// Select "Roster-Hierarchy Roster" as Communication then save
			.typeCommunicationPublication(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
			
			//Click on Save
			.clickSaveInCommunicationPublication()
			
			//Verify created communication publications
			.verifyCommPublicationsIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
			
		
		//3.Open the Contact account association and update the relationship end date and terminated reason as "Terminated" on the contact account association then save it
			.typeContactRelationshipEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "contactRelationshipEndDate", sDataSheetName))
			
			//choose termination reason
			.chooseContactTerminationReason(DataInputProvider.getCellData_ColName(iRowNumber, "terminationStatus", sDataSheetName))
			
			//SAve the record
			.clickSave()
			
		//4. Now check the Job function and communication records
			
			//Verify contact status in contact account association 
			.verifyContactRecordStatusInCAA(DataInputProvider.getCellData_ColName(iRowNumber, "contactRecordStatus", sDataSheetName))
			
			// Check job function
			.verifyJobFunctionTerminationStatus(DataInputProvider.getCellData_ColName(iRowNumber, "terminationStatus", sDataSheetName))
			
			//Check communication record status
			.verifyCommunicationPublicationsTerminationStatus(DataInputProvider.getCellData_ColName(iRowNumber, "terminationStatus", sDataSheetName))
	
	    ;
	}
}
