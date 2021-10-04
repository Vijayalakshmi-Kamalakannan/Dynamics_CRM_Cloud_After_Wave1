package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//Test Case 7608:Create a new contact and add job function and communication/publication

public class TestCase_7608 {
	
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Go to Workplace > Contacts > +New 
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
			
		//4. Observe the Innovatix Contact ID field
		.isInnovatixContactIDDisplayed()
		
		//5. Change the record start from Draft to Published then save
		    .chooseRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatus", sDataSheetName))  
	    
		    //Click on Save
			.clickSave()
			
			//clickSaveDuplicateDetected
			.clickSaveDuplicateDetected()
			
			//Click on refresh
			.pageRefresh()
		    
	    //6. Click on Contact Account association record created
			.doubleClickOnContactAccountAssociationRecord()
		    
		//7. Click on Add new Job function
			.clicAddJobFunction()
		    
		//8. Select "Bid Proposal Team" as Job function and click on Save
			.typeJobFunction(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
			//Click on Save
			.clickSaveInJobFunction()
			
			//Verify created job function
			.verifyJobFunctionIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))
			
		//9. Click on add new Communication/Publications
			.clicAddCommunicationPublication()
		    
		//10. Select "Roster-Hierarchy Roster" as Communication then save
			.typeCommunicationPublication(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
			
			//Click on Save
			.clickSaveInCommunicationPublication()
			
			//Verify created communication publications
			.verifyCommPublicationsIsCreated(DataInputProvider.getCellData_ColName(iRowNumber, "communicationPublication", sDataSheetName))
	    ;
	}
}
