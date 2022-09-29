package testcases.MemberAttribute;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//Test Case 3269:Verify a supplier cannot have member attribute


public class TestCase_3269 {

	@Test
	public void verifyGPORebate(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		new LoginPage()
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()
		.clicYesInStaySignedin()

		//2. From the left navigation column ,Go to Accounts > +New
		.selectAccountsTab()
		.clickNewOnAccountsPage()
		.chooseSupplierForm()

		//3. Account  Type = Member
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))

		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
		//DPRD = Current date
		.selectDPParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "directParentRelationDate", sDataSheetName))

		//TPRD =  Current date
		.pickTPRD( DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelationDate", sDataSheetName))

		.clickSave()

		.clickDiversityInformation()
		.verifyMemberAttribute()
		;

	}	
}