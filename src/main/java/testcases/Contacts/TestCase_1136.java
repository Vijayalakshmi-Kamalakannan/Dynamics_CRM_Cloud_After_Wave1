package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_ 1136: Validate deactivating a contact result in updating the contact end date and inactivating the contact account association records

public class TestCase_1136 {

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
			
			//Close Contact account association	
			.clickCloseInCAA()
			
		//3. Now deactivate the contact by clicking on the deactivate button
			.clickOnContactDeactivate()
			
			.clickConfirmDeactivation()
			
			//Check the Contact record status
			.verifyContactRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "contactRecordStatus", sDataSheetName))
			
			
		//4. Check the contact account association records and the related Job func and the communication records
			
			
		//5. Check the contact account association in inactive view  
			
			.clickGridViewInContactAccountAssociation()
			
			//Select contact inactive view
			.clickCAAAssociatedViewAndSelectContactInactiveView()
				
			//Verify relationship end date
		//	.verifyContactAccAssoRelatioEndDateInSubGridViewCurrentDate()
		
		//6.Check for the job func and communication records in inactive view
			.doubleClickOnContactAccountAssociationRecordInactiveView()

			// Check job function
			.verifyJobFunctionHasNoRecords(DataInputProvider.getCellData_ColName(iRowNumber, "errorMessage", sDataSheetName))
			
			//Check communication record status
			.verifyCommunicationPublicationsHasNoRecord(DataInputProvider.getCellData_ColName(iRowNumber, "errorMessage1", sDataSheetName))
			
			//Verify contact status in contact account association 
			.verifyContactRecordStatusInCAA(DataInputProvider.getCellData_ColName(iRowNumber, "contactRecordStatus", sDataSheetName))

	    ;
	}
}
