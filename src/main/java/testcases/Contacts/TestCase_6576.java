package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_ 6576:Automation :Verify Duplicate detection rule applies when Communication or Publication entered twice by the user


public class TestCase_6576 {
	
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2.Go to workplace>Contacts and identify any active contact
		.clickWorkplace()	
		.selectContacts()
		.clickNewOnContactsPage()
		
		//3. Provide First name = Any	
			//Last name = Any
			.typeContactName((DataInputProvider.getCellData_ColName(iRowNumber, "firstName", sDataSheetName)),(DataInputProvider.getCellData_ColName(iRowNumber, "lastName", sDataSheetName)))
			
			//Primary Account = 1000155094
			.selectPrimaryAccount(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount", sDataSheetName))
		
			//Save the record
			.clickSave()
			
		// Observe the Innovatix Contact ID field
		.isInnovatixContactIDDisplayed()
		
		//Change the record start from Draft to Published then save
		    .chooseRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatus", sDataSheetName))  
	    
		    //Click on Save
			.clickSave()
			
			//clickSaveDuplicateDetected
			.clickSaveDuplicateDetected()
			
			//Click on refresh
			.pageRefresh()
		    
	    //3. Go to Contact Account association view and click on the record			
			.doubleClickOnContactAccountAssociationRecord()
		    
		//4. Click on the + icon on the Job function and add any Job function for the contact say ex. Finance and save
			.clicAddJobFunction()
		    
			//Select "Bid Proposal Team" as Job function and click on Save
			.typeJobFunction(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
			//Click on Save
			.clickSaveInJobFunction()
			
			//Verify created job function
			.verifyJobFunctionIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
		//5.Click on the + icon on the Job function and add the same Job function again for the contact say ex. Finance and save 
			.clicAddJobFunction()
		    
			//Select "Bid Proposal Team" as Job function and click on Save
			.typeJobFunction(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
			//Click on Save
			.clickSaveInJobFunction()
			
		//6.Click on OK on the duplicate popup and check duplicate job function is accepted by the system
			.clickSaveDuplicateDetected()
			
			//Verify duplicate job function is accepted
			.verifyDuplicateJobFunctionIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
		//7. Try adding duplicate Communication and check user is allowed to save the record
			//Click on add new Communication/Publications
			.clicAddCommunicationPublication()
		    
			//Select "Roster-Hierarchy Roster" as Communication then save
			.typeCommunicationPublication(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
			
			//Click on Save
			.clickSaveInCommunicationPublication()
			
			//Verify created communication publications
			.verifyCommPublicationsIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
			
			//Add duplicate communication
			//Click on add new Communication/Publications
			.clicAddCommunicationPublication()
		    
			//Select "Roster-Hierarchy Roster" as Communication then save
			.typeCommunicationPublication(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
			
			//Click on Save
			.clickSaveInCommunicationPublication()
			
			//clickSaveDuplicateDetected
			.clickSaveDuplicateDetected()
			
			//Verify duplicate communication is accepted
			.verifyDuplicateCommPublicationsIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))

	    ;
	}
}
