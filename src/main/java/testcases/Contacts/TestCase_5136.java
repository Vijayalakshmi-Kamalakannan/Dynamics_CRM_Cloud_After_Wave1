package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

//******COMPLETED******

//TFS ID_ 5136:Automation :Restrict when user enters blank job function in Contact account associations

public class TestCase_5136 {

	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException {

		// 1. Login to CRM as Member supervisor
		new LoginPage().typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
				.clickNext().typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
				.clicSignin().clicYesInStaySignedin()

				// Go to Contacts
				.selectContacts()

				// 2. Go to any active contact which has an active contact account association
				.chooseActiveContact(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

				// Click on Contact Account association record created
				.doubleClickOnCAARecord()

				// Click on Add new Job function
				.clickAddJobFunction()

				// 3.Try to enter blank Job function in the contact account association and save
				// Select "" as Job function and click on Save
				.typeJobFunction(DataInputProvider.getCellData_ColName(iRowNumber, "jobFunction", sDataSheetName))

				// Click on save
				.clickSaveInJobFunction()

				// Verify error message
				.verifyErrorInJobFunction(
						DataInputProvider.getCellData_ColName(iRowNumber, "errorMessage", sDataSheetName))
				
				.clickSignout();
	}
}
